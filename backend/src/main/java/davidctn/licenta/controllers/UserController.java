package davidctn.licenta.controllers;

import davidctn.licenta.data_transfer_object.UserDTO;
import davidctn.licenta.exceptions.ResourceNotFoundException;
import davidctn.licenta.models.User;
import davidctn.licenta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("")
    public List<UserDTO> getUsers() throws ResourceNotFoundException {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value="id") Integer userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserDTO userDTO) throws ResourceNotFoundException { return userService.createUser(userDTO); }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value="id") Integer userId,
                                            @Validated @RequestBody UserDTO userDetails)
            throws ResourceNotFoundException {

        return userService.updateUser(userId,userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> DeleteUser(@PathVariable(value ="id") Integer userId) throws ResourceNotFoundException {
        return userService.deleteUser(userId);
    }

}
