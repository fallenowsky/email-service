package pl.kurs.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import pl.kurs.mailservice.properties.AsyncProperties;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(value = AsyncProperties.class)
public class MailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

}
