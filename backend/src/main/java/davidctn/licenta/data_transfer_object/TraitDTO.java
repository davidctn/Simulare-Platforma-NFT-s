package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TraitDTO {

    private Integer id;
    private String name;
    private String content;
    private Double chanceOfDrop;
    private String rarity;

    public TraitDTO(){

    }

    public TraitDTO(String name,
                 String content,
                 Double chanceOfDrop,
                 String rarity) {
        this.name = name;
        this.content = content;
        this.chanceOfDrop = chanceOfDrop;
        this.rarity = rarity;
    }

    public TraitDTO(TraitDTO traitDTO){
        this.name = traitDTO.name;
        this.content = traitDTO.content;
        this.chanceOfDrop = traitDTO.chanceOfDrop;
        this.rarity = traitDTO.rarity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id=id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getChanceOfDrop() {
        return chanceOfDrop;
    }

    public void setChanceOfDrop(Double chanceOfDrop) {
        this.chanceOfDrop = chanceOfDrop;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
