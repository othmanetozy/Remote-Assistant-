package berger.levrault.app.users.Repo;

import berger.levrault.app.users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
