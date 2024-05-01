package berger.levrault.app.users.Repo;

import berger.levrault.app.users.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
}
