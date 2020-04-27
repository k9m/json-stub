package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.exception.ResourceNotFoundException;
import org.k9m.poa.api.model.PowerOfAttorneyDTO;
import org.k9m.poa.api.model.PowerOfAttorneyReferenceDTO;
import org.k9m.poa.persistence.repository.PowerOfAttorneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PowerOfAttorneysController implements PowerOfAttorneysApi{

    private final PowerOfAttorneyRepository powerOfAttorneyRepository;

    @Override
    public ResponseEntity<List<PowerOfAttorneyReferenceDTO>> getAllPowerOfAttorneys() {
        return ResponseEntity.ok(powerOfAttorneyRepository.findAll().stream().map(poa -> new PowerOfAttorneyReferenceDTO().id(poa.getId())).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<PowerOfAttorneyDTO> getPowerOfAttorneyDetail(final Long id) {
        return ResponseEntity.ok(powerOfAttorneyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find POA with id: " + id)).toApiModel());
    }
}
