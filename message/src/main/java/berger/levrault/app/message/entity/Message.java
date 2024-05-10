package berger.levrault.app.message.entity;
import berger.levrault.app.message.Enum.MessageType;



import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "\"Message\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private MessageType type;
    private Long senderId;
    private Long receiverId;
    private String content;
    private Date date;
}
