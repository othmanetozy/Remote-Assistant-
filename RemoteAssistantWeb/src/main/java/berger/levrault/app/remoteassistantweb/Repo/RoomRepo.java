package berger.levrault.app.remoteassistantweb.Repo;

import berger.levrault.app.remoteassistantweb.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
}
