package pl.kurs.mailservice.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pl.kurs.mailservice.model.CurrencyExchangePackage;
import pl.kurs.mailservice.service.EmailService;

@Component
@RequiredArgsConstructor
public class EmailReceiver {
    private final EmailService service;
    @RabbitListener(queues = "exchangeRateQueue")
    private void fetchCurrencyExchange(CurrencyExchangePackage exchangePackage) {
        service.sendConfirmation(exchangePackage);
    }
}
