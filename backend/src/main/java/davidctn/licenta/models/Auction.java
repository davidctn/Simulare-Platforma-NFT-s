package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="auction_details_id")
    private Integer auctionDetailsId;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @Column(name="type")
    private String type;


    public Auction(){

    }

    public Auction(Integer auctionDetailsId,
                   String name,
                   String image,
                   String type) {
        this.auctionDetailsId = auctionDetailsId;
        this.name = name;
        this.image=image;
        this.type=type;
    }

    public Auction(Auction auction){
        this.auctionDetailsId=auction.auctionDetailsId;
        this.name=auction.name;
        this.image=auction.image;
        this.type=auction.type;
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

    public void setId(Integer id) { this.id = id; }

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
