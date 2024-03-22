package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Represents the response containing COVID-19 data for a continent.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidContinentDataResponse {
    private boolean success;
    private List<CovidContinentData> result;
}
