Mars Journey
---
Mars Journey is a RESTful webservice to send commands to Mars Explorer.  
Let's help NASA with this little poor explorer far far away from home.

Technologies
---
- [Java EE](http://www.oracle.com/technetwork/java/javaee/overview/index.html)
- [JUnit](http://junit.org)
- [Maven](https://maven.apache.org)
- [JBoss WildFly](http://wildfly.org)

Build & Run
---
This project use [Maven](https://maven.apache.org) for build and dependency management.  
#####Build  
```
$ mvn clean package
```
#####Run
To run this project you can use two approaches:
 - Configure the JBoss WildFly at your favorite IDE, add the mars-journey project in the server and run.  
 - Deploy the generated .war from ${baseDir}/target into your WildFly server.

Packages
---
At this session I'll be explaining the project package structure.
- com.nasa: *Root package*
  - business: *The Business layer*
  - config: *Contains the Startup class*
  - exception: *Custom Exceptions*
  - model: *Model layer* 
    - beans: *Model beans - Could be entities if we were using any database*
    - enums: *Model Enums - Invariable values*
    - repository: *Data repository - Just a fake InMemory repository to keeps the Mars explorer*
  - service: *Services to access repository layer*
  - validator: *Validations classes*
  - web: *Web layer*
    - provider: *Exception handler provider*
    - resources: *Web Resources*
    
Resources
---
At this session you'll find the available endpoints to route Mars Explorer.

* Get the current Explorer position  
```
$ curl -i -X GET http://localhost:8080/rest/mars
  
  HTTP/1.1 200 OK
  Connection: keep-alive
  X-Powered-By: Undertow/1
  Server: WildFly/9
  Content-Type: application/json
  Content-Length: 41
  Date: Sat, 05 Dec 2015 22:04:20 GMT

  {"axisX":0,"axisY":0,"direction":"NORTH"}
```
* Rotate  
You can rotate left and right by sending L or R values on path param
```
$ curl -i -X GET http://localhost:8080/rest/mars/L
  
  HTTP/1.1 200 OK
  Connection: keep-alive
  X-Powered-By: Undertow/1
  Server: WildFly/9
  Content-Type: application/json
  Content-Length: 40
  Date: Sat, 05 Dec 2015 22:08:22 GMT

  {"axisX":0,"axisY":0,"direction":"WEST"}
```
```
$ curl -i -X GET http://localhost:8080/rest/mars/R
  
  HTTP/1.1 200 OK
  Connection: keep-alive
  X-Powered-By: Undertow/1
  Server: WildFly/9
  Content-Type: application/json
  Content-Length: 40
  Date: Sat, 05 Dec 2015 22:08:59 GMT
  
  {"axisX":0,"axisY":0,"direction":"EAST"}
```
* Move  
You can move the explorer by sending the value M on path param
```
$ curl -i -X GET localhost:8080/rest/mars/M
  HTTP/1.1 200 OK
  Connection: keep-alive
  X-Powered-By: Undertow/1
  Server: WildFly/9
  Content-Type: application/json
  Content-Length: 41
  Date: Sat, 05 Dec 2015 22:13:30 GMT
  
  {"axisX":0,"axisY":1,"direction":"NORTH"}
```
You can combine Rotate (L/R) and Move (M) to make complex movements.
```
$ curl -i -X GET http://localhost:8080/rest/mars/MMRMMRMM
  HTTP/1.1 200 OK
  Connection: keep-alive
  X-Powered-By: Undertow/1
  Server: WildFly/9
  Content-Type: application/json
  Content-Length: 41
  Date: Sat, 05 Dec 2015 22:17:15 GMT
  
  {"axisX":2,"axisY":0,"direction":"SOUTH"}
```
* Reset  
This endpoint sends the explorer to initial entry point.
```
$ curl -i -X POST http://localhost:8080/rest/mars/reset
  HTTP/1.1 200 OK
  Connection: keep-alive
  X-Powered-By: Undertow/1
  Server: WildFly/9
  Content-Type: application/json
  Content-Length: 41
  Date: Sat, 05 Dec 2015 22:17:46 GMT
  
  {"axisX":0,"axisY":0,"direction":"NORTH"}
```

Errors
---