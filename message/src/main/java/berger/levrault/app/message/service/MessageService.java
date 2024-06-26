package berger.levrault.app.message.service;

import berger.levrault.app.message.entity.Message;
import berger.levrault.app.message.repo.MessageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    public final MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    public Message getMessageById(long id) {
        return messageRepo.findById(id).orElse(null);
    }

    public Message SaveMessage(Message message) {
        try{
            if (message.getId() == null || message.getContent().isEmpty()) {
                throw new IllegalArgumentException("Message vide");
            }
            return messageRepo.save(message);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
