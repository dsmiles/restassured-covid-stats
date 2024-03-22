package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Represents the response containing COVID-19 data for a list countries.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidCountryDataResponse {
    public boolean success;
    public List<CovidCountryData> result;
}
