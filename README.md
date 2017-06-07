# This is Bot Framework & QnA Maker sample source.

## required
* Java8
* sbt 0.13.15

## Debug
### Eclipse
* sbt "eclipse with-source=true"
* sbt -jvm-debug 65534 ~run

or

* sbt -jvm-debug 65534  
[qna-hello] ~run

## Build
* sbt assembly

## LANCH
### EXAMPLE
* BOT\_SRC="https://webchat.botframework.com/embed/peppersample1?s=<YOUR SECRETKEY\>" java -jar target/scala-2.11/qna-hello-assembly-1.0-SNAPSHOT.jar
