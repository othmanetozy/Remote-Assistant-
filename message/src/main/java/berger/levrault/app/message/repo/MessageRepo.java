package berger.levrault.app.message.repo;

import berger.levrault.app.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
