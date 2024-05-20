package berger.levrault.users.Dtos;


import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Authenticationrequestdto {


    private String Email;
    @Size(min = 8, message = "Password Required 8 caracteres")
    private String password;
}
