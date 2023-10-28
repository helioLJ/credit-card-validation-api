# Credit Card Validation Task Solution

This repository contains the back-end solution for the Credit Card Validation task.

![Imgur](https://i.imgur.com/nnrMfkk.gif)

## Prerequisites
Before running the application and tests, ensure that you have the following installed on your system:

- Java Development Kit (JDK)
- Your preferred integrated development environment (IDE) for easier code navigation and execution (e.g., IntelliJ IDEA, Eclipse)

## How to Run the Application
1. Clone this Git repository to your local machine using the following command:
```bash
git clone https://github.com/helioLJ/credit-card-validation-api
```
2. Open the project in your preferred IDE.

3. Build the project using Gradle by running the following command in the project's root directory:

```bash
./gradlew build
```
4. Start the Spring Boot application by running the following command:

```bash
./gradlew bootRun
```

This will start the application, and it will be accessible at http://localhost:8080.

## How to Run the Tests
You can run the unit tests for the application to verify its functionality. To do this, follow these steps:

1. Ensure that the application is not currently running.

2. Open a terminal window and navigate to the project's root directory.

3. Run the following Gradle command to execute the tests:

```bash
./gradlew cleanTest test
```
This command will run all the tests in the project, and you will see the test results in the terminal.

## API Usage
The application exposes a simple API endpoint for credit card validation. You can send POST requests to http://localhost:8080/api/validate with a JSON body containing credit card details. Here's an example request:

```json
{
"cardNumber": "4916011117218331",
"expiryDate": "02/27",
"cvv": "279"
}
```
The API will respond with either "Success!" if the credit card information is valid or "Invalid Credit Card information." if it's not.

## Additional Information
The solution uses Spring Boot for the backend implementation.
The front-end solution is right [here](https://github.com/helioLJ/credit-card-validation-web) 
The project structure follows standard Spring Boot conventions.
Unit tests are provided to ensure the correctness of the implemented logic.
Feel free to explore and modify the code as needed.
