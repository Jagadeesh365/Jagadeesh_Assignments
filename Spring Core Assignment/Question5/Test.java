package in.Assignment.Q5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring5.xml");

        // add  <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
        Student studentRequired =context.getBean("studentRequired",Student.class);
        studentRequired.getStudentDetails();


        // add <bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
        // in xml file
        Student studentResource =context.getBean("studentResource",Student.class);
        studentResource.getStudentDetailsUsingResource();


    }
}
