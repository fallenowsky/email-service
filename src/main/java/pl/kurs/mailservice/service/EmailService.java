package pl.kurs.mailservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.kurs.mailservice.model.CurrencyExchangePackage;
import pl.kurs.mailservice.properties.EmailProperties;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final EmailProperties emailProperties;

    @Async("asyncExecutor")
    public void sendMessage(String to, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailProperties.getFrom());
        message.setTo(to);
        message.setSubject(emailProperties.getSubject());
        message.setText(content);
        emailSender.send(message);
    }

    public void sendConfirmation(CurrencyExchangePackage exchangePackage) {
        String message = "You have exchanged " + exchangePackage.getFrom() + " to " + exchangePackage.getTo() +
                " with the amount of " + exchangePackage.getAmount() + ".\n" +
                "Exchanged amount is " + exchangePackage.getResult() + "PLN";

        sendMessage(exchangePackage.getEmail(), message);
    }
}


