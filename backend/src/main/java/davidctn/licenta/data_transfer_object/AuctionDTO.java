package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AuctionDTO {

    private Integer id;
    private Integer auctionDetailsId;
    private String name;
    private String image;
    private String type;

    public AuctionDTO(){

    }

    public AuctionDTO(Integer auctionDetailsId,
                      String name,
                      String image,
                      String type) {
        this.auctionDetailsId = auctionDetailsId;
        this.name = name;
        this.image=image;
        this.type=type;
    }

    public AuctionDTO(AuctionDTO auctionDTO){
        this.auctionDetailsId=auctionDTO.auctionDetailsId;
        this.name=auctionDTO.name;
        this.image=auctionDTO.image;
        this.type=auctionDTO.type;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAuctionDetailsId() {
        return auctionDetailsId;
    }

    public void setAuctionDetailsId(Integer auctionDetailsId) {
        this.auctionDetailsId = auctionDetailsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
