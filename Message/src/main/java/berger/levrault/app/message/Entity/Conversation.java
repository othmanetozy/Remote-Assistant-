package berger.levrault.app.message.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerId1;
    private String ownerId2;
    private ConversationType conversationType;
    private List<User> participants = new ArrayList<>();
}
