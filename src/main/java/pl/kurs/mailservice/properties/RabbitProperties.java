package pl.kurs.mailservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.rabbit")
@Getter
@Setter
public class RabbitProperties {

    private String queueName;
}
