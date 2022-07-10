package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.CollectionDTO;
import davidctn.licenta.data_transfer_object.DropDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Drop;
import davidctn.licenta.repositories.DropRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DropService {

    private final DropRepositoy dropRepository;

    @Autowired
    public DropService(DropRepositoy dropRepository){
        this.dropRepository = dropRepository;
    }

    public Drop buildDrop(DropDTO dropDTO){
        Drop drop = new Drop();
        drop.setDropDetailsId(dropDTO.getDropDetailsId());
        drop.setName(dropDTO.getName());
        drop.setImage(dropDTO.getImage());
        drop.setType(dropDTO.getType());
        return drop;
    }

    public DropDTO buildDropDTO(Drop drop){
        DropDTO dropDTO = new DropDTO();
        dropDTO.setId(drop.getId());
        dropDTO.setDropDetailsId(drop.getDropDetailsId());
        dropDTO.setName(drop.getName());
        dropDTO.setImage(drop.getImage());
        dropDTO.setType(drop.getType());
        return dropDTO;
    }

    public List<DropDTO> getDrops() {
        List<DropDTO>list = new ArrayList<DropDTO>();
        for (Drop drop : dropRepository.findAll()) {
            DropDTO dropDTO = buildDropDTO(drop);
            System.out.println(dropDTO.toString());
            System.out.println("\n");
            list.add(dropDTO);
        }
        return list;
    }

    public List<DropDTO> getUpcomingDrops() {
        List<DropDTO> drops = new ArrayList<DropDTO>();
        List<DropDTO> result = new ArrayList<DropDTO>();
        drops=getDrops();
        for(DropDTO dropDTO : drops){
            if(dropDTO.getType().contains("upcoming")){
                result.add(dropDTO);
            }
        }
        return result;
    }

    public List<DropDTO> getEndedDrops() {
        List<DropDTO> drops = new ArrayList<DropDTO>();
        List<DropDTO> result = new ArrayList<DropDTO>();
        drops=getDrops();
        for(DropDTO dropDTO : drops){
            if(dropDTO.getType().contains("ended")){
                result.add(dropDTO);
            }
        }
        return result;
    }

    public ResponseEntity<DropDTO> getDropById(Integer dropId) throws ResourceNotFoundException {
        Drop drop= dropRepository.findById(dropId).orElseThrow(()->new ResourceNotFoundException("Drop-ul cu id-ul "+dropId+" nu a fost gasit"));
        DropDTO dropDTO= buildDropDTO(drop);
        return ResponseEntity.ok().body(dropDTO);
    }

    public Drop createDrop(DropDTO dropDTO) {
        Drop drop= buildDrop(dropDTO);
        return this.dropRepository.save(drop); }

    public ResponseEntity<Drop> updateDrop(Integer dropId, DropDTO dropDetails) throws ResourceNotFoundException {

        Drop drop=dropRepository.findById(dropId).orElseThrow(()->new ResourceNotFoundException("Drop-ul cu id-ul "+dropId+" nu a fost gasit"));
        drop.setDropDetailsId(dropDetails.getDropDetailsId());
        drop.setName(dropDetails.getName());
        drop.setImage(dropDetails.getImage());
        drop.setType(dropDetails.getType());
        return ResponseEntity.ok(this.dropRepository.save(drop));
    }

    public Map<String, Boolean> deleteDrop(Integer dropId) throws ResourceNotFoundException {
        Drop drop=dropRepository.findById(dropId).orElseThrow(()->new ResourceNotFoundException("Drop-ul cu id-ul "+dropId+" nu a fost gasit"));
        this.dropRepository.delete(drop);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
