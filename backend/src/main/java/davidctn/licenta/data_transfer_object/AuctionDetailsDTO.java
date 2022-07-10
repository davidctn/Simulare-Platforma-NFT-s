package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AuctionDetailsDTO {

    private Integer id;
    private String description;
    private Double startingBid;
    private Double finalBid;
    private Integer nftId;
    private String winnerAddress;
    private String state;
    private String discord;
    private String twitter;
    private String token;
    private String collectionName;
    private String date;

    public AuctionDetailsDTO(){

    }

    public AuctionDetailsDTO(String description,
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

    public AuctionDetailsDTO(AuctionDetailsDTO auctionDetailsDTO){
        this.description = auctionDetailsDTO.description;
        this.startingBid = auctionDetailsDTO.startingBid;
        this.finalBid = auctionDetailsDTO.finalBid;
        this.nftId = auctionDetailsDTO.nftId;
        this.winnerAddress = auctionDetailsDTO.winnerAddress;
        this.state = auctionDetailsDTO.state;
        this.discord = auctionDetailsDTO.discord;
        this.twitter = auctionDetailsDTO.twitter;
        this.token = auctionDetailsDTO.token;
        this.collectionName=auctionDetailsDTO.collectionName;
        this.date=auctionDetailsDTO.date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setId(Integer id) { this.id=id;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
