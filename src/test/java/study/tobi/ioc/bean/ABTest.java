package study.tobi.ioc.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ABTest {

    @Autowired
    AB b;

    @Test
    void injectionTest(){
        b.run();


    }

}