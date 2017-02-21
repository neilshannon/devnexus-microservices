import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import AssemblyKeys._


val ScalatraVersion = "2.5.0"

ScalatraPlugin.scalatraSettings

assemblySettings

organization := "com.ntsdev"

name := "devnexus-microservices-scala"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

resolvers += Classpaths.typesafeReleases

scalacOptions ++= Seq("-Xmax-classfile-name", "200")

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-json" % ScalatraVersion,
  "org.json4s"   %% "json4s-jackson" % "3.3.0",
  "org.reactivemongo" %% "reactivemongo" % "0.11.14",
  "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container;compile",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)

enablePlugins(JettyPlugin)
