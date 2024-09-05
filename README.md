# EmployeeManagementApplication

Employee Management System
This is a Spring Boot application for managing employees, their addresses, spouses, and projects. The application uses JPA/Hibernate for ORM and H2 in-memory database for data persistence.

Features

CRUD operations for employees
Manage employee addresses, spouses, and projects
In-memory H2 database for testing and development

Technologies Used

Spring Boot: Framework for building the application
Spring Data JPA: ORM for database interaction
H2 Database: In-memory database for testing

Usage

Access the H2 Console: Navigate to http://localhost:1234/h2-console to interact with the H2 database. 
The JDBC URL is jdbc:h2:mem:test, and the username is sa with an empty password.

API Documentation: You can use tools like Postman or curl to interact with the API endpoints provided.

API Endpoints
Employee Endpoints
Get all employees:

GET /employees

Get a specific employee by ID:

GET /employees/{id}

Create a new employee:

POST /employees

Request Body:

json
Copy code
{
  "empname": "John Doe",
  "empcity": "New York",
  "spouse": {
    "name": "Jane Doe",
    "mobile": "1234567890",
    "age": 30
  },
  "addresses": [
    {
      "line1": "123 Main St",
      "line2": "Apt 4B",
      "zipcode": "10001",
      "city": "New York",
      "state": "NY",
      "country": "USA"
    }
  ],
  "projects": [
    {
      "name": "Project X",
      "clientname": "Client Y"
    }
  ]
}
Update an employee by ID:

PUT /employees/{id}

Request Body: (Same as POST)

Delete an employee by ID:

DELETE /employees/{id}
