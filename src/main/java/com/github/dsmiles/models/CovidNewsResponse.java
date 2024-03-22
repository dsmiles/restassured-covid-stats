package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Represents the response containing COVID-19 related news articles.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidNewsResponse {
    private boolean success;
    private List<CovidNews> result;
}
