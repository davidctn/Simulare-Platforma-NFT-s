package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="drop")
public class Drop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="drop_details_id")
    private Integer dropDetailsId;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @Column(name="type")
    private String type;
    public Drop(){

    }

    public Drop(Integer dropDetailsId,
                String name,
                String image,
                String type){
        this.dropDetailsId=dropDetailsId;
        this.name=name;
        this.image=image;
        this.type=type;
    }

    public Drop(Drop drop){
        this.dropDetailsId=drop.dropDetailsId;
        this.name=drop.name;
        this.image=drop.image;
        this.type=drop.type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getDropDetailsId() {
        return dropDetailsId;
    }

    public void setDropDetailsId(Integer dropDetailsId) {
        this.dropDetailsId = dropDetailsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
