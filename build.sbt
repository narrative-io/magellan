import sbtassembly.MergeStrategy
import _root_.io.narrative.build._

scalaVersion := "2.12.11"

name := "magellan"
version := "1.0.7-SNAPSHOT"
organization := "harsha2010"
parallelExecution in Test := false
licenses += "Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0")

lazy val sparkVersion = "3.0.0"
lazy val hadoopVersion = "3.1.2"

lazy val root = (project in file("."))
  .enablePlugins(LibraryProjectPlugin)
  .settings(
    scalacOptions --= Seq(
      "-Ywarn-unused:params",
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:privates",
      "-Ywarn-unused:params",
      "-Xlint",
      "-Xfatal-warnings"
    ),
    libraryDependencies ++= Seq(
      "commons-io" % "commons-io" % "2.6",
      "com.google.guava" % "guava" % "27.1-jre",
      "org.slf4j" % "slf4j-api" % "1.7.16" % "provided",
      "com.lihaoyi" %% "fastparse" % "0.4.4", // TODO(mbabic) change away from provided
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
      "com.vividsolutions" % "jts" % "1.13" % "test",
      "com.esri.geometry" % "esri-geometry-api" % "1.2.1",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.11.2",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.2",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.11.2",
      "com.fasterxml.jackson.jaxrs" % "jackson-jaxrs-base" % "2.11.2",
      "com.fasterxml.jackson.jaxrs" % "jackson-jaxrs-json-provider" % "2.11.2",
      "com.fasterxml.jackson.module" % "jackson-module-paranamer" % "2.11.2",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.2",
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-sql" % sparkVersion,
      "org.apache.hadoop" % "hadoop-client" % hadoopVersion % "test"
    )
  )
