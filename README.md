# bloom-filter-service

## Description
Job of this service is to check whether a username is up for grab using bloom filters concept.
This is a spring boot project using spring-jpa(with hibernate) to access database.

It will have two endpoints:

1) /api/v1/bloom/add?name=<username> : To Add username to database
2) /api/v1/bloom/check/{name} : To check if the name is available

## How to run the project

1) Update database information under application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/<database_name>
spring.datasource.username=<login/group username>
spring.datasource.password=<password>
```

2) Build the project:
```
./gradlew build
```
3) Project can be run using following command:

```
./gradlew bootRun
```
4) Application will be started at port 8080 on localhost : http://localhost:8080/


## Learnings while making project

### Spring Hibernate or JPA
1) spring.datasource.username -> This can be found under Login/Group Roles for postgres under DB server.
2) spring.jpa.hibernate.ddl-auto=update -> Adding this property. Hibernate will create the tables based on the entity class added.
3) Better create tables from the entity class, otherwise hibernate errors come if firstly the table is created in DB. The table configurations
need to match with the one in the entity. Hard to detect the exact error or mismatch.




