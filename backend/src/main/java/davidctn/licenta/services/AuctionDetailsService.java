package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.AuctionDetailsDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.AuctionDetails;
import davidctn.licenta.repositories.AuctionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuctionDetailsService {

    private final AuctionDetailsRepository auctionDetailsRepository;

    @Autowired
    public AuctionDetailsService(AuctionDetailsRepository auctionDetailsRepository){
        this.auctionDetailsRepository=auctionDetailsRepository;
    }

    public AuctionDetails buildAuctionDetails(AuctionDetailsDTO auctionDetailsDTO){
        AuctionDetails auctionDetails = new AuctionDetails();
        auctionDetails.setDescription(auctionDetailsDTO.getDescription());
        auctionDetails.setStartingBid(auctionDetailsDTO.getStartingBid());
        auctionDetails.setFinalBid(auctionDetailsDTO.getFinalBid());
        auctionDetails.setNftId(auctionDetailsDTO.getNftId());
        auctionDetails.setWinnerAddress(auctionDetailsDTO.getWinnerAddress());
        auctionDetails.setState(auctionDetailsDTO.getState());
        auctionDetails.setDiscord(auctionDetailsDTO.getDiscord());
        auctionDetails.setTwitter(auctionDetailsDTO.getTwitter());
        auctionDetails.setToken(auctionDetailsDTO.getToken());
        auctionDetails.setCollectionName(auctionDetailsDTO.getCollectionName());
        auctionDetails.setDate(auctionDetailsDTO.getDate());
        return auctionDetails;
    }

    public AuctionDetailsDTO buildAuctionDetailsDTO(AuctionDetails auctionDetails){
        AuctionDetailsDTO auctionDetailsDTO = new AuctionDetailsDTO();
        auctionDetailsDTO.setId(auctionDetails.getId());
        auctionDetailsDTO.setDescription(auctionDetails.getDescription());
        auctionDetailsDTO.setStartingBid(auctionDetails.getStartingBid());
        auctionDetailsDTO.setFinalBid(auctionDetails.getFinalBid());
        auctionDetailsDTO.setNftId(auctionDetails.getNftId());
        auctionDetailsDTO.setWinnerAddress(auctionDetails.getWinnerAddress());
        auctionDetailsDTO.setState(auctionDetails.getState());
        auctionDetailsDTO.setDiscord(auctionDetails.getDiscord());
        auctionDetailsDTO.setTwitter(auctionDetails.getTwitter());
        auctionDetailsDTO.setToken(auctionDetails.getToken());
        auctionDetailsDTO.setCollectionName(auctionDetails.getCollectionName());
        auctionDetailsDTO.setDate(auctionDetails.getDate());
        return auctionDetailsDTO;
    }

    public List<AuctionDetailsDTO> getAuctionsDetails() {

        List<AuctionDetailsDTO> list = new ArrayList<AuctionDetailsDTO>();
        for (AuctionDetails auctionDetails : auctionDetailsRepository.findAll()) {
            AuctionDetailsDTO auctionDetailsDTO = buildAuctionDetailsDTO(auctionDetails);
            System.out.println(auctionDetailsDTO.toString());
            System.out.println("\n");
            list.add(auctionDetailsDTO);
        }
        return list;
    }

    public ResponseEntity<AuctionDetailsDTO> getAuctionDetailsById(Integer auctionDetailsId) throws ResourceNotFoundException {
        AuctionDetails auctionDetails = auctionDetailsRepository.findById(auctionDetailsId).orElseThrow(() -> new ResourceNotFoundException("Detaiile licitatiei cu id-ul " + auctionDetailsId + " nu au fost gasite"));
        AuctionDetailsDTO auctionDetailsDTO = buildAuctionDetailsDTO(auctionDetails);
        return ResponseEntity.ok().body(auctionDetailsDTO);
    }

    public AuctionDetails createAuctionDetails(AuctionDetailsDTO auctionDetailsDTO) {
        AuctionDetails auctionDetails = buildAuctionDetails(auctionDetailsDTO);
        return this.auctionDetailsRepository.save(auctionDetails);
    }


    public ResponseEntity<AuctionDetails> updateAuctionDetails(Integer auctionDetailsId, AuctionDetailsDTO auctionDetailsDTO) throws ResourceNotFoundException {

        AuctionDetails auctionDetails = auctionDetailsRepository.findById(auctionDetailsId).orElseThrow(() -> new ResourceNotFoundException("Detaiile licitatiei cu id-ul " + auctionDetailsId + " nu au fost gasite"));
        auctionDetails.setDescription(auctionDetailsDTO.getDescription());
        auctionDetails.setStartingBid(auctionDetailsDTO.getStartingBid());
        auctionDetails.setFinalBid(auctionDetailsDTO.getFinalBid());
        auctionDetails.setNftId(auctionDetailsDTO.getNftId());
        auctionDetails.setWinnerAddress(auctionDetailsDTO.getWinnerAddress());
        auctionDetails.setState(auctionDetailsDTO.getState());
        auctionDetails.setDiscord(auctionDetailsDTO.getDiscord());
        auctionDetails.setTwitter(auctionDetailsDTO.getTwitter());
        auctionDetails.setToken(auctionDetailsDTO.getToken());
        auctionDetails.setCollectionName(auctionDetailsDTO.getCollectionName());
        auctionDetails.setDate(auctionDetailsDTO.getDate());
        return ResponseEntity.ok(this.auctionDetailsRepository.save(auctionDetails));
    }

    public Map<String, Boolean> deleteAuctionDetails(Integer auctionDetailsId) throws ResourceNotFoundException {
        AuctionDetails auctionDetails=auctionDetailsRepository.findById(auctionDetailsId).orElseThrow(()->new ResourceNotFoundException("Detaiile licitatiei cu id-ul " + auctionDetailsId + " nu au fost gasite"));
        this.auctionDetailsRepository.delete(auctionDetails);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
