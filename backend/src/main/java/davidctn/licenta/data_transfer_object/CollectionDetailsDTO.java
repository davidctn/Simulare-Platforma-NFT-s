package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import davidctn.licenta.models.CollectionDetails;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CollectionDetailsDTO {

    private Integer id;
    private String description;
    private Integer supply;
    private Double mintPrice;
    private boolean isSoldOut;
    private Integer minimumNrOfTraits;
    private Integer maximumNrOfTraits;
    private String rarityTypes;

    public CollectionDetailsDTO() {

    }

    public CollectionDetailsDTO(String description,
                                Integer supply,
                                Double mintPrice,
                                String collectionImage,
                                boolean isSoldOut,
                                Integer minimumNrOfTraits,
                                Integer maximumNrOfTraits,
                                String rarityTypes) {
        this.description = description;
        this.supply = supply;
        this.mintPrice = mintPrice;
        this.isSoldOut = isSoldOut;
        this.minimumNrOfTraits = minimumNrOfTraits;
        this.maximumNrOfTraits = maximumNrOfTraits;
        this.rarityTypes=rarityTypes;
    }

    public CollectionDetailsDTO(CollectionDetailsDTO collectionDetailsDTO) {
        this.description = collectionDetailsDTO.description;
        this.supply = collectionDetailsDTO.supply;
        this.mintPrice = collectionDetailsDTO.mintPrice;
        this.isSoldOut = collectionDetailsDTO.isSoldOut;
        this.minimumNrOfTraits = collectionDetailsDTO.minimumNrOfTraits;
        this.maximumNrOfTraits = collectionDetailsDTO.maximumNrOfTraits;
        this.rarityTypes=collectionDetailsDTO.rarityTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id=id;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSupply() {
        return supply;
    }

    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public Double getMintPrice() {
        return mintPrice;
    }

    public void setMintPrice(Double mintPrice) {
        this.mintPrice = mintPrice;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public Integer getMinimumNrOfTraits() {
        return minimumNrOfTraits;
    }

    public void setMinimumNrOfTraits(Integer minimumNrOfTraits) {
        this.minimumNrOfTraits = minimumNrOfTraits;
    }

    public Integer getMaximumNrOfTraits() {
        return maximumNrOfTraits;
    }

    public void setMaximumNrOfTraits(Integer maximumNrOfTraits) {
        this.maximumNrOfTraits = maximumNrOfTraits;
    }

    public String getRarityTypes() { return rarityTypes; }

    public void setRarityTypes(String rarityTypes) { this.rarityTypes = rarityTypes; }
}
