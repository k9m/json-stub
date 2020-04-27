package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.exception.ResourceNotFoundException;
import org.k9m.poa.api.model.DebitCardDTO;
import org.k9m.poa.persistence.repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DebitCardsController implements DebitCardsApi{

    private final DebitCardRepository debitCardRepository;

    @Override
    public ResponseEntity<DebitCardDTO> getDebitCardDetail(Long id) {
        return ResponseEntity.ok(debitCardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find DEBIT card with id: " + id)).toApiModel());
    }
}
