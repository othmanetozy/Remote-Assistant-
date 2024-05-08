package berger.levrault.users.Controllers;

import berger.levrault.users.Dtos.UserDto;
import berger.levrault.users.Entity.User;
import berger.levrault.users.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/new/users")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto);
        System.out.println("hello world");
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
