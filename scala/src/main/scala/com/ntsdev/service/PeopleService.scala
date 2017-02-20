package com.ntsdev.service

import com.ntsdev.model.Person
import com.ntsdev.mongo.MongoSupport
import reactivemongo.bson.{BSONDocument, BSONDocumentReader, Macros}

import scala.concurrent.{ExecutionContext, Future}

object PeopleService extends MongoSupport {

  implicit val executionContext: ExecutionContext = ExecutionContext.Implicits.global

  implicit def personReader: BSONDocumentReader[Person] = Macros.reader[Person]

  def findAll(): Future[List[Person]] = {
    personCollection.flatMap(_.find(BSONDocument()).cursor[Person]().collect[List]())
  }
}
