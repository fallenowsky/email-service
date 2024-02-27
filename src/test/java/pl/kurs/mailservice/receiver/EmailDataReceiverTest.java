package pl.kurs.mailservice.receiver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.kurs.mailservice.model.CurrencyExchangePackage;
import pl.kurs.mailservice.service.EmailService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
class EmailDataReceiverTest {

    private static final String RABBIT_IMAGE_NAME = "rabbitmq:3.9-management-alpine";

    @MockBean
    private EmailService emailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private CurrencyExchangePackage currencyPackage;


    @Container
    @ServiceConnection
    private static RabbitMQContainer rabbitmq = new RabbitMQContainer(RABBIT_IMAGE_NAME);


    @BeforeEach
    public void setup() {
        currencyPackage = new CurrencyExchangePackage()
                .setEmail("example@gmail.com")
                .setAmount(50)
                .setResult(BigDecimal.valueOf(240))
                .setFrom("CHF")
                .setTo("PLN");
    }


    @Test
    public void connectionEstablished() {
        assertTrue(rabbitmq.isCreated());
        assertTrue(rabbitmq.isRunning());
    }

    @Test
    public void testFetchCurrencyExchange_HappyPath_ResultsInMockMethodsInvocations() {
        String queueName = "send_email_data_queue";
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(queueName, currencyPackage);
        }

        await()
                .atMost(Duration.of(101, ChronoUnit.MILLIS))
                .untilAsserted(() -> verify(emailService, times(10))
                        .sendConfirmation(currencyPackage));

    }


}