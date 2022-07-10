package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="drop_details")
public class DropDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="supply")
    private Integer supply;
    @Column(name="mint_price")
    private Double mintPrice;
    @Column(name="short_description")
    private String shortDescription;
    @Column(name="description")
    private String description;
    @Column(name="roadmap")
    private String roadmap;
    @Column(name="team")
    private String team;
    @Column(name="website")
    private String website;
    @Column(name="discord")
    private String discord;
    @Column(name="twitter")
    private String twitter;
    @Column(name="image")
    private String image;

    public DropDetails(){

    }

    public DropDetails(Integer supply,
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

    public DropDetails(DropDetails dropDetails){
        this.supply = dropDetails.supply;
        this.mintPrice =dropDetails.mintPrice;
        this.shortDescription = dropDetails.shortDescription;
        this.description =dropDetails.description;
        this.roadmap = dropDetails.roadmap;
        this.team = dropDetails.team;
        this.website = dropDetails.website;
        this.discord = dropDetails.discord;
        this.twitter = dropDetails.twitter;
        this.image = dropDetails.image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

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

