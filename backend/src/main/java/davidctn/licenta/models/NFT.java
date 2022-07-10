package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="nft")
public class NFT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="traits_container_id")
    private Integer traitsContainerId;
    @Column(name="content")
    private String content;
    @Column(name="collection_name")
    private String collectionName;
    @Column(name="tag")
    private Integer tag;
    @Column(name="number_of_traits")
    private Integer numberOfTraits;
    @Column(name="price")
    private Double price;
    @Column(name="address")
    private String address;
    @Column(name="owner_address")
    private String ownerAddress;


    public NFT(){

    }

    public NFT(Integer traitsContainerId,
               String content,
               String collectionName,
               Integer tag,
               Integer numberOfTraits,
               Double price,
               String address,
               String ownerAddress) {
        this.traitsContainerId = traitsContainerId;
        this.content = content;
        this.collectionName = collectionName;
        this.tag = tag;
        this.numberOfTraits = numberOfTraits;
        this.price=price;
        this.address=address;
        this.ownerAddress=ownerAddress;
    }

    public NFT(NFT nft){
        this.traitsContainerId=nft.traitsContainerId;
        this.content=nft.content;
        this.collectionName=nft.collectionName;
        this.tag=nft.tag;
        this.numberOfTraits=nft.numberOfTraits;
        this.price=nft.price;
        this.address=nft.address;
        this.ownerAddress=nft.ownerAddress;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getTraitsContainerId() {
        return traitsContainerId;
    }

    public void setTraitsContainerId(Integer traitsContainerId) {
        this.traitsContainerId = traitsContainerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getNumberOfTraits() {
        return numberOfTraits;
    }

    public void setNumberOfTraits(Integer numberOfTraits) {
        this.numberOfTraits = numberOfTraits;
    }
}
