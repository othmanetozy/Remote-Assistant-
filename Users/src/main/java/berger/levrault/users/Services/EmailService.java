package berger.levrault.users.Services;

import berger.levrault.users.Enum.EmailTemplateName;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender MailSender;

    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendEmail(
            String to,
            String username,
            EmailTemplateName emailTemplateName,
            String confirmationUrl,
            String activationCode,
            String subject
    ) throws MessagingException {
        String templateName;
        if (emailTemplateName == null) {
            templateName = "confirm-email";
        }else {
            templateName = emailTemplateName.name();
        }

        MimeMessage mimeMessage = MailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage , MimeMessageHelper.MULTIPART_MODE_MIXED,
                StandardCharsets.UTF_8.name()
                );
        Map<String, Object> properties = new HashMap<>();
        properties.put("username",username);
        properties.put("confirmation_Url",confirmationUrl);
        properties.put("activation_Code",activationCode);

        Context context = new Context();
        context.setVariables(properties);

        helper.setFrom("othmane.TOZY@berger-levrault.com");
        helper.setTo(to);
        helper.setSubject(subject);

        String template = templateEngine.process(templateName,context);
        helper.setText(template,true);
        MailSender.send(mimeMessage);
    }
}
