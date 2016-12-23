package com.ntsdev

import org.scalatra.test.specs2._
import org.json4s.{DefaultFormats, Formats}
import org.json4s._
import org.json4s.jackson.JsonMethods._

class MyScalatraServletSpec extends MutableScalatraSpec  {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  addServlet(classOf[MyScalatraServlet], "/*")

  "GET /hello on MyScalatraServlet" should {
    "return status 200" in {
      get("/hello?name=Neil") {
        status must_== 200
        val json = parse(response.body)
        json.extract[Hello] shouldEqual Hello("Hello Neil")
      }
    }
  }
}
