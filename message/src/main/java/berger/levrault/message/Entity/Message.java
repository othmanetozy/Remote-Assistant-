package berger.levrault.message.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
