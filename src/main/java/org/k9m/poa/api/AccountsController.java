package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.exception.ResourceNotFoundException;
import org.k9m.poa.api.model.AccountDTO;
import org.k9m.poa.persistence.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountsController implements AccountsApi{

    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<AccountDTO> getBankAccount(final Long id) {
        return ResponseEntity.ok(accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find ACCOUNT with id: " + id)).toApiModel());
    }
}
