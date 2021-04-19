resolvers ++= Seq(
  "Narrative Releases plugins" at "s3://s3.amazonaws.com/narrative-artifact-releases"
)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
addSbtPlugin("io.narrative" % "common-build" % "3.2.0")
