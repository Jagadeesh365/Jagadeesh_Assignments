package in.Assignment.Q10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring10.xml");
        ContextAwareExample contextAwareExample =context.getBean("contextAware",ContextAwareExample.class);
        contextAwareExample.display();

        ContextAwareExample contextAwareExample1 = (ContextAwareExample) context.getBean("contextAware1",ContextAwareExample.class);
        contextAwareExample1.display();
    }
}