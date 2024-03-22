package com.github.dsmiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Represents COVID-19 related news article.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidNews {
    private String key;
    private String url;
    private String description;
    private String image;
    private String name;
    private String source;
}
