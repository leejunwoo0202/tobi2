package study.tobi.ioc.bean;

import org.springframework.stereotype.Component;

@Component
public class B implements AB{

    public void run(){
        System.out.println("b");
    }
}
