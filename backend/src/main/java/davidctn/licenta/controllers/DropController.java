package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.DropDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Drop;
import davidctn.licenta.services.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drops")
public class DropController {

    private final DropService dropService;

    @Autowired
    public DropController(DropService dropService){ this.dropService = dropService; }

    @GetMapping()
    public List<DropDTO> getDrops() throws ResourceNotFoundException {
        return dropService.getDrops();
    }

    @GetMapping("/upcoming-drops")
    public List<DropDTO> getUpcomingDrops() throws ResourceNotFoundException {
        return dropService.getUpcomingDrops();
    }

    @GetMapping("/ended-drops")
    public List<DropDTO> getEndedDrops() throws ResourceNotFoundException {
        return dropService.getEndedDrops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DropDTO> getDropById(@PathVariable(value="id") Integer dropId) throws ResourceNotFoundException {
        return dropService.getDropById(dropId);
    }

    @PostMapping("/create")
    public Drop createDrop(@RequestBody DropDTO dropDTO) throws ResourceNotFoundException { return dropService.createDrop(dropDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<Drop> updateDrop(@PathVariable(value="id") Integer dropId,
                                                 @Validated @RequestBody DropDTO dropDetails)
            throws ResourceNotFoundException {

        return dropService.updateDrop(dropId,dropDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteDrop(@PathVariable(value ="id") Integer dropId) throws ResourceNotFoundException {
        return dropService.deleteDrop(dropId);
    }


}
