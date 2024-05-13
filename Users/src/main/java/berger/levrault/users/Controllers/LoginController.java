package berger.levrault.users.Controllers;

import berger.levrault.users.Dtos.UserDto;
import berger.levrault.users.Services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class LoginController {


    private final LoginService loginService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@RequestBody UserDto request){
        loginService.register(request);
        return ResponseEntity.accepted().build();
    }
}