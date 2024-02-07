package pl.kurs.mailservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AsyncConfig {

    @Value("${spring.async.thread-pool}")
    private int threads;

    @Bean
    public ExecutorService asyncExecutor() {
        return Executors.newFixedThreadPool(threads);
    }
}
