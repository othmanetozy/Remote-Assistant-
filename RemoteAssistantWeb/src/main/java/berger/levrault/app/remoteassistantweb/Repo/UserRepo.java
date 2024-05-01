package berger.levrault.app.remoteassistantweb.Repo;

import berger.levrault.app.remoteassistantweb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
