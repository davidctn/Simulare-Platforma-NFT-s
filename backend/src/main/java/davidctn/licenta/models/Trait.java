package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="trait")
public class Trait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="content")
    private String content;
    @Column(name="chance_of_drop")
    private Double chanceOfDrop;
    @Column(name="rarity")
    private String rarity;

    public Trait(){

    }

    public Trait(String name,
                 String content,
                 Double chanceOfDrop,
                 String rarity) {
        this.name = name;
        this.content = content;
        this.chanceOfDrop = chanceOfDrop;
        this.rarity = rarity;
    }

    public Trait(Trait trait){
        this.name = trait.name;
        this.content = trait.content;
        this.chanceOfDrop = trait.chanceOfDrop;
        this.rarity = trait.rarity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getChanceOfDrop() {
        return chanceOfDrop;
    }

    public void setChanceOfDrop(Double chanceOfDrop) {
        this.chanceOfDrop = chanceOfDrop;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
