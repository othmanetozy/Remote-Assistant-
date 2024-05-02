package berger.levrault.users.Services;

import berger.levrault.users.Entity.User;
import berger.levrault.users.Repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {


    @Autowired
    private final UserRepo userRepo;


    public User createUser(User user){
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

}
