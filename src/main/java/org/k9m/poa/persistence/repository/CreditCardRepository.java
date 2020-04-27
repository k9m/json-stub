package org.k9m.poa.persistence.repository;

import org.k9m.poa.persistence.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {}