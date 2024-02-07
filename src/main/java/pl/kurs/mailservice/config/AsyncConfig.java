package pl.kurs.mailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pl.kurs.mailservice.properties.AsyncProperties;

@Configuration
public class AsyncConfig {


    @Bean
    public ThreadPoolTaskExecutor asyncExecutor(AsyncProperties asyncProperties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(asyncProperties.getThreadPool());
        executor.initialize();
        return executor;
    }
}
