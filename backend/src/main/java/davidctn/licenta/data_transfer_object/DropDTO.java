package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DropDTO {

    private Integer id;
    private Integer dropDetailsId;
    private String name;
    private String image;
    private String type;

    public DropDTO(){

    }

    public DropDTO(Integer dropDetailsId,
                    String name,
                    String image,
                    String type){
        this.dropDetailsId=dropDetailsId;
        this.name=name;
        this.image=image;
        this.type=type;
    }

    public DropDTO(DropDTO dropDTO){
        this.dropDetailsId=dropDTO.dropDetailsId;
        this.name=dropDTO.name;
        this.image=dropDTO.image;
        this.type=dropDTO.type;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(Integer id) { this.id=id;}

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
