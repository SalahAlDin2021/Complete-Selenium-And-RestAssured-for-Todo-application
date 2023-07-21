# Complete Selenium And RestAssured for Todo Application

This project is a comprehensive testing suite for a Todo application. It uses Selenium for browser-based testing and RestAssured for API testing. The project is structured to test various aspects of the application, including user registration, task creation, and task deletion.

## Features

- **User Registration**: The project includes a `RegisterApi` class that handles user registration. It generates a random user, sends a POST request to the registration endpoint, and extracts the response's cookies and access token.

- **Task Management**: The `TasksApi` class is responsible for adding tasks. It sends a POST request to the task endpoint with the task details and an authorization token.

- **Page Object Model**: The project follows the Page Object Model (POM) design pattern for Selenium tests. It includes various page classes like `LoginPage`, `TodoPage`, and `NewTodoPage`, each representing a different page in the application.

- **Test Cases**: The project includes test cases for logging in, adding a new todo, and deleting a todo. These tests are located in the `LoginTest` and `TodoTest` classes.

- **Utilities**: The project includes various utility classes for handling properties, cookies, and user generation.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Maven

### Installation

1. Clone the repository:
```bash
git clone https://github.com/SalahAlDin2021/Complete-Selenium-And-RestAssured-for-Todo-application.git
```
2. Navigate to the project directory:
```bash
cd Complete-Selenium-And-RestAssured-for-Todo-application
```

3. Install the dependencies:
```bash
mvn install
```
## Usage

To run the tests, use the following command:

```bash
mvn test
```


## Contributing

Contributions are welcome. Please open an issue to discuss your ideas before making changes.

## Authors

- SalahAlDin DarAldik

