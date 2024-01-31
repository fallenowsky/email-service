package pl.kurs.mailservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.kurs.mailservice.model.CurrencyExchangePackage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private static final String SENDER_EMAIL = "testblabla@gmail.com";

    private final JavaMailSender emailSender;

    @Async("asyncExecutor")
    private void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER_EMAIL);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendConfirmation(CurrencyExchangePackage exchangePackage) {
        String subject = "Currency exchanged";
        StringBuilder builder = new StringBuilder();
        builder.append("You have exchanged currency");

        sendMessage(exchangePackage.getEmail(), subject, builder.toString());
    }
}


