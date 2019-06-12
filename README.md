Angularjs-v1-bundle API for Scala.js
================================
angularjs-v1-bundle - The Angular.js platform bundle

### Description

The Angular.js platform bundled as a single SBT dependency.

### Build Dependencies

* [SBT v1.2.8](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
 $ npm install
```

Then you can run the tests:

```bash
 $ sbt test
```

### Artifacts and Resolvers

To add the `Angularjs-v1-bundle` binding to your project, add the following to your build.sbt:

```sbt
libraryDependencies += "io.scalajs.npm" %%% "angularjs-v1-bundle" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt
resolvers += Resolver.sonatypeRepo("releases")
```
