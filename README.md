Mars Journey
---
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
1. Configure the JBoss WildFly at your favorite IDE, add the mars-journey project in the server and run.
2. Deploy the generated .war from ${baseDir}/target into your WildFly server.

Packages
---
At this session I'll be explaining the project package structure.
- com.nasa *Root package*
  - business *The Business layer*
  - config *Contains the Startup class*
  - exception *Custom Exceptions*
  - model 
    - beans *Model beans - Could be entities if we were using any database*
    - enums *Model Enums - Invariable values*
    - repository *Data repository - Just a fake InMemory repository to keeps the Mars explorer robot and the routing trace"
  - service *Services to access repository layer*
  - validator *Validations classes*
  - web *Web layer*
    - provider *Exception handler provider*
    - resources *Web Resources*