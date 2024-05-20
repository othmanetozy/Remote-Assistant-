package berger.levrault.users.Dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationResponsedto {
    public String Token;
}
