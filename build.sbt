name := "hello-scala"
version := "1.4"
organization := "fakepath.test"
scalaVersion := "2.11.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"
publishTo := {
val nexus = "https://" + System.getenv("NEXUS_IP") + ":8081/nexus/"
if (isSnapshot.value)
Some("snapshots" at nexus + "content/repositories/snapshots")
  else
Some("releases"  at nexus + "content/repositories/releases")

System.getenv("NEXUS_USER"), System.getenv("NEXUS_PASSWORD"))
