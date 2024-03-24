# COVID-19 Coronavirus Statistics API

I recently discovered, CollectAPI, a platform hosting various public APIs. One API that caught my interest is the 
COVID-19 Coronavirus Statistics API, which provides global COVID-19 data sourced from the World Health Organization (WHO).

I decided to create a simple test framework to exercise the APIs functionality. The framework is written in Java using 
the REST-assured library for API testing.

The framework features a test suite that covers the APIs endpoints and verifies the response status codes, headers, and
body. The tests are written in JUnit 5 and are executed using Maven.

The framework is set up to run on GitHub Actions, which automatically runs the tests on each push to the repository.

## CollectAPI Account and tier

Before accessing the API, you need to create an account on CollectAPI to obtain an API token. I chose the free tier,
which has some request limitations, but serves most needs well. Visit [CollectAPI](https://collectapi.com/) to sign up.

## COVID-19 Coronavirus API

The API is a REST-ful service which provides the following endpoints:

- `GET /countriesData`
- `GET /totalData`
- `GET /coronaNews`
- `GET /continentData`

More details can be found [here](https://collectapi.com/api/corona/covid-19-coronavirus-statistics-api).

## Test Strategy

Brief outline of my design strategy for the test framework:

- The test framework is designed to be modular and scalable. 

- Abstraction has been used to separate the test logic from the API calls. The API calls are encapsulated in a corresponding 
`controller` class that contains the API request and response logic.

- The framework uses the REST-assured library to make API calls and validate the response. The response data is deserialized 
into Java objects using the Jackson library for easy manipulation and validation.

- The test framework follows best practices for API testing, including verifying the response status code, headers, and
body. The tests are written in a clear and concise manner, making them easy to understand and maintain.

- The framework uses the JUnit 5 library to write and execute tests. The tests are run using Maven, which handles the 
test execution and generates reports.

- The framework is set up to run on GitHub Actions, which automatically runs the tests on each push to the repository. The 
API token is stored securely in GitHub Secrets and inserted into the test framework using the GitHub Actions workflow.


## Technologies used

This example was written using the following:

- Java 21
- Maven
- JUnit 5
- [REST-assured](https://rest-assured.io)
- CollectAPI
- GitHub Actions
- GitHub Secrets

## Usage

To run the test framework, follow these steps:

1. Clone the repository:
    ```
    git clone https://github.com/dsmiles/covid-19-statistics-api.git
    cd covid-19-statistics-api
    ```

2. Run the Maven test command:
    ```
    mvn clean test
    ```

## GitHub Actions

A GitHub Actions workflow is set up to run tests on each push. You can find it in the `.github/workflows` directory.

The workflow uses GitHub Secrets to store the API token securely. The token is then inserted into the `config.properties` 
file using the `write-properties` action by Christian Draeger, available on the [GitHub Marketplace](https://github.com/marketplace/actions/write-properties). The token 
value is obscured in logs for security.

Ensure you obtain an API token from CollectAPI and store it in your repository's secrets with the appropriate name.
