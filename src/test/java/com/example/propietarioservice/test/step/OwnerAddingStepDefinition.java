package com.example.propietarioservice.test.step;

import com.example.propietarioservice.entity.Propietario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


public class OwnerAddingStepDefinition {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int randomServerPort;
    private ResponseEntity<String> responseEntity;
    private String endPointPath;
    @Given("The Endpoint {string} is available for owners")
    public void theEndpointIsAvailableForOwners(String endPointPath) {
        this.endPointPath = String.format("http://localhost:%d/api/v1/propietarios", randomServerPort);
    }

    @When("A Owner request is sent with values {string}, {string}, {string}, {string}, {string}, {string}")
    public void aOwnerRequestIsSentWithValues(String name, String lastName, String address, String password, String email, Long dni) {
        Propietario resource = new Propietario()
                .withName(name)
                .withLastname(lastName)
                .withAddress(address)
                .withPassword(password)
                .withEmail(email)
                .withDni(dni);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Propietario> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endPointPath, request, String.class);

    }

    @Then("A Response with Status {int} is received for the owner")
    public void aResponseWithStatusIsReceivedForTheOwner(int expectedStatusCode) {
        int actualStatusCode = responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }
}
