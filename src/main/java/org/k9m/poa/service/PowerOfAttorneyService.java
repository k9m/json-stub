package org.k9m.poa.service;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.exception.ResourceNotFoundException;
import org.k9m.poa.api.model.PowerOfAttorneyDTO;
import org.k9m.poa.api.model.PowerOfAttorneyReferenceDTO;
import org.k9m.poa.persistence.model.PowerOfAttorney;
import org.k9m.poa.persistence.repository.PowerOfAttorneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PowerOfAttorneyService {

    private final PowerOfAttorneyRepository powerOfAttorneyRepository;

    public List<PowerOfAttorneyReferenceDTO> findAllPOAReferences() {
        return powerOfAttorneyRepository.findAll().stream().map(poa -> new PowerOfAttorneyReferenceDTO().id(poa.getId())).collect(Collectors.toList());
    }

    public PowerOfAttorneyDTO getPOADetail(final Long id) {
        PowerOfAttorney poa = powerOfAttorneyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find POA with id: " + id));

        poa.setCreditCards(poa.getCreditCards().stream().filter(cc -> "ACTIVE".equalsIgnoreCase(cc.getStatus())).collect(Collectors.toList()));
        poa.setDebitCards(poa.getDebitCards().stream().filter(dc -> "ACTIVE".equalsIgnoreCase(dc.getStatus())).collect(Collectors.toList()));

        return poa.toApiModel();
    }




}
