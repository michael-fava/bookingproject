# Booking Project

Contact Email: mfava85@gmail.com

## Tech Stack

- Java 11
- RabbitMQ
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Feign Client
- Orika
- Lombok
- Swagger

## Structure

Project is split in 3 modules:

- booking-contract
- booking-core
- booking-api


## Development
________________________________________________________________________________

### Booking Contract

Booking-Contract is a library shared between booking-core and booking-api designed to be as a collection of objects used in integration across the microservices.

#### Execution

This is a non-executable module.

### Booking Core

Booking-Core as the name implies is the heart of the project. 

#### Execution

Executes as a spring-boot application on port 8080.

### Rabbit Topology
The rabbit exchange and queue topology is designed as follows. 
`message-exchange` is a FanoutExchange which broadcasts all messages matching `booking.*` to `message-audit-queue` and `booking-exchange`.
Subsequently `booking-exchange` is a DirectExchange which routes messages to 3 queues as below:

- `booking.add`  -> `booking-add-queue`
- `booking.edit`  -> `booking-edit-queue`
- `booking.delete`  -> `booking-delete -queue`

### Database
The current data model consists of two entites `booking` and `tripwaypoint`. A booking has a list of waypoints amongst other properties and each waypoint is bound to a single booking.
Database is implemented using H2 in memory and entities are accessed using Spring Data JPA. CRUD operations are supported and deleted is implemented via soft-deleted i.e. maintaining a `deleted` boolean flag.



### Booking API

Booking-API provides a REST api to perform CRUD operations on the booking system.

BaseURL: http://localhost:8081/bookings

#### Execution

Executes as a spring-boot application on port 8081.

#### Documentation

Swagger documentation providerd @ below url.

http://localhost:8081/swagger-ui.html 

#### Integration to Booking-Core

Create, Update and Delete operations are integrated via messaging whilst Read operations are integrated via Feign-Client.