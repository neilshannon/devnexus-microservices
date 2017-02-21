package com.ntsdev.mongo

import com.typesafe.config.{Config, ConfigFactory}
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.Future


trait MongoSupport {

  import scala.concurrent.ExecutionContext.Implicits.global

  private val config: Config = ConfigFactory.systemEnvironment().withFallback(ConfigFactory.load())
  private val list = config.getConfigList("mongoConfigs")
  private val mongoUri = list.get(0).getString("credentials.uri")

  private val driver = new MongoDriver

  private val parsedUri = MongoConnection.parseURI(mongoUri)
  private val connection = parsedUri.map(driver.connection(_))
  private val futureConnection = Future.fromTry(connection)

  private val devNexusDb: Future[DefaultDB] = for {
    uri <- Future.fromTry(MongoConnection.parseURI(mongoUri))
    con = driver.connection(uri)
    dn <- Future(uri.db.get)
    db <- con.database(dn)
  } yield db

  def personCollection: Future[BSONCollection] = devNexusDb.map(_.collection("person"))

}
