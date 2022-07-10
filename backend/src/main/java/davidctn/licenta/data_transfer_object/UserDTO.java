package davidctn.licenta.data_transfer_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDTO {

    private Integer id;
    private String address;
    private Double balance;
    private String password;

    public UserDTO(){

    }

    public UserDTO(
                String address,
                Double balance,
                String password
                ) {
        this.address = address;
        this.balance=balance;
        this.password=password;

    }

    public UserDTO(UserDTO userDTO){
        this.address = userDTO.address;
        this.balance=userDTO.balance;
        this.password=userDTO.password;
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
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
