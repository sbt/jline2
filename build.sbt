val jansi = "org.fusesource.jansi" % "jansi" % "2.4.1"
val junit = "com.novocode" % "junit-interface" % "0.11"
val easymock = "org.easymock" % "easymock" % "3.3.1"
val powermockVersion = "1.6.2"
val powermockJunit4 = "org.powermock" % "powermock-module-junit4" % powermockVersion
val powermockEasymock = "org.powermock" % "powermock-api-easymock" % powermockVersion

val root = (project in file("."))
  .enablePlugins(GitVersioning)
  .settings(
    git.baseVersion := "2.14.7-sbt",
    name := "jline",
    autoScalaLibrary := false,
    crossPaths := false,
    libraryDependencies += jansi,
    libraryDependencies ++= Seq(
      junit % Test,
      easymock % Test,
      easymock % Test,
      powermockJunit4 % Test,
      powermockEasymock % Test
    ),
    Compile / javacOptions ++= Seq("-source", "1.6", "-target", "1.6"),
    Compile / doc / javacOptions := Nil,
    Test / parallelExecution := false,
    Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat,
  )

ThisBuild / organization := "org.scala-sbt.jline"
ThisBuild / organizationHomepage := Some(url("https://scala-sbt.org/"))
ThisBuild / homepage := Some(url("https://github.com/sbt/jline2"))
ThisBuild / description := "patched jline2 for sbt"
ThisBuild / licenses := List("The BSD License" -> url("http://www.opensource.org/licenses/bsd-license.php"))
ThisBuild / scmInfo := Some(ScmInfo(url("https://github.com/sbt/jline2"), "git@github.com:sbt/jline2.git"))
ThisBuild / developers := List(
  Developer("eed3si9n", "Eugene Yokota", "@eed3si9n", url("https://github.com/eed3si9n")),
  Developer("eatkins", "Ethan Atkins", "@eatkins", url("https://www.ethanatkins.com")),
)
ThisBuild / pomIncludeRepository := { _ =>
  false
}
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  // if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots") else
  Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
