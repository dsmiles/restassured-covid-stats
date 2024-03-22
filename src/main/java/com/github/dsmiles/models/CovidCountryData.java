package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Represents COVID-19 data for a country.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidCountryData {
    private String country;
    private String totalCases;
    private String newCases;
    private String totalDeaths;
    private String newDeaths;
    private String totalRecovered;
    private String activeCases;
}
