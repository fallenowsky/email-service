package pl.kurs.mailservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mail")
@Getter
@Setter
public class EmailProperties {

    private String from;
    private String subject;

}
