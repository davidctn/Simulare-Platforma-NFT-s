package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CollectionDTO {

    private Integer id;
    private Integer collectionDetailsId;
    private Integer nftsContainerId;
    private Integer traitsContainerId;
    private String name;
    private String image;
    private String type;

    public CollectionDTO(){

    }

    public CollectionDTO(Integer collectionDetailsId,
                         Integer nftsContainerId,
                         Integer traitsContainerId,
                         String name,
                         String image,
                         String type) {
        this.collectionDetailsId = collectionDetailsId;
        this.nftsContainerId = nftsContainerId;
        this.traitsContainerId = traitsContainerId;
        this.name = name;
        this.image=image;
        this.type=type;
    }

    public CollectionDTO(CollectionDTO collectionDTO){
        this.collectionDetailsId = collectionDTO.collectionDetailsId;
        this.nftsContainerId = collectionDTO.nftsContainerId;
        this.traitsContainerId = collectionDTO.traitsContainerId;
        this.name = collectionDTO.name;
        this.image=collectionDTO.image;
        this.type=collectionDTO.type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id=id;}

    public Integer getCollectionDetailsId() {
        return collectionDetailsId;
    }

    public void setCollectionDetailsId(Integer collectionDetailsId) {
        this.collectionDetailsId = collectionDetailsId;
    }

    public Integer getNftsContainerId() {
        return nftsContainerId;
    }

    public void setNftsContainerId(Integer nftsContainerId) {
        this.nftsContainerId = nftsContainerId;
    }

    public Integer getTraitsContainerId() {
        return traitsContainerId;
    }

    public void setTraitsContainerId(Integer traitsContainerId) {
        this.traitsContainerId = traitsContainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
