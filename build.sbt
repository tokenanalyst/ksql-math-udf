lazy val commonSettings = Seq(
  organization := "io.tokenanalyst",
  version := "0.0.1",
  scalaVersion := "2.12.6",
  description := "ksql math udfs")

lazy val udfs = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    assemblyJarName in assembly := "ta-udfs.jar",
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", "io.netty.versions.properties", xs@_*) => MergeStrategy.first
      case PathList("com", "typesafe", "scalalogging", xs@_*) => MergeStrategy.first
      case PathList("org", "xerial", xs@_*) => MergeStrategy.first
      case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    }
  ).
  settings(
    resolvers += "confluent.io" at "http://packages.confluent.io/maven/"
  ).
  settings(
    libraryDependencies ++= Seq(
      "io.confluent.ksql" % "ksql-udf" % "5.0.0"
    ) ++ testDeps
  )

lazy val testDeps = Seq(
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.scalamock" %% "scalamock" % "4.1.0" % Test
)


