package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.data_transfer_object.CollectionDetailsDTO;
import davidctn.licenta.data_transfer_object.DropDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Collection;
import davidctn.licenta.models.CollectionDetails;
import davidctn.licenta.services.CollectionDetailsService;
import davidctn.licenta.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collectionsDetails")
public class CollectionDetailsController {

    private final CollectionDetailsService collectionDetailsService;

    @Autowired
    public CollectionDetailsController(CollectionDetailsService collectionService){ this.collectionDetailsService=collectionService; }

    @GetMapping()
    public List<CollectionDetailsDTO> getCollectionsDetails() throws ResourceNotFoundException {
        return collectionDetailsService.getCollectionsDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionDetailsDTO> getCollectionDetailsById(@PathVariable(value="id") Integer collectionDetailsId) throws ResourceNotFoundException {
        return collectionDetailsService.getCollectionDetailsById(collectionDetailsId);
    }

    @PostMapping("/create")
    public CollectionDetails createCollectionDetails(@RequestBody CollectionDetailsDTO collectionDetailsDTO) throws ResourceNotFoundException {
        return collectionDetailsService.createCollectionDetails(collectionDetailsDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<CollectionDetails> updateCollectionDetails(@PathVariable(value="id") Integer collectionDetailsId,
                                                       @Validated @RequestBody CollectionDetailsDTO collectionDetailsDetails)
            throws ResourceNotFoundException {

        return collectionDetailsService.updateCollectionDetails(collectionDetailsId,collectionDetailsDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteCollectionDetails(@PathVariable(value ="id") Integer collectionDetailsId) throws ResourceNotFoundException {
        return collectionDetailsService.deleteCollectionDetails(collectionDetailsId);
    }

}