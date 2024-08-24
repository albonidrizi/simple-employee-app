# Simple Employee App

## Overview

The Simple Employee App is a web application consisting of two main parts:
- **Frontend**: Built with React.js
- **Backend**: Built with Spring Boot

The application allows users to perform CRUD (Create, Read, Update, Delete) operations on employee records.

## Project Structure

### Frontend (`react-frontend`)

The frontend is a React application that provides a user interface for managing employee data. It includes:
- **Components**:
  - `ListUserComponent`: Displays a list of all employees.
  - `CreateUserComponent`: Form for adding new employees.
  - `UpdateUserComponent`: Form for updating existing employees.
  - `ViewUserComponent`: Displays details of a single employee.
  - `HeaderComponent`: Application header.
  - `FooterComponent`: Application footer.
- **Routing**: Managed using `react-router-dom` to handle navigation between different components.

### Backend (`springboot_be`)

The backend is a Spring Boot application that provides a RESTful API for managing employee data. It includes:
- **Controller**: `UserController` handles HTTP requests and responses for CRUD operations.
- **Service**: `UserService` contains business logic for user management.
- **Repository**: `UserRepository` interacts with the database.
- **Model**: `User` represents the employee entity.

## Getting Started

### Prerequisites

- Java 11 or later
- Node.js and npm
- Maven

### Frontend Setup

1. Navigate to the `react-frontend` directory.
2. Install dependencies:
   ```bash
   npm install
