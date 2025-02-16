@api
Feature: API Testing: Create And Delete User

  @create-user
  Scenario: POST: Create User
    Given I have the endpoint "/user/create"
    And I set the request headers
    And I set the request body with:
      """
        {
          "firstName": "Andri",
          "lastName": "Hendra",
          "email": "dwi_first@email.com"
        }
      """
    When I send a POST request
    Then the response status code should be 200
    And the response body should contain "firstName", "lastName" and "email"
    And I store the "id" from the response

  @validate-schema
  Scenario: Validate GET Single User API Response
    Given I have the endpoint "/user/{id}"
    And I set the request headers
    When I send a GET request with an id "{id}"
    Then the response status code should be 200
    And the response body should match the JSON schema "src/test/resources/api/jsonSchema/GetSingleUserSchema.json"

  @delete-user
  Scenario: DELETE: Delete User
    Given I have the endpoint "/user/{id}"
    And I set the request headers
    When I send a DELETE request
    Then the response status code should be 200