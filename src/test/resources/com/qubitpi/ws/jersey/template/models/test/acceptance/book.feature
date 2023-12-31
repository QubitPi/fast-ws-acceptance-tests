Feature: Book can be read via GraphQL POST endpoint

  Scenario: Book with desired structure is returned
    Given the query is asking for all books
    When the query is executed
    Then response contains all requested fields
