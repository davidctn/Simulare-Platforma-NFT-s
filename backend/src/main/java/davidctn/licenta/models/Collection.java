package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="collection_details_id")
    private Integer collectionDetailsId;
    @Column(name="nfts_container_id")
    private Integer nftsContainerId;
    @Column(name="traits_container_id")
    private Integer traitsContainerId;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @Column(name="type")
    private String type;

    public Collection(){

    }

    public Collection(Integer collectionDetailsId,
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

    public Collection(Collection collection){
        this.collectionDetailsId = collection.collectionDetailsId;
        this.nftsContainerId = collection.nftsContainerId;
        this.traitsContainerId = collection.traitsContainerId;
        this.name = collection.name;
        this.image=collection.image;
        this.type=collection.type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
