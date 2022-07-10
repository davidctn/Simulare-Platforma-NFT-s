package davidctn.licenta.services;

import davidctn.licenta.data_transfer_object.UserDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.User;
import davidctn.licenta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserDTO buildUserDTO(User user){

        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAddress(user.getAddress());
        userDTO.setBalance(user.getBalance());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public User buildUser(UserDTO userDTO){

        User user=new User();
        user.setAddress(userDTO.getAddress());
        user.setBalance(userDTO.getBalance());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public List<UserDTO> getUsers(){
        List<UserDTO>list=new ArrayList<UserDTO>();
        for(User user : userRepository.findAll()){
            UserDTO userDTO = buildUserDTO(user);
            userDTO.toString();
            System.out.println("\n");
            list.add(userDTO);
        }
        return list;
    }

    public ResponseEntity<UserDTO> getUserById(Integer userId) throws ResourceNotFoundException {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Userul cu id-ul "+userId+" nu a fost gasit"));
        UserDTO userDTO= buildUserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    public User createUser(UserDTO userDTO) {

        User user= buildUser(userDTO);
        return this.userRepository.save(user);
    }

    public ResponseEntity<User> updateUser(Integer userId, UserDTO userDetails) throws ResourceNotFoundException {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Userul cu id-ul "+userId+" nu a fost gasit"));
        user.setAddress(userDetails.getAddress());
        user.setBalance(userDetails.getBalance());
        user.setPassword(userDetails.getPassword());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    public Map<String, Boolean> deleteUser(Integer userId) throws ResourceNotFoundException {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Userul cu id-ul "+userId+" nu a fost gasit"));
        this.userRepository.delete(user);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
