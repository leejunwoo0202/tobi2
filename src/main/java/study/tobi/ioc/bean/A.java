package study.tobi.ioc.bean;

import org.springframework.stereotype.Component;

@Component
public class A implements AB{

    public void run(){
        System.out.println("A");
    }
}
