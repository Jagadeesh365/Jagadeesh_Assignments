package in.Assignment.Q6;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring6.xml");
        DbConfiguration dbConfiguration =context.getBean("dbConfiguration",DbConfiguration.class);
        dbConfiguration.display();
    }

}