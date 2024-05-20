package berger.levrault.users.Repo;

import berger.levrault.users.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
}
