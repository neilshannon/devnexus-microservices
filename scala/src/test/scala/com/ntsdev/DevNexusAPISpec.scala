package com.ntsdev

import com.ntsdev.api.DevNexusAPI
import com.ntsdev.model.Person
import org.scalatra.test.specs2._
import org.json4s.{DefaultFormats, Formats}
import org.json4s._
import org.json4s.jackson.JsonMethods._

class DevNexusAPISpec extends MutableScalatraSpec  {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  addServlet(classOf[DevNexusAPI], "/*")

  "GET /people on DevNexusAPI" should {
    "find all people" in {
      get("/people") {
        status must_== 200
        val json = parse(response.body)
        json.extract[List[Person]] shouldEqual List(Person("Neil", "Shannon"))
      }
    }
    "find one person by first name" in {
      get("/people/firstName/Neil") {
        status must_== 200
        val json = parse(response.body)
        json.extract[Person] shouldEqual Person("Neil", "Shannon")
      }
    }
    "not find a person that doesn't exist" in {
      get("/people/firstName/Bob") {
        status must_== 404
      }
    }
  }
}
