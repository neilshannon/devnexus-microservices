package com.ntsdev.mongo

import com.typesafe.config.{Config, ConfigFactory}
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.Future


trait MongoSupport {

  import scala.concurrent.ExecutionContext.Implicits.global

  val config: Config = ConfigFactory.systemEnvironment().withFallback(ConfigFactory.load())
  val list = config.getConfigList("mongoConfigs")
  val mongoUri = list.get(0).getString("credentials.uri")

  val driver = new MongoDriver

  private val parsedUri = MongoConnection.parseURI(mongoUri)
  private val connection = parsedUri.map(driver.connection(_))
  private val futureConnection = Future.fromTry(connection)

  def devNexusDb: Future[DefaultDB] = futureConnection.flatMap(_.database("devnexus"))
  def personCollection: Future[BSONCollection] = devNexusDb.map(_.collection("person"))

}
