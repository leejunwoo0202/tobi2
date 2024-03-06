package study.tobi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.tobi.ioc.bean.AnnotatedHello;
import study.tobi.ioc.bean.AnnotatedHelloConfig;
import study.tobi.ioc.bean.Hello;
import study.tobi.ioc.bean.Printer;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = {"/context.xml" })
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

    @Test
    public void 계층구조테스트(){


        ApplicationContext parent = new GenericXmlApplicationContext("/parentContext.xml");

        GenericApplicationContext child = new GenericApplicationContext(parent);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(child);
        reader.loadBeanDefinitions("/childContext.xml");
        child.refresh();

        Printer printer = child.getBean("printer", Printer.class);
        Assertions.assertThat(printer).isNotNull();

        Hello hello = child.getBean("hello", Hello.class);
        Assertions.assertThat(hello).isNotNull();

        hello.print();
        Assertions.assertThat(printer.toString()).isEqualTo("Hello Child");
    }

    @Test
    public void 컴포넌트빈주입테스트(){
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        "study.tobi.ioc.bean");

        AnnotatedHello hello = ctx.getBean("annotatedHello", AnnotatedHello.class);

        Assertions.assertThat(hello).isNotNull();




    }

    @Test
    public void 자바코드빈주입테스트(){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class);
        AnnotatedHello hello = ctx.getBean("AnnotatedHello", AnnotatedHello.class);

        AnnotatedHelloConfig config = ctx.getBean("annotatedHelloConfig", AnnotatedHelloConfig.class);
        Assertions.assertThat(config).isNotNull();
    }



}
