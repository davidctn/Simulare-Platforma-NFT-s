package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.TraitDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.Trait;
import davidctn.licenta.repositories.TraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TraitService {

    private final TraitRepository traitRepository;

    private Integer id;
    private String name;
    private String content;
    private Double chanceOfDrop;
    private String rarity;

    @Autowired
    public TraitService(TraitRepository traitRepository){ this.traitRepository=traitRepository; }

    public Trait buildTrait(TraitDTO traitDTO){
        Trait trait = new Trait();
        trait.setName(traitDTO.getName());
        trait.setContent(traitDTO.getContent());
        trait.setChanceOfDrop(traitDTO.getChanceOfDrop());
        trait.setRarity(traitDTO.getRarity());
        return trait;
    }

    public TraitDTO buildTraitDTO(Trait trait){
        TraitDTO traitDTO = new TraitDTO();
        traitDTO.setId(trait.getId());
        traitDTO.setName(trait.getName());
        traitDTO.setContent(trait.getContent());
        traitDTO.setChanceOfDrop(trait.getChanceOfDrop());
        traitDTO.setRarity(trait.getRarity());
        return traitDTO;
    }

    public List<TraitDTO> getTraits(){
        List<TraitDTO> list=new ArrayList<TraitDTO>();
        for(Trait trait : traitRepository.findAll()){
            TraitDTO traitDTO= buildTraitDTO(trait);
            traitDTO.toString();
            System.out.println("\n");
            list.add(traitDTO);
        }
        return list;
    }

    public ResponseEntity<TraitDTO> getTraitById(Integer traitId) throws ResourceNotFoundException {
        Trait trait=traitRepository.findById(traitId).orElseThrow(()->new ResourceNotFoundException("Trasatura cu id-ul "+traitId+" nu a fost gasita"));
        TraitDTO traitDTO= buildTraitDTO(trait);
        return ResponseEntity.ok().body(traitDTO);
    }

    public Trait createTrait(TraitDTO traitDTO) {

        Trait trait= buildTrait(traitDTO);
        return this.traitRepository.save(trait);
    }

    public ResponseEntity<Trait> updateTrait(Integer traitId, TraitDTO traitDetails) throws ResourceNotFoundException {
        Trait trait=traitRepository.findById(traitId).orElseThrow(()->new ResourceNotFoundException("Trasatura cu id-ul "+traitId+" nu a fost gasita"));
        trait.setName(traitDetails.getName());
        trait.setContent(traitDetails.getContent());
        trait.setChanceOfDrop(traitDetails.getChanceOfDrop());
        trait.setRarity(traitDetails.getRarity());
        return ResponseEntity.ok(this.traitRepository.save(trait));
    }

    public Map<String, Boolean> deleteTrait(Integer traitId) throws ResourceNotFoundException {
        Trait trait=traitRepository.findById(traitId).orElseThrow(()->new ResourceNotFoundException("Trasatura cu id-ul "+traitId+" nu a fost gasita"));
        this.traitRepository.delete(trait);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
