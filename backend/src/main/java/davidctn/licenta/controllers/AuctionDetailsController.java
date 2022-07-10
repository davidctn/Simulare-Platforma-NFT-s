package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.AuctionDTO;
import davidctn.licenta.data_transfer_object.AuctionDetailsDTO;
import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Auction;
import davidctn.licenta.models.AuctionDetails;
import davidctn.licenta.services.AuctionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auctionsDetails")
public class AuctionDetailsController {

    private final AuctionDetailsService auctionDetailsService;

    @Autowired
    public AuctionDetailsController(AuctionDetailsService auctionDetailsService) {
        this.auctionDetailsService = auctionDetailsService;
    }

    @GetMapping()
    public List<AuctionDetailsDTO> getAuctionsDetails() throws ResourceNotFoundException {
        return auctionDetailsService.getAuctionsDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuctionDetailsDTO> getAuctionDetailsById(@PathVariable(value = "id") Integer auctionDetailsId) throws ResourceNotFoundException {
        return auctionDetailsService.getAuctionDetailsById(auctionDetailsId);
    }

    @PostMapping("/create")
    public AuctionDetails createAuctionDetails(@RequestBody AuctionDetailsDTO auctionDetailsDTO) throws ResourceNotFoundException {
        return auctionDetailsService.createAuctionDetails(auctionDetailsDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuctionDetails> updateAuction(@PathVariable(value = "id") Integer auctionDetailsId,
                                                        @Validated @RequestBody AuctionDetailsDTO auctionDetailsDTO)
            throws ResourceNotFoundException {

        return auctionDetailsService.updateAuctionDetails(auctionDetailsId, auctionDetailsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAuctionDetails(@PathVariable(value = "id") Integer auctionDetailsId) throws ResourceNotFoundException {
        return auctionDetailsService.deleteAuctionDetails(auctionDetailsId);
    }
}