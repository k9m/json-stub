package org.k9m.poa.it.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.k9m.poa.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

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
    private AccountDTO lastRetrievedAccount;
    private PowerOfAttorneyDTO lastRetrievedPOA;
    private List<PowerOfAttorneyReferenceDTO> lastRetrievedPOAs;
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

    @When("retrieving an account with id {int}")
    public void retrievingAccountWithId(long id) {
        try {
            lastRetrievedAccount = testClient.getAccount(id);
        } catch (HttpClientErrorException e) {
           lastThrownException = e;
        }
    }

    @When("retrieving a power of attorney with id {int}")
    public void retrievingPOAWithId(long id) {
        try {
            lastRetrievedPOA = testClient.getPOA(id);
        } catch (HttpClientErrorException e) {
           lastThrownException = e;
        }
    }

    @When("retrieving all power of attorneys")
    public void retrievingPOAs() {
        try {
            lastRetrievedPOAs = testClient.getPOAs();
        } catch (HttpClientErrorException e) {
           lastThrownException = e;
        }
    }

    @Then("the following debit card details should match")
    public void assertDebit(final DataTable dataTable) {
        assertNotNull("lastRetrievedDebitCard shouldn't be null", lastRetrievedDebitCard);
        assertThat(lastRetrievedDebitCard, is(dataTable.asList(DebitCardDTO.class).get(0)));
    }

    @Then("the following credit card details should match")
    public void assertCredit(final DataTable dataTable) {
        assertNotNull("lastRetrievedCreditCard shouldn't be null", lastRetrievedCreditCard);
        assertThat(lastRetrievedCreditCard, is(dataTable.asList(CreditCardDTO.class).get(0)));
    }

    @Then("the following account details should match")
    public void assertAccount(final DataTable dataTable) {
        assertNotNull("lastRetrievedAccount shouldn't be null", lastRetrievedAccount);
        assertThat(lastRetrievedAccount, is(dataTable.asList(AccountDTO.class).get(0)));
    }

    @Then("the following power of attorney details should match")
    public void assertPOA(final DataTable dataTable) {
        assertNotNull("lastRetrievedPOA shouldn't be null", lastRetrievedPOA);
        PowerOfAttorneyDTO expectedPOA = dataTable.<PowerOfAttorneyDTO>asList(PowerOfAttorneyDTO.class).get(0);

        assertThat(lastRetrievedPOA.getId(), is(expectedPOA.getId()));
        assertThat(lastRetrievedPOA.getGrantor(), is(expectedPOA.getGrantor()));
        assertThat(lastRetrievedPOA.getGrantee(), is(expectedPOA.getGrantee()));
        assertThat(lastRetrievedPOA.getAccount(), is(expectedPOA.getAccount()));
        assertThat(lastRetrievedPOA.getDirection(), is(expectedPOA.getDirection()));
        assertThat(lastRetrievedPOA.getAuthorizations(), is(expectedPOA.getAuthorizations()));
    }

    @Then("the following power of attorney cards should match")
    public void assertPOACards(final DataTable dataTable) {
        List<CardReferenceDTO> expectedCards = dataTable.asList(CardReferenceDTO.class);
        assertThat(lastRetrievedPOA.getCards(), is(expectedCards));
    }


    @Then("the following power of attorneys should be returned")
    public void assertPOAS(final DataTable dataTable) {
        assertNotNull("lastRetrievedPOAs shouldn't be null", lastRetrievedPOAs);
        List<PowerOfAttorneyReferenceDTO> expectedPOAs = dataTable.asList(PowerOfAttorneyReferenceDTO.class);

        assertThat(lastRetrievedPOAs, is(expectedPOAs));
    }


}
