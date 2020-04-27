package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.model.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DebitCardsController implements DebitCardsApi{

    @Override
    public ResponseEntity<DebitCard> getDebitCardDetail(String id) {
        return null;
    }
}
