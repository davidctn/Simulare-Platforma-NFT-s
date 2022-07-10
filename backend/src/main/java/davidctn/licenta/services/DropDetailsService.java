package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.DropDTO;
import davidctn.licenta.data_transfer_object.DropDetailsDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Drop;
import davidctn.licenta.models.DropDetails;
import davidctn.licenta.repositories.DropDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DropDetailsService {

    private final DropDetailsRepository dropDetailsRepository;

    @Autowired
    public DropDetailsService(DropDetailsRepository dropDetailsRepository){
        this.dropDetailsRepository = dropDetailsRepository;
    }

    public DropDetails buildDropDetails(DropDetailsDTO dropDetailsDTO){
        DropDetails dropDetails = new DropDetails();
        dropDetails.setSupply(dropDetailsDTO.getSupply());
        dropDetails.setMintPrice(dropDetailsDTO.getMintPrice());
        dropDetails.setShortDescription(dropDetailsDTO.getShortDescription());
        dropDetails.setDescription(dropDetailsDTO.getDescription());
        dropDetails.setRoadmap(dropDetailsDTO.getRoadmap());
        dropDetails.setTeam(dropDetailsDTO.getTeam());
        dropDetails.setWebsite(dropDetailsDTO.getWebsite());
        dropDetails.setDiscord(dropDetailsDTO.getDiscord());
        dropDetails.setTwitter(dropDetailsDTO.getTwitter());
        dropDetails.setImage(dropDetailsDTO.getImage());
        return dropDetails;
    }

    public DropDetailsDTO buildDropDetailsDTO(DropDetails dropDetails){
        DropDetailsDTO dropDetailsDTO = new DropDetailsDTO();
        dropDetailsDTO.setId(dropDetails.getId());
        dropDetailsDTO.setSupply(dropDetails.getSupply());
        dropDetailsDTO.setMintPrice(dropDetails.getMintPrice());
        dropDetailsDTO.setShortDescription(dropDetails.getShortDescription());
        dropDetailsDTO.setDescription(dropDetails.getDescription());
        dropDetailsDTO.setRoadmap(dropDetails.getRoadmap());
        dropDetailsDTO.setTeam(dropDetails.getTeam());
        dropDetailsDTO.setWebsite(dropDetails.getWebsite());
        dropDetailsDTO.setDiscord(dropDetails.getDiscord());
        dropDetailsDTO.setTwitter(dropDetails.getTwitter());
        dropDetailsDTO.setImage(dropDetails.getImage());
        return dropDetailsDTO;
    }

    public List<DropDetailsDTO> getDropsDetails() {
        List<DropDetailsDTO>list = new ArrayList<DropDetailsDTO>();
        for (DropDetails dropDetails : dropDetailsRepository.findAll()) {
            DropDetailsDTO dropDetailsDTO = buildDropDetailsDTO(dropDetails);
            System.out.println(dropDetailsDTO.toString());
            System.out.println("\n");
            list.add(dropDetailsDTO);
        }
        return list;
    }

    public ResponseEntity<DropDetailsDTO> getDropDetailsById(Integer dropDetailsId) throws ResourceNotFoundException {
        DropDetails dropDetails= dropDetailsRepository.findById(dropDetailsId).orElseThrow(()->new ResourceNotFoundException("Drop-ul cu id-ul "+dropDetailsId+" nu a fost gasit"));
        DropDetailsDTO dropDetailsDTO= buildDropDetailsDTO(dropDetails);
        return ResponseEntity.ok().body(dropDetailsDTO);
    }

    public DropDetails createDropDetails(DropDetailsDTO dropDetailsDTO) {
        DropDetails dropDetails= buildDropDetails(dropDetailsDTO);
        return this.dropDetailsRepository.save(dropDetails); }

    public ResponseEntity<DropDetails> updateDropDetails(Integer dropDetailsId, DropDetailsDTO dropDetailsDTO) throws ResourceNotFoundException {

        DropDetails dropDetails=dropDetailsRepository.findById(dropDetailsId).orElseThrow(()->new ResourceNotFoundException("Drop-ul cu id-ul "+dropDetailsId+" nu a fost gasit"));
        dropDetails.setMintPrice(dropDetailsDTO.getMintPrice());
        dropDetails.setShortDescription(dropDetailsDTO.getShortDescription());
        dropDetails.setDescription(dropDetailsDTO.getDescription());
        dropDetails.setRoadmap(dropDetailsDTO.getRoadmap());
        dropDetails.setTeam(dropDetailsDTO.getTeam());
        dropDetails.setWebsite(dropDetailsDTO.getWebsite());
        dropDetails.setDiscord(dropDetailsDTO.getDiscord());
        dropDetails.setTwitter(dropDetailsDTO.getTwitter());
        dropDetails.setImage(dropDetailsDTO.getImage());
        return ResponseEntity.ok(this.dropDetailsRepository.save(dropDetails));
    }

    public Map<String, Boolean> deleteDropDetails(Integer dropDetailsId) throws ResourceNotFoundException {
        DropDetails dropDetails=dropDetailsRepository.findById(dropDetailsId).orElseThrow(()->new ResourceNotFoundException("Drop-ul cu id-ul "+dropDetailsId+" nu a fost gasit"));
        this.dropDetailsRepository.delete(dropDetails);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
