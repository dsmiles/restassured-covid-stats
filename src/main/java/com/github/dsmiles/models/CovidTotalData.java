package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Represents the total COVID-19 data world-wide.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidTotalData {
    private String totalDeaths;
    private String totalCases;
    private String totalRecovered;
}
