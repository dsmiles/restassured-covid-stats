# COVID-19 Coronavirus Statistics API

I recently discovered CollectAPI, a platform hosting various APIs. One that caught my interest is the COVID-19 Coronavirus Statistics API, providing global COVID-19 data sourced from the World Health Organization (WHO).

## Collect API

Before accessing the API, you need to create an account on CollectAPI to obtain an API token. I chose the free tier, which has some request limitations, but serves most needs well. Visit [CollectAPI](https://collectapi.com/) to sign up.

## COVID-19 API

This API offers comprehensive COVID-19 statistics worldwide, sourced from WHO. It features four endpoints:
- `GET /countriesData`
- `GET /totalData`
- `GET /coronaNews`
- `GET /continentData`

More details can be found [here](https://collectapi.com/api/corona/covid-19-coronavirus-statistics-api).

## Requirements

- Java 21 (versions 11 or 17 may also work)
- Maven
- Git
- JUnit 5
- [REST-assured](https://rest-assured.io)

## Usage

To run the test framework, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/dsmiles/covid-19-statistics-api.git
    cd covid-19-statistics-api
    ```

2. Run the Maven test command:
    ```bash
    mvn clean test
    ```

### GitHub Actions

A GitHub Actions workflow is set up to run tests on each push. You can find it in the `.github/workflows` directory.

The workflow uses GitHub Secrets to store the API token securely. The token is then inserted into the `config.properties` file using the `write-properties` action by Christian Draeger, available on the [GitHub Marketplace](https://github.com/marketplace/actions/write-properties). The token value is obscured in logs for security.

Ensure you obtain an API token from CollectAPI and store it in your repository's secrets with the appropriate name.
