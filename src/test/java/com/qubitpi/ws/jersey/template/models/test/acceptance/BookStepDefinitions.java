/*
 * Copyright Jiaqi Liu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubitpi.ws.jersey.template.models.test.acceptance;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * BDD step definition for book data structure.
 */
public class BookStepDefinitions extends AbstractStepDefinitions {

    private Response postResponse;
    private RequestSpecification postRequest;

    /**
     * Step definition.
     */
    @Given("^the query is asking for all books$")
    public void getAllBooks() {
        postRequest = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(String.format("{\"query\": \"%s\"}", payload("get-all-books.graphql")));
    }

    /**
     * Step definition.
     */
    @When("^the query is executed$")
    public void executeQuery() {
        postResponse = postRequest.when().post(GRAPHQL_ENDPOINT_PATH);
    }

    /**
     * Step definition.
     */
    @Then("^response contains all requested fields$")
    public void responseContainsAllRequestedFields() {
        final JsonPath expectedJson = new JsonPath(response("get-all-books-response.json"));

        postResponse.then()
                .assertThat()
                .body(matchesJsonSchema(response("book.schema")))
                .body("", equalTo(expectedJson.getMap("")))
                .statusCode(200);
    }
}
