package com.ntsdev.run

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

object JettyLauncher {
  def main(args: Array[String]): Unit = {

    val port = getServerPort
    val context = buildContext

    val server = new Server(port)
    server.setHandler(context)
    server.start()
    server.join()
  }

  private def buildContext = {
    val context = new WebAppContext()
    context.setContextPath("/")
    context.setResourceBase("src/main/webapp")
    context.addEventListener(new ScalatraListener)
    context.addServlet(classOf[DefaultServlet], "/")
    context
  }

  private def getServerPort = {
    Option(System.getenv("PORT")).map(_.toInt).getOrElse(8080)
  }

}
