package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.DropDTO;
import davidctn.licenta.data_transfer_object.TraitDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Drop;
import davidctn.licenta.models.Trait;
import davidctn.licenta.services.DropService;
import davidctn.licenta.services.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/traits")
public class TraitController {

    private final TraitService traitService;

    @Autowired
    public TraitController(TraitService traitService){ this.traitService = traitService; }

    @GetMapping()
    public List<TraitDTO> getTraits() throws ResourceNotFoundException {
        return traitService.getTraits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraitDTO> getTraitById(@PathVariable(value="id") Integer traitId) throws ResourceNotFoundException {
        return traitService.getTraitById(traitId);
    }

    @PostMapping("/create")
    public Trait createTrait(@RequestBody TraitDTO traitDTO) throws ResourceNotFoundException { return traitService.createTrait(traitDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trait> updateTrait(@PathVariable(value="id") Integer traitId,
                                           @Validated @RequestBody TraitDTO traitDetails)
            throws ResourceNotFoundException {

        return traitService.updateTrait(traitId,traitDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteTrait(@PathVariable(value ="id") Integer traitId) throws ResourceNotFoundException {
        return traitService.deleteTrait(traitId);
    }
}
