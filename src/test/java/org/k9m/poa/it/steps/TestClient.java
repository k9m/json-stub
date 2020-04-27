package org.k9m.poa.it.steps;

import lombok.Getter;
import org.k9m.poa.api.model.*;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class TestClient {

    @LocalServerPort
    @Getter
    private int serverPort;

    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl;

    @PostConstruct
    private void init(){
        baseUrl = "http://localhost:" + serverPort;
    }

    public String healthCheck(){
        return restTemplate.getForObject(baseUrl + "/actuator/health", String.class);
    }

    public DebitCardDTO getDebitCard(Long id){
        return restTemplate.getForObject(baseUrl + "/debit-cards/{id}", DebitCardDTO.class, id);
    }

    public CreditCardDTO getCreditCard(Long id){
        return restTemplate.getForObject(baseUrl + "/credit-cards/{id}", CreditCardDTO.class, id);
    }

    public AccountDTO getAccount(Long id){
        return restTemplate.getForObject(baseUrl + "/accounts/{id}", AccountDTO.class, id);
    }

    public PowerOfAttorneyDTO getPOA(Long id) {
        return restTemplate.getForObject(baseUrl + "/power-of-attorneys/{id}", PowerOfAttorneyDTO.class, id);
    }

    public List<PowerOfAttorneyReferenceDTO> getPOAs() {
        return restTemplate.exchange(baseUrl + "/power-of-attorneys", HttpMethod.GET, null, new ParameterizedTypeReference<List<PowerOfAttorneyReferenceDTO>>() {}).getBody();
    }
}
