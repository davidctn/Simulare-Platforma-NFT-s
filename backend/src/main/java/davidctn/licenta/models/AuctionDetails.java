package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="auction_details")
public class AuctionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="description")
    private String description;
    @Column(name="starting_bid")
    private Double startingBid;
    @Column(name="final_bid")
    private Double finalBid;
    @Column(name="nft_id")
    private Integer nftId;
    @Column(name="winner_address")
    private String winnerAddress;
    @Column(name="state")
    private String state;
    @Column(name="discord")
    private String discord;
    @Column(name="twitter")
    private String twitter;
    @Column(name="token")
    private String token;
    @Column(name="collection_name")
    private String collectionName;
    @Column(name="date")
    private String date;

    public AuctionDetails(){

    }

    public AuctionDetails(String description,
                          Double startingBid,
                          Double finalBid,
                          Integer nftId,
                          String winnerAddress,
                          String state,
                          String discord,
                          String twitter,
                          String token,
                          String collectionName,
                          String date) {
        this.description = description;
        this.startingBid = startingBid;
        this.finalBid = finalBid;
        this.nftId = nftId;
        this.winnerAddress = winnerAddress;
        this.state = state;
        this.discord = discord;
        this.twitter = twitter;
        this.token = token;
        this.collectionName=collectionName;
        this.date=date;
    }

    public AuctionDetails(AuctionDetails auctionDetails){
        this.description = auctionDetails.description;
        this.startingBid = auctionDetails.startingBid;
        this.finalBid = auctionDetails.finalBid;
        this.nftId = auctionDetails.nftId;
        this.winnerAddress = auctionDetails.winnerAddress;
        this.state = auctionDetails.state;
        this.discord = auctionDetails.discord;
        this.twitter = auctionDetails.twitter;
        this.token = auctionDetails.token;
        this.collectionName=auctionDetails.collectionName;
        this.date=auctionDetails.date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getId() { return id;}

    public void setId(Integer id) { this.id = id; }

    public String getDescription() { return description; }

    public Double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(Double startingBid) {
        this.startingBid = startingBid;
    }

    public Double getFinalBid() {
        return finalBid;
    }

    public void setFinalBid(Double finalBid) {
        this.finalBid = finalBid;
    }

    public Integer getNftId() {
        return nftId;
    }

    public void setDescription(String description) { this.description = description; }

    public void setNftId(Integer nftId) {
        this.nftId = nftId;
    }

    public String getWinnerAddress() {
        return winnerAddress;
    }

    public void setWinnerAddress(String winnerAddress) {
        this.winnerAddress = winnerAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
