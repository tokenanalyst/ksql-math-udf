lazy val commonSettings = Seq(
  organization := "io.tokenanalyst",
  version := "0.0.1",
  scalaVersion := "2.12.6",
  description := "ksql math udfs")

lazy val udfs = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    assemblyJarName in assembly := "ta-math-udfs.jar",
    assemblyMergeStrategy in assembly := {
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
  "org.scalatest" %% "scalatest" % "3.0.4" % Test
)


