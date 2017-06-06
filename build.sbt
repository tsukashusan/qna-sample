import sbtassembly.AssemblyPlugin.autoImport._


EclipseKeys.skipParents in ThisBuild := false

lazy val commonSettings = Seq(
  name := """qna-hello""",
  version := "1.0-SNAPSHOT",
  organization := "com.example",
  scalaVersion := "2.11.11",
  test in assembly := {},
  libraryDependencies ++= Seq(filters,
                              "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test,
  			      "com.microsoft.azure" % "azure" % "1.0.0"),
  assemblyMergeStrategy in assembly := {
    case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".properties" => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".xml" => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".types" => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".class" => MergeStrategy.first
    case "application.conf"                            => MergeStrategy.concat
    case "unwanted.txt"                                => MergeStrategy.discard
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  },
  mainClass in assembly := Some("play.core.server.ProdServerStart"),
  fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value)
)

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(commonSettings)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"



//lazy val app = (project in file("app")).
//  settings(commonSettings: _*).
//  settings(
//    mainClass in assembly := Some("play.core.server.ProdServerStart"),
//    fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value)
//  )
//
//