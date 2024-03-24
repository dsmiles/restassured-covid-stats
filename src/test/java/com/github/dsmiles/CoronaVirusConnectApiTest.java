package com.github.dsmiles;

import com.github.dsmiles.controllers.CoronaController;
import com.github.dsmiles.models.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CoronaVirusConnect API Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CoronaVirusConnectApiTest {

    public static final int NUMBER_OF_COUNTRIES = 231;
    public static final int NUMBER_OF_NEWS_ARTICLES = 16;
    public static final int NUMBER_OF_CONTINENTS = 6;
    private CoronaController coronaController;

    @BeforeAll
    public static void setUpBeforeClass() {
    }

    @BeforeEach
    void setUpBeforeEachTest() {
        coronaController = new CoronaController();
    }

    @Test
    @Order(1)
    @DisplayName("Get the corona virus data for all countries")
    void getAllCountriesData() {
        CovidCountryDataResponse response = coronaController.getCountriesData();
        assertTrue(response.isSuccess());
        assertEquals(NUMBER_OF_COUNTRIES, response.getResult().size());
    }

    @Test
    @Order(2)
    @DisplayName("Get the corona virus data for a specific country by name")
    void getCountriesDataByName() {
        CovidCountryDataResponse response = coronaController.getCountriesDataByName("UK");
        assertTrue(response.isSuccess());
        assertEquals(1, response.getResult().size());
    }

    @Test
    @Order(3)
    @DisplayName("Get the corona virus data for a specific country by unknown name returns empty list")
    void getCountriesDataByUnknownName() {
        CovidCountryDataResponse response = coronaController.getCountriesDataByName("Unknown Country");
        assertTrue(response.isSuccess());
        assertEquals(0, response.getResult().size() );
    }

    @Test
    @Order(4)
    @DisplayName("Get the total corona virus values recorded world-wide")
    void getTotalData() {
        CovidTotalDataResponse response = coronaController.getTotalData();
        assertTrue(response.isSuccess());
        // These numbers are sadly still creeping up - so just check for not null
        assertNotNull(response.getResult().getTotalDeaths());
        assertNotNull(response.getResult().getTotalCases());
        assertNotNull(response.getResult().getTotalRecovered());
    }

    @Test
    @Order(5)
    @DisplayName("Get the latest corona virus related news")
    void getCoronaNews() {
        CovidNewsResponse response = coronaController.getCoronaNews();
        assertTrue(response.isSuccess());
        assertEquals(NUMBER_OF_NEWS_ARTICLES, response.getResult().size());
    }

    @Test
    @Order(6)
    @DisplayName("Get the corona virus values recorded by continent")
    void getContinentData() {
        CovidContinentDataResponse response = coronaController.getContinentData();
        assertTrue(response.isSuccess());
        assertEquals(NUMBER_OF_CONTINENTS, response.getResult().size());

        // Extract the list of continent names from the response
        List<String> continentNames = response.getResult().stream()
            .map(CovidContinentData::getContinent)
            .toList();

        // Assert that all expected continents are present
        assertTrue(continentNames.contains("North America"));
        assertTrue(continentNames.contains("Asia"));
        assertTrue(continentNames.contains("Europe"));
        assertTrue(continentNames.contains("South America"));
        assertTrue(continentNames.contains("Oceania"));
        assertTrue(continentNames.contains("Africa"));
    }
}
