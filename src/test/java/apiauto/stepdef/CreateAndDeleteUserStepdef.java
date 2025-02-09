package apiauto.stepdef;

import apiauto.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateAndDeleteUserStepdef {

    private String baseURI;
    private String endpoint;
    private int userId;
    private Response response;
    private RequestSpecification request;

    @Given("I have the endpoint {string}")
    public void iHaveTheEndpoint(String url) {
        this.endpoint = "https://dummyapi.io/data/v1" + url;
        request = given();
    }

    @And("I set the request headers")
    public void iSetTheRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("app-id", "63a804408eb0cb069b57e43a");
        request.headers(headers);
    }

    @And("I set the request body with:")
    public void iSetTheRequestBodyWith(String body) {
        request.body(body);
    }

    @When("I send a POST request")
    public void iSendAPOSTRequest() {
        response = request.post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("the response body should contain {string}, {string} and {string}")
    public void theResponseBodyShouldContainAnd(String key1, String key2, String key3) {
        response.then()
                .body("$", hasKey(key1))
                .body("$", hasKey(key2))
                .body("$", hasKey(key3));
    }

    @And("I store the {string} from the response")
    public void iStoreTheFromTheResponse(String key) {
        String storedId = response.jsonPath().getString(key);
        ScenarioContext.setStoredId(storedId);
        assertNotNull("ID should not be null", storedId);
    }

    @When("I send a DELETE request")
    public void iSendADELETERequest() {
        String storedId = ScenarioContext.getStoredId();
        assertNotNull("Stored ID should not be null before DELETE", storedId);
        response = request.delete(endpoint.replace("{id}", storedId));
    }

    @When("I send a GET request with an id {string}")
    public void iSendAGETRequestWithAnId(String id) {
        response = request.get(endpoint.replace("{id}", id));
    }

    @And("the response body should match the JSON schema {string}")
    public void theResponseBodyShouldMatchTheJSONSchema(String schemaPath) {
        File schemaFile = new File(schemaPath);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }
}
