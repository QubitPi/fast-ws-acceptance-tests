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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * BDD step definition for healthcheck.
 */
public class HealthcheckStepDefinitions extends AbstractStepDefinitions {

    private Response postResponse;
    private RequestSpecification getRequest;

    /**
     * Step definition.
     */
    @Given("^the query is pinging the webservice$")
    public void ping() {
        getRequest = RestAssured.given();
    }

    /**
     * Step definition.
     */
    @When("^the query is executed$")
    public void executeQuery() {
        postResponse = getRequest.when().get(BASE_PATH + "/healthcheck");
    }

    /**
     * Step definition.
     */
    @Then("^response returns a 200$")
    public void responseIndicatesServiceIsHealthy() {
        postResponse.then().assertThat().statusCode(200);
    }
}
