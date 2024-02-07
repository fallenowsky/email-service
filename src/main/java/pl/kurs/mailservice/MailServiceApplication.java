package pl.kurs.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import pl.kurs.mailservice.properties.AsyncProperties;
import pl.kurs.mailservice.properties.EmailProperties;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(value = {AsyncProperties.class, EmailProperties.class})
public class MailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

}
