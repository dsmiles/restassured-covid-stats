package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Represents COVID-19 data for a continent.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidContinentData {
    private String continent;
    private String totalCases;
    private String newCases;
    private String totalDeaths;
    private String newDeaths;
    private String totalRecovered;
    private String activeCases;
}
