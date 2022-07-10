package davidctn.licenta.controllers;
import davidctn.licenta.data_transfer_object.DropDetailsDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.DropDetails;
import davidctn.licenta.services.DropDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/dropsDetails")
public class DropDetailsController {

    private final DropDetailsService dropDetailsService;

    @Autowired
    public DropDetailsController(DropDetailsService dropDetailsService){ this.dropDetailsService = dropDetailsService; }

    @GetMapping()
    public List<DropDetailsDTO> getDropsDetails() throws ResourceNotFoundException {
        return dropDetailsService.getDropsDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DropDetailsDTO> getDropDetailsById(@PathVariable(value="id") Integer dropDetailsId) throws ResourceNotFoundException {
        return dropDetailsService.getDropDetailsById(dropDetailsId);
    }

    @PostMapping("/create")
    public DropDetails createDropDetails(@RequestBody DropDetailsDTO dropDetailsDTO) throws ResourceNotFoundException {
        return dropDetailsService.createDropDetails(dropDetailsDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<DropDetails> updateDropDetails(@PathVariable(value="id") Integer dropDetailsId,
                                           @Validated @RequestBody DropDetailsDTO dropDetailsDTO)
            throws ResourceNotFoundException {

        return dropDetailsService.updateDropDetails(dropDetailsId,dropDetailsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteDropDetails(@PathVariable(value ="id") Integer dropDetailsId) throws ResourceNotFoundException {
        return dropDetailsService.deleteDropDetails(dropDetailsId);
    }
}
