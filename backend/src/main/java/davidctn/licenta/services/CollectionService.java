package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.AuctionDTO;
import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Auction;
import davidctn.licenta.models.Collection;
import davidctn.licenta.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionService( CollectionRepository collectionRepository){
        this.collectionRepository=collectionRepository;
    }

    public CollectionDTO buildCollectionDTO(Collection collection){

        CollectionDTO collectionDTO = new CollectionDTO();
        collectionDTO.setId(collection.getId());
        collectionDTO.setCollectionDetailsId(collection.getCollectionDetailsId());
        collectionDTO.setNftsContainerId(collection.getNftsContainerId());
        collectionDTO.setTraitsContainerId(collection.getTraitsContainerId());
        collectionDTO.setName(collection.getName());
        collectionDTO.setImage(collection.getImage());
        collectionDTO.setType(collection.getType());
        return collectionDTO;
    }

    public Collection buildCollection(CollectionDTO collectionDTO){

        Collection collection = new Collection();
        collection.setCollectionDetailsId(collectionDTO.getCollectionDetailsId());
        collection.setNftsContainerId(collectionDTO.getNftsContainerId());
        collection.setTraitsContainerId(collectionDTO.getTraitsContainerId());
        collection.setName(collectionDTO.getName());
        collection.setImage(collectionDTO.getImage());
        collection.setType(collectionDTO.getType());
        return collection;
    }

    public List<CollectionDTO> getCollections() {

        List<CollectionDTO> list = new ArrayList<CollectionDTO>();
        for (Collection collection : collectionRepository.findAll()) {
            CollectionDTO collectionDTO = buildCollectionDTO(collection);
            System.out.println(collectionDTO.toString());
            System.out.println("\n");
            list.add(collectionDTO);
        }
        return list;
    }
    public List<CollectionDTO> getPopularCollections() {

        List<CollectionDTO> collections = new ArrayList<CollectionDTO>();
        List<CollectionDTO> result = new ArrayList<CollectionDTO>();
        collections=getCollections();
        for(CollectionDTO collectionDTO : collections){
            if(collectionDTO.getType().contains("popular")){
                result.add(collectionDTO);
            }
        }
        return result;
    }

    public List<CollectionDTO> getNewCollections() {

        List<CollectionDTO> collections = new ArrayList<CollectionDTO>();
        List<CollectionDTO> result = new ArrayList<CollectionDTO>();
        collections=getCollections();
        for(CollectionDTO collectionDTO : collections){
            if(collectionDTO.getType().contains("new")){
                result.add(collectionDTO);
            }
        }
        return result;
    }

    public List<CollectionDTO> getVirtualRealityCollections() {

        List<CollectionDTO> collections = new ArrayList<CollectionDTO>();
        List<CollectionDTO> result = new ArrayList<CollectionDTO>();
        collections=getCollections();
        for(CollectionDTO collectionDTO : collections){
            if(collectionDTO.getType().contains("vr")){
                result.add(collectionDTO);
            }
        }
        return result;
    }

    public List<CollectionDTO> getFeaturedDAOCollections() {

        List<CollectionDTO> collections = new ArrayList<CollectionDTO>();
        List<CollectionDTO> result = new ArrayList<CollectionDTO>();
        collections=getCollections();
        for(CollectionDTO collectionDTO : collections){
            if(collectionDTO.getType().contains("dao")){
                result.add(collectionDTO);
            }
        }
        return result;
    }

    public List<CollectionDTO> getFeaturedGamesCollections() {

        List<CollectionDTO> collections = new ArrayList<CollectionDTO>();
        List<CollectionDTO> result = new ArrayList<CollectionDTO>();
        collections=getCollections();
        for(CollectionDTO collectionDTO : collections){
            if(collectionDTO.getType().contains("game")){
                result.add(collectionDTO);
            }
        }
        return result;
    }

    public ResponseEntity<CollectionDTO> getCollectionById(Integer collectionId) throws ResourceNotFoundException {
        Collection collection = collectionRepository.findById(collectionId).orElseThrow(() -> new ResourceNotFoundException("Colectia cu id-ul " + collectionId + " nu a fost gasita"));
        CollectionDTO collectionDTO = buildCollectionDTO(collection);
        return ResponseEntity.ok().body(collectionDTO);
    }

    public Collection createCollection(CollectionDTO collectionDTO) {
        Collection collection = buildCollection(collectionDTO);
        return this.collectionRepository.save(collection);
    }

    public ResponseEntity<Collection> updateCollection(Integer collectionId, CollectionDTO collectionDetails) throws ResourceNotFoundException {

        Collection collection = collectionRepository.findById(collectionId).orElseThrow(() -> new ResourceNotFoundException("Colectia cu id-ul " + collectionId + " nu a fost gasita"));
        collection.setCollectionDetailsId(collectionDetails.getCollectionDetailsId());
        collection.setNftsContainerId(collectionDetails.getNftsContainerId());
        collection.setTraitsContainerId(collectionDetails.getTraitsContainerId());
        collection.setName(collectionDetails.getName());
        collection.setImage(collectionDetails.getImage());
        collection.setType(collectionDetails.getType());
        return ResponseEntity.ok(this.collectionRepository.save(collection));
    }

    public Map<String, Boolean> deleteCollection(Integer collectionId) throws ResourceNotFoundException {
        Collection collection=collectionRepository.findById(collectionId).orElseThrow(()->new ResourceNotFoundException("Colectia cu id-ul " + collectionId + " nu a fost gasita"));
        this.collectionRepository.delete(collection);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
