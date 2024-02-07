package pl.kurs.mailservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.async")
@Getter
@Setter
public class AsyncProperties {

    private int threadPool;
}
