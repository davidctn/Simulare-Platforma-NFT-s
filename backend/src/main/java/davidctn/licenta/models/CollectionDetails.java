package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="collection_details")
public class CollectionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "supply")
    private Integer supply;
    @Column(name = "mint_price")
    private Double mintPrice;
    @Column(name = "is_sold_out")
    private boolean isSoldOut;
    @Column(name = "minimum_nr_of_traits")
    private Integer minimumNrOfTraits;
    @Column(name = "maximum_nr_of_traits")
    private Integer maximumNrOfTraits;
    @Column(name = "rarity_types")
    private String rarityTypes;

    public CollectionDetails() {

    }

    public CollectionDetails(String description,
                             Integer supply,
                             Double mintPrice,
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

    public CollectionDetails(CollectionDetails collectionDetails) {
        this.description = collectionDetails.description;
        this.supply = collectionDetails.supply;
        this.mintPrice = collectionDetails.mintPrice;
        this.isSoldOut = collectionDetails.isSoldOut;
        this.minimumNrOfTraits = collectionDetails.minimumNrOfTraits;
        this.maximumNrOfTraits = collectionDetails.maximumNrOfTraits;
        this.rarityTypes=collectionDetails.rarityTypes;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

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


