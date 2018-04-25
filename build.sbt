val generalSettings = Seq(
  name := "hello-scala",
  version := "1.0",
  scalaVersion := "2.11.10",
  libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11"
)

lazy val root = project.in(file("."))
  .settings(generalSettings)
