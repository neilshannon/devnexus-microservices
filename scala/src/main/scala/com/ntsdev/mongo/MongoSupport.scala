package com.ntsdev.mongo

import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.Future


trait MongoSupport {

  import scala.concurrent.ExecutionContext.Implicits.global

  val mongoUri = "mongodb://localhost"
  val driver = new MongoDriver

  private val parsedUri = MongoConnection.parseURI(mongoUri)
  private val connection = parsedUri.map(driver.connection(_))
  private val futureConnection = Future.fromTry(connection)

  def devNexusDb: Future[DefaultDB] = futureConnection.flatMap(_.database("devnexus"))
  def personCollection: Future[BSONCollection] = devNexusDb.map(_.collection("person"))

}
