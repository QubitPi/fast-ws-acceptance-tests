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

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

/**
 * BDD initialization step definition before all other steps are executed.
 * <p>
 * All init logics are defined in {@link #beforeAll()}
 */
@SuppressWarnings("unused")
public class InitStepDefinitions extends AbstractStepDefinitions {

    /**
     * BDD initialization definition.
     */
    @BeforeAll
    public static void beforeAll() {
        initRestAssured();
        cleanupDatabase();
        crateNewBook();
    }

    /**
     * Defines the endpoint resource location used during acceptance test.
     */
    private static void initRestAssured() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/v1";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    /**
     * Makes sure DB is empty initially.
     */
    private static void cleanupDatabase() {
        final Response allBooks = RestAssured
                .given()
                .body(String.format(QUERY_FORMAT, payload("get-all-books.graphql")))
                .post(GRAPHQL_ENDPOINT_PATH);
        final List<String> allBookIds = allBooks.jsonPath().getList("data.book.edges.node.id");

        allBookIds.forEach(id -> {
            RestAssured
                    .given()
                    .body(String.format(QUERY_FORMAT, String.format(payload("delete-book-by-id.graphql"), id)));
        });
    }

    /**
     * Populate database with some data.
     */
    private static void crateNewBook() {
        RestAssured
                .given()
                .body(
                        String.format(
                                QUERY_FORMAT,
                                String.format(payload("create-a-new-book.graphql"))
                        )
                )
                .when()
                .post(GRAPHQL_ENDPOINT_PATH)
                .then()
                .statusCode(200);
    }
}
