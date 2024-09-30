# PGR209 Exam Project

This repository contains the Spring Boot application for the PGR209 exam project. The application is a REST API for a machine order system, built using Java with Spring Boot.

## Running the Application

To run the application:

1. Navigate to the `Pgr209Exam23Application` class.
2. Execute the `main` method within the class to start the Spring Boot application.

Once the application is running, you can access the H2 database console at the following URL:
http://localhost:8080/h2-console

Use the default connection settings provided by Spring Boot to connect to the in-memory H2 database. 

## Running Tests

To run the suite of tests:

1. Open the terminal at the root of the project.
2. Execute the Maven command:
`mvn test`

This will trigger the execution of unit and integration tests within the application.

## Example of how to create/post an order in postman: 

```json
{
  "customer": {
    "customerId": 1
  },
  "orderDate": "2023-11-10T18:07:05",
  "machines": [
    {
      "machineId": 1
    }
  ]
}
```

## Example of how to create/post a machine with subassemblies in postman
```json
{
  "machineName": "Robot cat",
  "description": "A cool toy for kids!"
}
```
Once a machine is created, you can add subassemblies to it. For example, for a machine with machineId 2, use:
```json
{
  "subassemblyName": "Robotic cat head",
  "machine": {
    "machineId": 2
  }
}
```
```json
{
  "subassemblyName": "Robotic cat tail",
  "machine": {
    "machineId": 2
  }
}
```


## Issues Encountered 

### Displaying Address Information for Customers
#### Initial Approach
When attempting to display address information for customers through a GET request, we initially implemented a many-to-many relationship and introduced an additional table called "create_customer_address."

#### Revised Approach
After realizing that the initial many-to-many setup wasn't suitable, we decided to switch to a more appropriate one-to-many and many-to-one relationship. As a result, customer information is successfully displayed when making a GET request on an address. However, the reverse operation is still not working properly.

### Displaying Orders for Customers
Efforts were made to display order information when making a GET request for a customer, but the implementation was unsuccessful. However, when executing a GET request on an order, the customer information is successfully presented.

### Challenges with Part and Subassembly Relationship
We encountered difficulties in establishing a direct link between Part and Subassembly.Our initial approach involved establishing a @OneToMany relationship from Subassembly to Part and a corresponding @ManyToOne relationship from Part back to Subassembly. However, we encountered issues with this approach. Specifically, when fetching Subassembly entities, the associated Parts were not being correctly loaded or represented. This problem suggested potential issues in our JPA configuration, object-relational mapping, or in the way we were handling the lazy loading of entities.

## Sources

The implementation is based on the knowledge acquired from lectures throughout the course, as well as prior experience. The application adheres to the principles and patterns introduced during the course. 

https://github.com/jlwcrews2/vet-clinic/tree/main
https://www.baeldung.com/spring-boot-h2-database
https://www.tutorialspoint.com/spring_boot/spring_boot_flyway_database.htm
Lecture 16 By teacher Jason Williams


---


