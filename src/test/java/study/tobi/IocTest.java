package study.tobi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.tobi.ioc.bean.Hello;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/context.xml")
public class IocTest {

    @Test
    public void genericApplicationContext(){
        GenericApplicationContext ac = new GenericApplicationContext();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ac);
        reader.loadBeanDefinitions(
                "/context.xml");

        ac.refresh();

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        Assertions.assertThat(ac.getBean("printer").toString() ).isEqualTo("Hello Spring");
    }


}
