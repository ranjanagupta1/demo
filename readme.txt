--MySQL
--Spring Boot
--https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
--Data transfer object-used to convert the data coming from DB into format which needs to be shared with client
--ORM- using API JPA which has hibernate(https://www.youtube.com/watch?v=hM9wkQBFdDw). It acts as a middleware for DB and our app so that in future if DB will get changed to another one(like mysql to oracle DB2)
--Spring MVC

Shortcuts keys--------------------

Auto Import----------- Alt+Enter
Getter/Setter--------- Alt+Insert
println -------------- sout->tab
main method- ----------psvm->Enter or main->Enter
Formatting- ---------  Cntl+shift+F
Delete Line- ----------Cntl+D
Suggestion ------------Cntl+SpaceKey
Refactor(change at all places- Cntl+Shft+R

REST-
1. RestAssured Library
2. Testng Library
3. Hamcrest Library
        <!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest Used to match JSON response to actual response while automating rest-->
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
        </dependency>
