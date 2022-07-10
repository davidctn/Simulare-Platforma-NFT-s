package davidctn.licenta.controllers;
import davidctn.licenta.data_transfer_object.NFTDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.NFT;
import davidctn.licenta.services.NFTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/nfts")
public class NFTController{

    private final NFTService nftService;

    @Autowired
    public NFTController(NFTService nftService){ this.nftService=nftService; }


    @GetMapping()
    public List<NFTDTO> getNFTs() throws ResourceNotFoundException {
        return nftService.getNFTs();
    }

    @GetMapping("/collection/{name}")
    public List<NFTDTO> getNFTsByCollectionName(@PathVariable(value="name") String name) throws ResourceNotFoundException {
        return nftService.getNFTsByCollectionName(name);
    }

    @GetMapping("my-nfts/{owner_address}")
    public List<NFTDTO> getNFTsByAddress(@PathVariable(value="owner_address") String address) throws ResourceNotFoundException {
        return nftService.getNFTsByAddress(address);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NFTDTO> getNFTById(@PathVariable(value="id") Integer nftId) throws ResourceNotFoundException {
        return nftService.getNFTById(nftId);
    }

    @GetMapping("/list/{id}/{price}")
    public ResponseEntity<NFTDTO> listNFT(@PathVariable(value="id") Integer nftId, @PathVariable(value="price") Double price) throws ResourceNotFoundException {
        return nftService.listNFT(nftId,price);
    }
    @GetMapping("/delist/{id}")
    public ResponseEntity<NFTDTO> delistNFT(@PathVariable(value="id") Integer nftId) throws ResourceNotFoundException {
        return nftService.delistNFT(nftId);
    }

    @GetMapping("/buy/{id}/{price}/{userId}")
    public ResponseEntity<NFTDTO> buyNFT(@PathVariable(value="id") Integer nftId,
                                         @PathVariable(value="price") Double price,
                                                 @PathVariable(value="userId") Integer userId) throws ResourceNotFoundException {
        return nftService.buyNFT(nftId,price,userId);
    }

    @PostMapping("/create")
    public NFT createNFT(@RequestBody NFTDTO nftDTO) throws ResourceNotFoundException { return nftService.createNFT(nftDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<NFT> updateNFT(@PathVariable(value="id") Integer nftId,
                                                 @Validated @RequestBody NFTDTO nftDetails)
            throws ResourceNotFoundException {

        return nftService.updateNFT(nftId,nftDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteNFT(@PathVariable(value ="id") Integer nftId) throws ResourceNotFoundException {
        return nftService.deleteNFT(nftId);
    }
}
