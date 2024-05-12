package berger.levrault.users.Repo;

import berger.levrault.users.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    @Override
    Optional<Role> findById(Integer integer);
    Optional<Role> findByName(String name);
}
