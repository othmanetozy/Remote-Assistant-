package berger.levrault.app.message.Dto;

import berger.levrault.app.message.Enum.MessageType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {
    private Long id;
    private MessageType type;
    private Long senderId;
    private Long receiverId;
    private String content;
    private Date date;
}
