package berger.levrault.app.message.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senderid;
    private String  receiverid;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;
    private Conversation conversation;
}
