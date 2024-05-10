package berger.levrault.app.message.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConversationDto {
    private Long id;
    private String conversationId;
    private Long userID1;
    private Long userID2;
}
