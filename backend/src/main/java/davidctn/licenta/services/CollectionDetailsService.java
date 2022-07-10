package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.data_transfer_object.CollectionDetailsDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Collection;
import davidctn.licenta.models.CollectionDetails;
import davidctn.licenta.repositories.CollectionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionDetailsService {

    private final CollectionDetailsRepository collectionDetailsRepository;

    @Autowired
    public CollectionDetailsService( CollectionDetailsRepository collectionRepository){
        this.collectionDetailsRepository=collectionRepository;
    }

    public CollectionDetailsDTO buildCollectionDetailsDTO(CollectionDetails collectionDetails){

        CollectionDetailsDTO collectionDetailsDTO = new CollectionDetailsDTO();
        collectionDetailsDTO.setId(collectionDetails.getId());
        collectionDetailsDTO.setDescription(collectionDetails.getDescription());
        collectionDetailsDTO.setSupply(collectionDetails.getSupply());
        collectionDetailsDTO.setMintPrice(collectionDetails.getMintPrice());
        collectionDetailsDTO.setMinimumNrOfTraits(collectionDetails.getMinimumNrOfTraits());
        collectionDetailsDTO.setMaximumNrOfTraits(collectionDetails.getMaximumNrOfTraits());
        collectionDetailsDTO.setRarityTypes(collectionDetails.getRarityTypes());
        return collectionDetailsDTO;
    }

    public CollectionDetails buildCollectionDetails (CollectionDetailsDTO collectionDetailsDTO){

        CollectionDetails collectionDetails  = new CollectionDetails();
        collectionDetails.setDescription(collectionDetailsDTO.getDescription());
        collectionDetails.setSupply(collectionDetailsDTO.getSupply());
        collectionDetails.setMintPrice(collectionDetailsDTO.getMintPrice());
        collectionDetails.setMinimumNrOfTraits(collectionDetailsDTO.getMinimumNrOfTraits());
        collectionDetails.setMaximumNrOfTraits(collectionDetailsDTO.getMaximumNrOfTraits());
        collectionDetails.setRarityTypes(collectionDetailsDTO.getRarityTypes());
        return collectionDetails;
    }

    public List<CollectionDetailsDTO> getCollectionsDetails() {

        List<CollectionDetailsDTO> list = new ArrayList<CollectionDetailsDTO>();
        for (CollectionDetails collectionDetails : collectionDetailsRepository.findAll()) {
            CollectionDetailsDTO collectionDetailsDTO = buildCollectionDetailsDTO(collectionDetails);
            System.out.println(collectionDetailsDTO.toString());
            System.out.println("\n");
            list.add(collectionDetailsDTO);
        }
        return list;
    }

    public ResponseEntity<CollectionDetailsDTO> getCollectionDetailsById(Integer collectionDetailsId) throws ResourceNotFoundException {
        CollectionDetails collectionDetails = collectionDetailsRepository.findById(collectionDetailsId).orElseThrow(() -> new ResourceNotFoundException("Colectia cu id-ul " + collectionDetailsId + " nu a fost gasita"));
        CollectionDetailsDTO collectionDetailsDTO = buildCollectionDetailsDTO(collectionDetails);
        return ResponseEntity.ok().body(collectionDetailsDTO);
    }

    public CollectionDetails createCollectionDetails(CollectionDetailsDTO collectionDetailsDTO) {
        CollectionDetails collectionDetails = buildCollectionDetails(collectionDetailsDTO);
        return this.collectionDetailsRepository.save(collectionDetails);
    }

    public ResponseEntity<CollectionDetails> updateCollectionDetails(Integer collectionDetailsId, CollectionDetailsDTO collectionDetailsDTO) throws ResourceNotFoundException {

        CollectionDetails collectionDetails = collectionDetailsRepository.findById(collectionDetailsId).orElseThrow(() -> new ResourceNotFoundException("Colectia cu id-ul " + collectionDetailsId + " nu a fost gasita"));
        collectionDetails.setDescription(collectionDetailsDTO.getDescription());
        collectionDetails.setSupply(collectionDetailsDTO.getSupply());
        collectionDetails.setMintPrice(collectionDetailsDTO.getMintPrice());
        collectionDetails.setMinimumNrOfTraits(collectionDetailsDTO.getMinimumNrOfTraits());
        collectionDetails.setMaximumNrOfTraits(collectionDetailsDTO.getMaximumNrOfTraits());
        collectionDetails.setRarityTypes(collectionDetailsDTO.getRarityTypes());
        return ResponseEntity.ok(this.collectionDetailsRepository.save(collectionDetails));
    }

    public Map<String, Boolean> deleteCollectionDetails(Integer collectionDetailsId) throws ResourceNotFoundException {
        CollectionDetails collectionDetails=collectionDetailsRepository.findById(collectionDetailsId).orElseThrow(()->new ResourceNotFoundException("Colectia cu id-ul " + collectionDetailsId + " nu a fost gasita"));
        this.collectionDetailsRepository.delete(collectionDetails);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
