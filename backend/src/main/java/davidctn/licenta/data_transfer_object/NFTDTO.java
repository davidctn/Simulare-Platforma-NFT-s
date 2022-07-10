package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NFTDTO {

    private Integer id;
    private Integer traitsContainerId;
    private String content;
    private String collectionName;
    private Integer tag;
    private Integer numberOfTraits;
    private Double price;
    private String address;
    private String ownerAddress;

    public NFTDTO(){

    }

    public NFTDTO(Integer traitsContainerId,
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

    public NFTDTO(NFTDTO nftDTO){
        this.traitsContainerId=nftDTO.traitsContainerId;
        this.content=nftDTO.content;
        this.collectionName=nftDTO.collectionName;
        this.tag=nftDTO.tag;
        this.numberOfTraits=nftDTO.numberOfTraits;
        this.price=nftDTO.price;
        this.address=nftDTO.address;
        this.ownerAddress=nftDTO.ownerAddress;
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

    public void setId(Integer id) { this.id=id;}

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
