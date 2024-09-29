# Getting started.
### Links
1. [Youtube Tutorial](https://www.youtube.com/watch?v=NpdG3lmKJ5g&list=PLSVW22jAG8pDeU80nDzbUgr8qqzEMppi8&index=1&ab_channel=ProgrammingTechie)
2. [Starter project](https://start.spring.io/)

### dependencies
1. Lombok
2. Spring Web
3. mysql jpa
4. flyway
4. testcontainers

### Commands
```
brew install maven
mvn clean install
mvn clean compile
```
- Start docker
```
docker compose up -d
```
- start mysql in mac
```
 brew service start mysql
```

## DB creation Steps
1. Create 'order_service' table in mysql
2. run the app, flyway will automatically create table rows. Make sure you have resources\db\migration\V1__init.sql file