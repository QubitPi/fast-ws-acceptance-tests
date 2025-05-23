/*
 * Copyright 2025 Jiaqi Liu. All rights reserved.
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
package com.qubitpi.fastws.test.acceptance;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

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
}
