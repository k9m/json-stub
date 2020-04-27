package org.k9m.poa.it.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.k9m.poa.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class Steps {

    @Autowired
    private TestClient testClient;

    @Autowired
    private ObjectMapper objectMapper;

    private DebitCardDTO lastRetrievedDebitCard;
    private CreditCardDTO lastRetrievedCreditCard;
    private HttpClientErrorException lastThrownException;


    @Given("the system has started up")
    public void theSystemHasStartedUp() {
        final String healthCheckString = testClient.healthCheck();
        assertThat(healthCheckString, containsString("UP"));
    }


    @Then("^an error should be returned with message containing: (.*) and status code: (\\d+)$")
    public void errorMsgContains(String message, int statusCode) throws JsonProcessingException {
        assertNotNull("Error shouldn't be null", lastThrownException);
        final ErrorObjectDTO errorObject = objectMapper.readValue(lastThrownException.getResponseBodyAsString(), ErrorObjectDTO.class);

        assertThat(errorObject.getMessage(), is(message));
        assertThat(errorObject.getStatusCode(), is(statusCode));
    }


    @When("retrieving a debit card account with id {int}")
    public void retrievingADebitCardAccountWithId(long id) {
        try {
            lastRetrievedDebitCard = testClient.getDebitCard(id);
        } catch (HttpClientErrorException e) {
           lastThrownException = e;
        }
    }

    @When("retrieving a credit card account with id {int}")
    public void retrievingACreditCardAccountWithId(long id) {
        try {
            lastRetrievedCreditCard = testClient.getCreditCard(id);
        } catch (HttpClientErrorException e) {
           lastThrownException = e;
        }
    }

    @Then("the following debit card details should match")
    public void assertDebit(final DataTable dataTable) {
        assertNotNull("lastRetrievedDebitCard shouldn't be null", lastRetrievedDebitCard);
        assertThat(lastRetrievedDebitCard, is(dataTable.<DebitCardDTO>asList(DebitCardDTO.class).get(0)));
    }

    @Then("the following credit card details should match")
    public void assertCredit(final DataTable dataTable) {
        assertNotNull("lastRetrievedCreditCard shouldn't be null", lastRetrievedCreditCard);
        assertThat(lastRetrievedCreditCard, is(dataTable.<CreditCardDTO>asList(CreditCardDTO.class).get(0)));
    }


    @DataTableType
    public DebitCardDTO debitCard(Map<String, String> entry) {
        return new DebitCardDTO()
                .id(Long.parseLong(entry.get("id")))
                .cardNumber(Integer.parseInt(entry.get("cardNumber")))
                .sequenceNumber(Integer.parseInt(entry.get("sequenceNumber")))
                .cardHolder(entry.get("cardHolder"))
                .status(StatusDTO.fromValue(entry.get("status")))
                .contactless(Boolean.valueOf(entry.get("contactless")))
                .atmLimit(new LimitDTO()
                        .limit(Integer.parseInt(entry.get("atm.limit")))
                        .periodUnit(PeriodUnitDTO.fromValue(entry.get("atm.periodUnit")))
                )
                .posLimit(new LimitDTO()
                        .limit(Integer.parseInt(entry.get("pos.limit")))
                        .periodUnit(PeriodUnitDTO.fromValue(entry.get("pos.periodUnit")))
                );
    }

    @DataTableType
    public CreditCardDTO creditCard(Map<String, String> entry) {
        return new CreditCardDTO()
                .id(Long.parseLong(entry.get("id")))
                .cardNumber(Integer.parseInt(entry.get("cardNumber")))
                .sequenceNumber(Integer.parseInt(entry.get("sequenceNumber")))
                .cardHolder(entry.get("cardHolder"))
                .status(StatusDTO.fromValue(entry.get("status")))
                .monthlyLimit(Integer.parseInt(entry.get("monthlyLimit")));
    }
}
