package davidctn.licenta.models;

import javax.persistence.*;

@Entity
@Table(name="client")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="address")
    private String address;
    @Column(name="balance")
    private Double balance;
    @Column(name="password")
    private String password;


    public User(){

    }

    public User(String address,
                Double balance,
                String password
                ) {
                this.address = address;
                this.balance=balance;
                this.password=password;
    }

    public User(User user){
        this.address = user.address;
        this.balance=user.balance;
        this.password= user.password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}
