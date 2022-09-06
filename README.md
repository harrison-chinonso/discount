# Store Bill Discount System.

### Below are instructions on how the system is designed to work as the product requirements states.

## Execution of Tests
Junit and Mockito frameworks was used to write the unit tests.

### Run test using maven command
mvn clean test

### Run test with coverage using maven command
mvn test

### and get test report on
./target/site/jacoco/*.html

## RUN APPLICATION

### Package project using maven command
mvn package

### Start project using maven command
mvn spring-boot:run

## Documentation
### FEATURES IMPLEMENTED
On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

### Required Activities
* Object oriented programming approach, provide a high level UML class diagram of 
all the key classes in your solution. This can either be on paper or using a CASE tool
* Unit tests to achieve good code coverage, good use of Mocking
* Code to be generic and simple
* Leverage today's best coding practices
* Clear README.md that explains how the code and the test can be run and how the coverage reports can be generated
