package berger.levrault.app.message.controlleur;

import berger.levrault.app.message.entity.Message;
import berger.levrault.app.message.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {

    private final MessageService messageService;

    private SimpMessagingTemplate messagingTemplate;

    public MessageController(MessageService messageService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendMessage(@Payload Message message) {
        String senderUserID = String.valueOf(message.getSenderId());
        List<String> recipientUserIds = identifyRecipientUserIds(message);
        for (String recipientUserId : recipientUserIds) {
            if (!message.getSenderId().equals(senderUserID)) {
                sendMessageToUser(message, recipientUserId);
            }
        }
        return message;
    }

    public List<String> identifyRecipientUserIds(Message message) {
        List<String> recipientUserIds = new ArrayList<>();
        recipientUserIds.add("recipientUserId1");
        recipientUserIds.add("recipientUserId2");
        return recipientUserIds;
    }

    public void sendMessageToUser(Message message, String recipientUserId) {
        String destination = "/topic/messages/" + recipientUserId;
        messagingTemplate.convertAndSend(destination, message);
    }
}
