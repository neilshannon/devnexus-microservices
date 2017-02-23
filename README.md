# DevNexus - Building Microservices in Java, Scala, Ruby, and node.js #

## Pre-requisites#

Developed and tested with the following software:

- a bash-like shell (macOS Sierra 10.12.3)

- cloud foundry command line interface installed

```sh
$ brew tap cloudfoundry/tap
$ brew install cf-cli
$ cf -v
cf version 6.23.0+c7866be18-2016-12-22
```
via homebrew or download and install from: https://github.com/cloudfoundry/cli#downloads 

- mongodb 3.4.0 running locally

```sh 
$ brew install mongodb
$ mongod
```

via homebrew or download and install from: https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

- git

```sh 
$ git --version
git version 2.10.1

```
via homebrew or download and install from: https://git-scm.org

- jdk 1.8+

```sh
$ java -version
java version "1.8.0_112"
Java(TM) SE Runtime Environment (build 1.8.0_112-b16)
Java HotSpot(TM) 64-Bit Server VM (build 25.112-b16, mixed mode)
```

on the following languages:
- scala 2.11.8
- sbt 0.13.13
- ruby 2.4.0
- node 7.5.0

## Java ##
The Java portion of this project runs on Spring Boot and uses Spring Data MongoDB and Spring REST.  Cloud configuration is provided by Spring Cloud Connectors.  The tests expect a local running copy of MongoDB in order to test properly.

**To Run**
`./gradlew bootRun`

**To Test**
`./gradlew test`

**To Package for Deployment**
`./gradlew build`

## Scala ##
The Scala portion of this project runs on Scalatra with ReactiveMongo for asynchronous persistence.

**To Run**
`./sbt ~jetty:start`

**To Test**
`./sbt test`

**To Package for Deployment**
`./sbt clean assembly`

## Ruby ##
The Ruby portion of this project runs on Sinatra.

**Prerequisites**
```sh
$ sudo gem install bundler`
$ bundle install
```

**To Run**
`bundle exec thin start`

**To Test**
`bundle exec test`


