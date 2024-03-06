package study.tobi.ioc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotatedHelloConfig {

    @Bean
    public AnnotatedHello AnnotatedHello(){
        return new AnnotatedHello();
    }
}
