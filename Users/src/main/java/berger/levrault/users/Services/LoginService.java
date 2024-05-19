package berger.levrault.users.Services;

import berger.levrault.users.Dtos.UserDto;
import berger.levrault.users.Entity.User;
import berger.levrault.users.Enum.EmailTemplateName;
import berger.levrault.users.Repo.RoleRepo;
import berger.levrault.users.Repo.TokenRepo;
import berger.levrault.users.Repo.UserRepo;
import berger.levrault.users.security.Token;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginService {

    private final TokenRepo tokenRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;

    private final EmailService emailService;

    @Value("${mailing.frontend.activation-url}")
    private String activationUrl;


    public LoginService(TokenRepo tokenRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepo, UserRepo userRepo, EmailService emailService) {
        this.tokenRepo = tokenRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    public void register(UserDto request) throws MessagingException {
        var userRole = roleRepo.findByName("USER")
                .orElseThrow(()->new IllegalStateException("User not found"));

        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(List.of(userRole).toString());
        userRepo.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActionToken(user);
        emailService.sendEmail(
                user.getEmail(),
                user.getUsername(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,"Account activated"
        );
    }


    private String generateAndSaveActionToken(User user){
        String generatedToken = generateActivateCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(16))
                .user(user)
                .build();
        tokenRepo.save(token);
        return generatedToken;
    }

    private String generateActivateCode(int lenght) {
        String characters = "0387389293";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < lenght; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }
}
