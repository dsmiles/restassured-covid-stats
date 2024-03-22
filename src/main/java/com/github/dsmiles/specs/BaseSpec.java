package com.github.dsmiles.specs;

import com.github.dsmiles.utils.PropertiesReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;

/**
 * Base class for defining request and response specifications.
 */
@Getter
public class BaseSpec {

    private final RequestSpecification requestSpec;
    private final ResponseSpecification responseSpec;

    private final String apiKey = PropertiesReader.getApiKey();
    private final String baseUri = PropertiesReader.getBaseUri();
    private final String basePath = PropertiesReader.getBasePath();

    public BaseSpec() {
        this.requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setBasePath(basePath)
            .addHeader("authorization", "apikey " + apiKey)
            .setContentType("application/json")
            .setAccept("application/json")
//            .addFilter(new RequestLoggingFilter())
//            .addFilter(new ResponseLoggingFilter())
            .build();

        this.responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType("application/json")
            .build();
    }
}
