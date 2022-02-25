package in.Assignment.Q9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring9.xml");
        context.registerShutdownHook();

        BeanLifeCycle beanLifeCycle=context.getBean("LifeCycle",BeanLifeCycle.class);
        System.out.println(beanLifeCycle);
        
        
        BeanLifeCycle LifeCycle1=context.getBean("LifeCycle1",BeanLifeCycle.class);
        System.out.println(LifeCycle1);
        
    }
}
