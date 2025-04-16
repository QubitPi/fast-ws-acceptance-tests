Feature: Webservice supports healthcheck

  Scenario: Healthcheck endpoints makes sure that webservice is up and running
    Given the query is pinging the webservice
    When the query is executed
    Then response returns a 200
