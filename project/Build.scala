import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "travel-mgmt2"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean, 
    "mysql" % "mysql-connector-java" % "5.1.18",
    "com.google.code.gson" % "gson" % "2.2.2",
    //"pdf" % "pdf_2.10" % "0.4.1",
    //"be.objectify" %% "deadbolt-java" % "2.1.2",
    //"be.objectify" %% "deadbolt-scala" % "2.1.2",
    "commons-beanutils" % "commons-beanutils" % "1.8.3"
    //"org.st-js" % "maven-plugin" % "1.3.0"

  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
  	resolvers += Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),
    resolvers += Resolver.url("play-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns),
  	resolvers += Resolver.url("Objectify Play Repository", new URL("http://deadbolt.ws/releases/"))(Resolver.ivyStylePatterns),
	resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.io/releases/"))(Resolver.ivyStylePatterns)
  
  )

}
