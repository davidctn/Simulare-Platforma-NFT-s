package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.NFTDTO;
import davidctn.licenta.data_transfer_object.UserDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.NFT;
import davidctn.licenta.models.User;
import davidctn.licenta.repositories.NFTRepository;
import davidctn.licenta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NFTService {

    private final NFTRepository nftRepository;

    private final UserRepository userRepository;

    private final UserService userService;

  @Autowired
    public NFTService(NFTRepository nftRepository,
                      UserRepository userRepository,
                      UserService userService){
      this.nftRepository=nftRepository;
      this.userRepository=userRepository;
      this.userService=userService;
  }

    public NFT buildNFT(NFTDTO nftDTO){

        NFT nft = new NFT();
        nft.setTraitsContainerId(nftDTO.getTraitsContainerId());
        nft.setContent(nftDTO.getContent());
        nft.setCollectionName(nftDTO.getCollectionName());
        nft.setTag(nftDTO.getTag());
        nft.setNumberOfTraits(nftDTO.getNumberOfTraits());
        nft.setPrice(nftDTO.getPrice());
        nft.setAddress(nftDTO.getAddress());
        nft.setOwnerAddress(nftDTO.getOwnerAddress());
        return nft;
    }

    public NFTDTO buildNFTDTO(NFT nft){

        NFTDTO nftDTO = new NFTDTO();
        nftDTO.setId(nft.getId());
        nftDTO.setTraitsContainerId(nft.getTraitsContainerId());
        nftDTO.setContent(nft.getContent());
        nftDTO.setCollectionName(nft.getCollectionName());
        nftDTO.setTag(nft.getTag());
        nftDTO.setNumberOfTraits(nft.getNumberOfTraits());
        nftDTO.setPrice(nft.getPrice());
        nftDTO.setAddress(nft.getAddress());
        nftDTO.setOwnerAddress(nft.getOwnerAddress());
        return nftDTO;
    }

    public List<NFTDTO> getNFTs(){
        List<NFTDTO>list=new ArrayList<NFTDTO>();
        for(NFT nft : nftRepository.findAll()){
            NFTDTO nftDTO= buildNFTDTO(nft);
            nftDTO.toString();
            System.out.println("\n");
            list.add(nftDTO);
        }
        return list;
    }


    public ResponseEntity<NFTDTO> getNFTById(Integer nftId) throws ResourceNotFoundException {
        NFT nft=nftRepository.findById(nftId).orElseThrow(()->new ResourceNotFoundException("NFT-ul cu id-ul "+nftId+" nu a fost gasit"));
        NFTDTO nftDTO= buildNFTDTO(nft);
        return ResponseEntity.ok().body(nftDTO);
    }

    public ResponseEntity<NFTDTO> listNFT(Integer id,Double price) throws ResourceNotFoundException {

      NFTDTO nftDTO = new NFTDTO();
        List<NFT> nfts=nftRepository.findAll();
        for(NFT nft : nfts){
            if(nft.getId()==id && price>0){
                nftDTO= buildNFTDTO(nft);
                nftDTO.setPrice(price);
                updateNFT(nftDTO.getId(),nftDTO);
            }
        }
        return ResponseEntity.ok().body(nftDTO);
    }

    public ResponseEntity<NFTDTO> delistNFT(Integer id) throws ResourceNotFoundException {

        NFTDTO nftDTO = new NFTDTO();
        List<NFT> nfts=nftRepository.findAll();
        for(NFT nft : nfts){
            if(nft.getId()==id && nft.getPrice()>0){
                nftDTO= buildNFTDTO(nft);
                double unlist = -1;
                nftDTO.setPrice(unlist);
                updateNFT(nftDTO.getId(),nftDTO);
            }
        }
        return ResponseEntity.ok().body(nftDTO);
    }


    public ResponseEntity<NFTDTO> buyNFT(Integer id,Double price,Integer userId) throws ResourceNotFoundException {

        String address="";
        NFTDTO nftDTO = new NFTDTO();
        UserDTO userDTO = new UserDTO();
        List<NFT> nfts=nftRepository.findAll();
        List<User> users=userRepository.findAll();
        for(User user : users){
            if(user.getId()==userId){
                userDTO= userService.buildUserDTO(user);
            }
        }
        for(NFT nft : nfts){
            if(nft.getId()==id && userDTO.getBalance()>=price){
                nftDTO= buildNFTDTO(nft);
                double unlist = -1;
                nftDTO.setPrice(unlist);
                address=nftDTO.getOwnerAddress();
                nftDTO.setOwnerAddress(userDTO.getAddress());
                userDTO.setBalance(userDTO.getBalance()-price);
                updateNFT(nftDTO.getId(),nftDTO);
                userService.updateUser(userDTO.getId(),userDTO);
            }
        }

        for(User user : users){
            if(user.getAddress().contains(address)){
                UserDTO userTemp= userService.buildUserDTO(user);
                Double newBalance= userTemp.getBalance()+90*price/100;
                userTemp.setBalance(newBalance);
                userService.updateUser(userTemp.getId(),userTemp);
            }
        }
        return ResponseEntity.ok().body(nftDTO);
    }

    public List<NFTDTO> getNFTsByCollectionName(String name) throws ResourceNotFoundException {
        List<NFTDTO>list=new ArrayList<NFTDTO>();
        List<NFT> nfts=nftRepository.findAll();
        for(NFT nft : nfts){
            if(nft.getCollectionName().contains(name) && nft.getPrice()>0){
               NFTDTO nftDTO= buildNFTDTO(nft);
               list.add(nftDTO);
            }
        }
        return list;
    }

    public List<NFTDTO> getNFTsByAddress(String address) throws ResourceNotFoundException {
        List<NFTDTO>list=new ArrayList<NFTDTO>();
        List<NFT> nfts=nftRepository.findAll();
        for(NFT nft : nfts){
            if(nft.getOwnerAddress().contains(address)){
                NFTDTO nftDTO= buildNFTDTO(nft);
                list.add(nftDTO);
            }
        }
        return list;
    }


    public NFT createNFT(NFTDTO nftDTO) {

        NFT nft= buildNFT(nftDTO);
        return this.nftRepository.save(nft);
    }

    public ResponseEntity<NFT> updateNFT(Integer nftId, NFTDTO NFTDetails) throws ResourceNotFoundException {
        NFT nft=nftRepository.findById(nftId).orElseThrow(()->new ResourceNotFoundException("NFT-ul cu id-ul "+nftId+" nu a fost gasit"));
        nft.setTraitsContainerId(NFTDetails.getTraitsContainerId());
        nft.setContent(NFTDetails.getContent());
        nft.setCollectionName(NFTDetails.getCollectionName());
        nft.setTag(NFTDetails.getTag());
        nft.setNumberOfTraits(NFTDetails.getNumberOfTraits());
        nft.setPrice(NFTDetails.getPrice());
        nft.setAddress(NFTDetails.getAddress());
        nft.setOwnerAddress(NFTDetails.getOwnerAddress());
        return ResponseEntity.ok(this.nftRepository.save(nft));
    }

    public Map<String, Boolean> deleteNFT(Integer nftId) throws ResourceNotFoundException {
        NFT nft=nftRepository.findById(nftId).orElseThrow(()->new ResourceNotFoundException("NFT-ul cu id-ul "+nftId+" nu a fost gasit"));
        this.nftRepository.delete(nft);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }


}
