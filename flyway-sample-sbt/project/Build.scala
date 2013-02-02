/**
 * Copyright (C) 2010-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.googlecode.flyway.sbt.FlywayPlugin._
import sbt._
import sbt.Keys._
import scala._
import scala.Some

object FlywaySampleSbt extends Build {

  val flywayVersion = IO.readLines(new File("target/classes/version.txt")).head

  lazy val project = Project(
    "project",
    file("."),
    settings = Defaults.defaultSettings ++ flywaySettings ++ Seq(
      version := flywayVersion,
      flywayUrl := "jdbc:hsqldb:file:target/flyway_sample;shutdown=true",
      flywayUser := "SA",
      flywayPassword := "",
      flywayLocations := Some(Seq("com/googlecode/flyway/sample/migration/sbt"))
    )
  )
}
