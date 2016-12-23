package com.ntsdev

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class MyScalatraServlet extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/hello") {
    Hello(s"Hello ${params("name")}")
  }

}

case class Hello(greeting: String)
