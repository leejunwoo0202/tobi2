package study.tobi.ioc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    void userDao(){

    }

    @Configuration
    @Profile("spring-test")
    public static class SpringTestConfig{

    }

    @Configuration
    @Profile("dev")
    public static class DevConfig{

    }

    @Configuration
    @Profile("production")
    public static class ProductionConfig{

    }




}
