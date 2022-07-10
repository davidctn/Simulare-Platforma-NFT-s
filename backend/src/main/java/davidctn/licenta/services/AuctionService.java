package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.AuctionDTO;
import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Auction;
import davidctn.licenta.repositories.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction buildAuction(AuctionDTO auctionDTO) {
        Auction auction = new Auction();
        auction.setAuctionDetailsId(auctionDTO.getAuctionDetailsId());
        auction.setName((auctionDTO.getName()));
        auction.setImage(auctionDTO.getImage());
        auction.setType(auctionDTO.getType());
        return auction;
    }

    public AuctionDTO buildAuctionDTO(Auction auction) {
        AuctionDTO auctionDTO = new AuctionDTO();
        auctionDTO.setId(auction.getId());
        auctionDTO.setAuctionDetailsId(auction.getAuctionDetailsId());
        auctionDTO.setName(auction.getName());
        auctionDTO.setImage(auction.getImage());
        auctionDTO.setType(auction.getType());
        return auctionDTO;
    }

    public List<AuctionDTO> getAuctions() {

        List<AuctionDTO> list = new ArrayList<AuctionDTO>();
        for (Auction auction : auctionRepository.findAll()) {
            AuctionDTO auctionDTO = buildAuctionDTO(auction);
            System.out.println(auctionDTO.toString());
            System.out.println("\n");
            list.add(auctionDTO);
        }
        return list;
    }

    public List<AuctionDTO> getUpcomingAuctions() {

        List<AuctionDTO> auctions = new ArrayList<AuctionDTO>();
        List<AuctionDTO> result = new ArrayList<AuctionDTO>();
        auctions=getAuctions();
        for(AuctionDTO auctionDTO : auctions){
            if(auctionDTO.getType().contains("upcoming")){
                result.add(auctionDTO);
            }
        }
        return result;
    }

    public List<AuctionDTO> getEndedAuctions() {

        List<AuctionDTO> auctions = new ArrayList<AuctionDTO>();
        List<AuctionDTO> result = new ArrayList<AuctionDTO>();
        auctions=getAuctions();
        for(AuctionDTO auctionDTO : auctions){
            if(auctionDTO.getType().contains("ended")){
                result.add(auctionDTO);
            }
        }
        return result;
    }

    public ResponseEntity<AuctionDTO> getAuctionById(Integer auctionId) throws ResourceNotFoundException {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow(() -> new ResourceNotFoundException("Licitatia cu id-ul " + auctionId + " nu a fost gasita"));
        AuctionDTO auctionDTO = buildAuctionDTO(auction);
        return ResponseEntity.ok().body(auctionDTO);
    }

    public Auction createAuction(AuctionDTO auctionDTO) {
        Auction auction = buildAuction(auctionDTO);
        return this.auctionRepository.save(auction);
    }

    public ResponseEntity<Auction> updateAuction(Integer auctionId, AuctionDTO auctionDetails) throws ResourceNotFoundException {

        Auction auction = auctionRepository.findById(auctionId).orElseThrow(() -> new ResourceNotFoundException("Licitatia cu id-ul " + auctionId + " nu a fost gasita"));
        auction.setAuctionDetailsId(auctionDetails.getAuctionDetailsId());
        auction.setName(auctionDetails.getName());
        auction.setImage(auctionDetails.getImage());
        auction.setType(auctionDetails.getType());
        return ResponseEntity.ok(this.auctionRepository.save(auction));
    }

    public Map<String, Boolean> deleteAuction(Integer auctionId) throws ResourceNotFoundException {
        Auction auction=auctionRepository.findById(auctionId).orElseThrow(()->new ResourceNotFoundException("Licitatia cu id-ul " + auctionId + " nu a fost gasita"));
        this.auctionRepository.delete(auction);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}

