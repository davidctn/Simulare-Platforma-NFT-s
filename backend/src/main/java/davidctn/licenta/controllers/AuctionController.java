package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.AuctionDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Auction;
import davidctn.licenta.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService){ this.auctionService=auctionService; }

    @GetMapping()
    public List<AuctionDTO> getAuctions() throws ResourceNotFoundException {
        return auctionService.getAuctions();
    }

    @GetMapping("/upcoming")
    public List<AuctionDTO> getUpcomingAuctions() throws ResourceNotFoundException {
        return auctionService.getUpcomingAuctions();
    }

    @GetMapping("/ended")
    public List<AuctionDTO> getEndedAuctions() throws ResourceNotFoundException {
        return auctionService.getEndedAuctions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuctionDTO> getAuctionById(@PathVariable(value="id") Integer auctionId) throws ResourceNotFoundException {
        return auctionService.getAuctionById(auctionId);
    }

    @PostMapping("/create")
    public Auction createAuction(@RequestBody AuctionDTO auctionDTO) throws ResourceNotFoundException { return auctionService.createAuction(auctionDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<Auction> updateAuction(@PathVariable(value="id") Integer auctionId,
                                                     @Validated @RequestBody AuctionDTO auctionDetails)
            throws ResourceNotFoundException {

        return auctionService.updateAuction(auctionId,auctionDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteAuction(@PathVariable(value ="id") Integer auctionId) throws ResourceNotFoundException {
        return auctionService.deleteAuction(auctionId);
    }

}
