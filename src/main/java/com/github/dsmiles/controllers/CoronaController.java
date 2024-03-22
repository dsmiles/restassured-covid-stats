package com.github.dsmiles.controllers;

import com.github.dsmiles.models.CovidContinentDataResponse;
import com.github.dsmiles.models.CovidCountryDataResponse;
import com.github.dsmiles.models.CovidNewsResponse;
import com.github.dsmiles.models.CovidTotalDataResponse;
import com.github.dsmiles.paths.CoronaPaths;
import com.github.dsmiles.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

/**
 * Controller class to interact with the Corona API.
 */
public class CoronaController {

    private final CoronaPaths coronaPaths = new CoronaPaths();
    private final RequestSpecification requestSpec;
    private final ResponseSpecification responseSpec;

    /**
     * Constructor to initialize the controller with a request and response specification.
     * Could be enhanced to authorized and unauthorized requests.
     */
    public CoronaController() {
        BaseSpec specStrategy = new BaseSpec();
        requestSpec = specStrategy.getRequestSpec();
        responseSpec = specStrategy.getResponseSpec();
    }

    /**
     * Retrieves the collection containing corona values recorded so far by all countries.
     * @return COVID-19 statistics collection by country.
     */
    public CovidCountryDataResponse getCountriesData() {
        String path = coronaPaths.countriesData();
        return given(requestSpec)
            .when()
            .get(path)
            .then()
            .spec(responseSpec)
            .extract().as(CovidCountryDataResponse.class);
    }

    /**
     * Retrieves the corona values recorded for a specific country.
     * @param country The name of the country to retrieve data for.
     * @return COVID-19 statistics for the specified country.
     */
    public CovidCountryDataResponse getCountriesDataByName(String country) {
        return given(requestSpec)
            .queryParam("country", country)
            .when()
            .get(coronaPaths.countriesData())
            .then()
            .spec(responseSpec)
            .extract().as(CovidCountryDataResponse.class);
    }

    /**
     * Retrieves the total corona values recorded.
     * @return Total COVID-19 statistics.
     */
    public CovidTotalDataResponse getTotalData() {
        return given(requestSpec)
            .when()
            .get(coronaPaths.totalData())
            .then()
            .spec(responseSpec)
            .extract().as(CovidTotalDataResponse.class);
    }

    /**
     * Retrieves news about the coronavirus.
     * @return COVID-19 related news articles.
     */
    public CovidNewsResponse getCoronaNews() {
        return given(requestSpec)
            .when()
            .get(coronaPaths.coronaNews())
            .then()
            .spec(responseSpec)
            .extract().as(CovidNewsResponse.class);
    }

    /**
     * Retrieves continent-wide COVID-19 data.
     * Retrieves the corona values recorded so far by continents.
     * @return COVID-19 data by continent.
     */
    public CovidContinentDataResponse getContinentData() {
        return given(requestSpec)
            .when()
            .get(coronaPaths.continentData())
            .then()
            .spec(responseSpec)
            .extract().as(CovidContinentDataResponse.class);
    }

    /**
     * Generic method to get a resource from the API.
     * @param path The path of the resource.
     * @param responseClass The class type of the response.
     * @param <T> The type of the response.
     * @return The response as an instance of the specified class.
     */
    private <T> T getResource(String path, Class<T> responseClass) {
        return given()
            .spec(requestSpec)
            .when()
            .get(path)
            .then()
            .spec(responseSpec)
            .extract().as(responseClass);
    }
}
