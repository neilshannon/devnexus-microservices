# DevNexus - Building Microservices in Java, Scala, Ruby, and node.js #

## Java ##
The Java portion of this project runs in Spring Boot and uses Spring Data MongoDB and Spring REST.  The tests expect a local running copy of MongoDB in order to test properly.

**To Run**
`./gradlew bootRun`

**To Test**
`./gradlew test`

## Scala ##
The Scala portion of this project runs on Scalatra

**To Run**
`./sbt jetty:start`

**To Test**
`./sbt test`