package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.exception.ResourceNotFoundException;
import org.k9m.poa.api.model.CreditCardDTO;
import org.k9m.poa.persistence.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreditCardsController implements CreditCardsApi{

    private final CreditCardRepository creditCardRepository;

    @Override
    public ResponseEntity<CreditCardDTO> getCreditCardDetail(final Long id) {
        return ResponseEntity.ok(creditCardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find CREDIT card with id: " + id)).toApiModel());
    }
}
