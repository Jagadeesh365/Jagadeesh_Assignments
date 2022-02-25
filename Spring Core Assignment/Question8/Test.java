package in.Assignment.Q8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring8.xml");

        context.registerShutdownHook();

        Hostel hostel= (Hostel)context.getBean("hostel");
        hostel.eat();

        Hostel hostel1= (Hostel)context.getBean("hostel1");
        hostel1.eat();

        Hostel hostel2= (Hostel)context.getBean("hostel2");
        hostel2.eat();

    }


}
