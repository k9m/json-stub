package org.k9m.poa.persistence.repository;

import org.k9m.poa.persistence.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {}