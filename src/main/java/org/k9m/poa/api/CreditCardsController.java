package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreditCardsController implements CreditCardsApi{

    @Override
    public ResponseEntity<CreditCard> getCreditCardDetail(String id) {
        return null;
    }
}
