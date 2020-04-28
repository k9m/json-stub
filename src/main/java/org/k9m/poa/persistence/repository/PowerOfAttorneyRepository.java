package org.k9m.poa.persistence.repository;

import org.k9m.poa.persistence.model.PowerOfAttorney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerOfAttorneyRepository extends JpaRepository<PowerOfAttorney, Long> {
    PowerOfAttorney findByIdAndDebitCardsStatusAndCreditCardsStatus(Long id, String dcStatus, String ccStatus);
}