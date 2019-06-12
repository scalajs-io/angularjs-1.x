import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.{libraryDependencies, _}
import sbt._

import scala.language.postfixOps

val scalaJsIOVersion = "0.5.0"
val scalaJsVersion = "2.12.8"

homepage := Some(url("https://github.com/scalajs-io/angularjs-v1-bundle"))

lazy val root = (project in file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(
    name := "angularjs-v1-bundle",
    organization := "io.scalajs.npm",
    description := "Angularjs-v1-bundle binding for Scala.js",
    version := scalaJsIOVersion,
    scalaVersion := scalaJsVersion,
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    autoCompilerPlugins := true,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    libraryDependencies ++= Seq(
      "io.scalajs.npm" %%% "angular" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-anchor-scroll" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-animate" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-cookies" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-file-upload" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-md5" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-nvd3" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-sanitize" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-ui-bootstrap" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angular-ui-router" % scalaJsIOVersion,
      "io.scalajs.npm" %%% "angularjs-toaster" % scalaJsIOVersion,
      "org.scala-lang" % "scala-reflect" % "2.12.8",
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
    ))

/////////////////////////////////////////////////////////////////////////////////
//      Publishing
/////////////////////////////////////////////////////////////////////////////////

lazy val publishingSettings = Seq(
  sonatypeProfileName := "org.xerial",
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <url>https://github.com/scalajs-io/angularjs-v1-bundle</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/scalajs-io/angularjs-v1-bundle.git</connection>
        <developerConnection>scm:git:git@github.com:scalajs-io/angularjs-v1-bundle.git</developerConnection>
        <url>github.com/scalajs-io/angularjs-v1-bundle.git</url>
      </scm>
      <developers>
        <developer>
          <id>ldaniels528</id>
          <name>Lawrence Daniels</name>
          <email>lawrence.daniels@gmail.com</email>
          <organization>io.scalajs</organization>
          <organizationUrl>https://github.com/scalajs-io</organizationUrl>
          <roles>
            <role>Project-Administrator</role>
            <role>Developer</role>
          </roles>
          <timezone>+7</timezone>
        </developer>
      </developers>
)

// loads the Scalajs-io root project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value
