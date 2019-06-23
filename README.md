## Point of Interest Project [![Build Status](https://travis-ci.org/leonardo-mendes/-xy-inc.svg?branch=master)](https://travis-ci.org/leonardo-mendes/-xy-inc) [![codecov](https://codecov.io/gh/leonardo-mendes/-xy-inc/branch/master/graph/badge.svg)](https://codecov.io/gh/leonardo-mendes/-xy-inc)

This is an application challenge for Zup It Innovation, this challenge is to build an application to insert points of interest and retrieve them by filtering their shortest distance.

#### Tools to execute the project
- Java 8
- Docker-compose
- Maven

#### Executing the project
- Clone the [repository](https://github.com/leonardo-mendes/-xy-inc)
- Open the project folder
- Execute the script <em>initChallenge.sh</em>

```
sh initChallenge.sh - After script execution, please check the container zup/xyinc (docker ps).
``` 

#### Documentation

This application use Swagger2, so after up the application image to look the endpoints, is necessary access:

```
http://172.32.0.101:8080/swagger-ui.html
```

##### Resources


Java 8, H2 Database, Maven, Lombok, SpringBoot, Docker, Docker Compose, Junit, Mockito, Swagger2, Mapstruct.