package berger.levrault.users.Services;

import berger.levrault.users.Dtos.UserDto;
import berger.levrault.users.Entity.User;
import berger.levrault.users.Repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    private final UserRepo userRepo;


    public User createUser(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

}
