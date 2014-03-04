name := "Kennerspiel-Agricola2p"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.guava" % "guava" % "15.0",
  "kennerspiel-interface" % "kennerspiel-interface_2.10" % "1.0-SNAPSHOT"
)

play.Project.playJavaSettings

//resolvers += "philihp" at "https://philihp.com/repo/"

//publishTo := Some(Resolver.file("file", new File("/srv/www/philihp.com/public_html/repo")))
