package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DropDetailsDTO {
    private Integer id;
    private Integer supply;
    private Double mintPrice;
    private String shortDescription;
    private String description;
    private String roadmap;
    private String team;
    private String website;
    private String discord;
    private String twitter;
    private String image;

    public DropDetailsDTO(){

    }

    public DropDetailsDTO(Integer supply,
                       Double mintPrice,
                       String shortDescription,
                       String description,
                       String roadmap,
                       String team,
                       String website,
                       String discord,
                       String twitter,
                       String image) {
        this.supply = supply;
        this.mintPrice = mintPrice;
        this.shortDescription = shortDescription;
        this.description = description;
        this.roadmap = roadmap;
        this.team = team;
        this.website = website;
        this.discord = discord;
        this.twitter = twitter;
        this.image = image;
    }

    public DropDetailsDTO(DropDetailsDTO dropDetailsDTO){
        this.supply = dropDetailsDTO.supply;
        this.mintPrice =dropDetailsDTO.mintPrice;
        this.shortDescription = dropDetailsDTO.shortDescription;
        this.description =dropDetailsDTO.description;
        this.roadmap = dropDetailsDTO.roadmap;
        this.team = dropDetailsDTO.team;
        this.website = dropDetailsDTO.website;
        this.discord = dropDetailsDTO.discord;
        this.twitter = dropDetailsDTO.twitter;
        this.image = dropDetailsDTO.image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id=id;}

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(String roadmap) {
        this.roadmap = roadmap;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
