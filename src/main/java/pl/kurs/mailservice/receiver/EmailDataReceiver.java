package pl.kurs.mailservice.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pl.kurs.mailservice.model.CurrencyExchangePackage;
import pl.kurs.mailservice.service.EmailService;

@Component
@RequiredArgsConstructor
public class EmailDataReceiver {

    private final EmailService emailService;


    @RabbitListener(queues = "${app.rabbit.queue-name}")
    private void fetchCurrencyExchange(CurrencyExchangePackage exchangePackage) {
        emailService.sendConfirmation(exchangePackage);
    }
}
