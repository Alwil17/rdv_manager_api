# RDV Manager API

The **RDV Manager API** is a Spring Boot-based RESTful API designed to manage appointments, clients, reminders, and related entities. It leverages MongoDB for data persistence and integrates with MapStruct and Lombok for efficient development.

## Features

- **CRUD Operations**: Manage clients, services, slots, reservations, and reminders.
- **MongoDB Integration**: Uses MongoDB as the database for storing entities.
- **MapStruct**: Simplifies object mapping between DTOs and entities.
- **Lombok**: Reduces boilerplate code with annotations for getters, setters, constructors, etc.
- **Spring Boot**: Provides a robust and scalable framework for building RESTful APIs.

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java 17** or higher
- **Maven** (for building the project)
- **MongoDB** (running locally or remotely)

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Alwil17/rdv_manager_api.git
cd rdv_manager_api
```

### 2. Configure MongoDB
Update the MongoDB connection details in `application.yml`:
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/rdv_manager_db
```

### 3. Build the Project
Run the following command to build the project:
```bash
mvn clean install
```

### 4. Run the Application
Start the application using:
```bash
mvn spring-boot:run
```
The API will be available at `http://localhost:PORT`.

## API Endpoints

### Clients
- `POST /api/clients`: Create a new client.
- `GET /api/clients/{id}`: Retrieve a client by ID.
- `GET /api/clients`: Retrieve all clients.
- `PUT /api/clients/{id}`: Update a client.
- `DELETE /api/clients/{id}`: Delete a client.

### Services
- `POST /api/services`: Create a new service.
- `GET /api/services/{id}`: Retrieve a service by ID.
- `GET /api/services`: Retrieve all services.
- `PUT /api/services/{id}`: Update a service.
- `DELETE /api/services/{id}`: Delete a service.

### Services availability
- `POST /api/services/{serviceId}/availability`: Add availability to a service.
- `GET /api/services/{serviceId}/availability`: Retrieve a service availabilities.

### Slots
- `POST /api/slots`: Create a new slot.
- `GET /api/slots/{id}`: Retrieve a slot by ID.
- `GET /api/slots`: Retrieve all slots.
- `PUT /api/slots/{id}`: Update a slot.
- `DELETE /api/slots/{id}`: Delete a slot.

### Reservations
- `POST /api/reservations`: Create a new reservation.
- `GET /api/reservations/{id}`: Retrieve a reservation by ID.
- `GET /api/reservations`: Retrieve all reservations.
- `PUT /api/reservations/{id}`: Update a reservation.
- `DELETE /api/reservations/{id}`: Delete a reservation.

### Reminders
- `POST /api/reminders`: Create a new reminder.
- `GET /api/reminders/{id}`: Retrieve a reminder by ID.
- `GET /api/reminders`: Retrieve all reminders.
- `PUT /api/reminders/{id}`: Update a reminder.
- `DELETE /api/reminders/{id}`: Delete a reminder.

### Audit Logs
- `GET /api/audit-logs/{id}`: Retrieve an audit log by ID.
- `GET /api/audit-logs`: Retrieve all audit logs.
- `GET /api/audit-logs/entity`: Retrieve audit logs by entity name and ID.

---

## Technologies Used

- **Spring Boot**: Framework for building the API.
- **MongoDB**: NoSQL database for data persistence.
- **MapStruct**: For mapping between DTOs and entities.
- **Lombok**: For reducing boilerplate code.
- **Maven**: For dependency management and build automation.

---

## Project Structure

```
src/main/java/com/grey/rdv_manager_api
├── controller        # REST controllers for handling API requests
├── domain            # Domain models representing database entities
├── mapper            # MapStruct mappers for DTO-to-entity conversion
├── payload           # Request and response DTOs
├── repository        # MongoDB repositories
├── service           # Service interfaces
├── service/impl      # Service implementations
└── RdvManagerApi.java # Main application class
```

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch.
4. Submit a pull request.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Contact

For questions or support, please contact [your-email@example.com].

