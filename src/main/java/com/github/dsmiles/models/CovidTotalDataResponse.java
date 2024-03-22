package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Represents the response containing total COVID-19 data.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidTotalDataResponse {
    private boolean success;
    private CovidTotalData result;
}
