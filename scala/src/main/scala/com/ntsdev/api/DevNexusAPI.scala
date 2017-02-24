package com.ntsdev.api

import com.ntsdev.service.PeopleService
import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.json._

import scala.concurrent.ExecutionContext

class DevNexusAPI extends ScalatraServlet with JacksonJsonSupport with FutureSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  override val executor: ExecutionContext = ExecutionContext.global

  before() {
    contentType = formats("json")
  }

  get("/people") {
    PeopleService.findAll()
  }

  get("/people/firstName/:firstName") {
    import scala.concurrent.ExecutionContext.Implicits.global
    PeopleService.findByFirstName(params("firstName")).map(_.getOrElse(NotFound()))
  }

}
