package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.data_transfer_object.CollectionDetailsDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Collection;
import davidctn.licenta.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService){ this.collectionService=collectionService; }

    @GetMapping()
    public List<CollectionDTO> getCollections() throws ResourceNotFoundException {
        return collectionService.getCollections();
    }

    @GetMapping("/popular-collections")
    public List<CollectionDTO> getPopularCollections() throws ResourceNotFoundException {
        return collectionService.getPopularCollections();
    }

    @GetMapping("/new-collections")
    public List<CollectionDTO> getNewCollections() throws ResourceNotFoundException {
        return collectionService.getNewCollections();
    }

    @GetMapping("/featured-dao")
    public List<CollectionDTO> getFeaturedDAOCollections() throws ResourceNotFoundException {
        return collectionService.getFeaturedDAOCollections();
    }

    @GetMapping("/featured-games")
    public List<CollectionDTO> getFeaturedGamesCollections() throws ResourceNotFoundException {
        return collectionService.getFeaturedGamesCollections();
    }

    @GetMapping("/virtual-reality")
    public List<CollectionDTO> getVirtualRealityCollections() throws ResourceNotFoundException {
        return collectionService.getVirtualRealityCollections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionDTO> getCollectionById(@PathVariable(value="id") Integer collectionId) throws ResourceNotFoundException {
        return collectionService.getCollectionById(collectionId);
    }

    @PostMapping("/create")
    public Collection createCollection(@RequestBody CollectionDTO collectionDTO) throws ResourceNotFoundException {
        return collectionService.createCollection(collectionDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<Collection> updateCollection(@PathVariable(value="id") Integer collectionId,
                                                     @Validated @RequestBody CollectionDTO collectionDetails)
            throws ResourceNotFoundException {

        return collectionService.updateCollection(collectionId,collectionDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteCollection(@PathVariable(value ="id") Integer collectionId) throws ResourceNotFoundException {
        return collectionService.deleteCollection(collectionId);
    }

}
