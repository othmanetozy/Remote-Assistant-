package berger.levrault.users.Services.impl;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@Builder
public class Authenticationrequest {

    private String Email;
    private String password;
}
