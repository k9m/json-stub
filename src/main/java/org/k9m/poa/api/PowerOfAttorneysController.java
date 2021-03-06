package org.k9m.poa.api;

import lombok.RequiredArgsConstructor;
import org.k9m.poa.api.model.PowerOfAttorneyDTO;
import org.k9m.poa.api.model.PowerOfAttorneyReferenceDTO;
import org.k9m.poa.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PowerOfAttorneysController implements PowerOfAttorneysApi{

    private final PowerOfAttorneyService powerOfAttorneyService;

    @Override
    public ResponseEntity<List<PowerOfAttorneyReferenceDTO>> getAllPowerOfAttorneys() {
        return ResponseEntity.ok(powerOfAttorneyService.findAllPOAReferences());
    }

    @Override
    public ResponseEntity<PowerOfAttorneyDTO> getPowerOfAttorneyDetail(final Long id) {
        return ResponseEntity.ok(powerOfAttorneyService.getPOADetail(id));
    }
}
