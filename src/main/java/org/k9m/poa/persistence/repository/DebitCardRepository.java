package org.k9m.poa.persistence.repository;

import org.k9m.poa.persistence.model.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {}