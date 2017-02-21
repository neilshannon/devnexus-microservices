package com.ntsdev.mongo

import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.LoggerFactory
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.Future
import scala.util.{Failure, Success}


trait MongoSupport {

  private val log = LoggerFactory.getLogger(getClass)

  import scala.concurrent.ExecutionContext.Implicits.global

  private val config: Config = ConfigFactory.systemEnvironment().withFallback(ConfigFactory.load())
  private val services = ConfigFactory.parseString(config.getString("vcap_services"))
  private val list = services.getConfigList("mlab")
  private val mongoUri = list.get(0).getString("credentials.uri")

  private val driver = new MongoDriver

  private val parsedUri = MongoConnection.parseURI(mongoUri)

  log.info(s"Building connection to [$mongoUri]...")

  private val devNexusDb: Future[DefaultDB] = for {
    uri <- Future.fromTry(MongoConnection.parseURI(mongoUri))
    con = driver.connection(uri)
    dn <- Future(uri.db.get)
    db <- con.database(dn)
  } yield db

  devNexusDb onComplete {
    case Success(resolved) => log.info(s"db resolved: [$resolved]")
    case Failure(ex) => log.error("failure resolving", ex)
  }

  def personCollection: Future[BSONCollection] = devNexusDb.map(_.collection("person"))

}
