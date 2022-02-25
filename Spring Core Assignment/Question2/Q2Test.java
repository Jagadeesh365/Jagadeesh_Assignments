package Question2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class Q2Test {

    @Test
    void displayAnswerList() {
        Question questionExpacted = new Question();
        questionExpacted.setQuestionId(111);
        questionExpacted.setQuestion("what is Spring?");

        List<String> answers = Arrays.asList("Spring is a popular and widely used web framework of Java that providing extensive infrastructure support for modern webapplications development." ,"It enables the software developers to build applications from old Java objects..");
        questionExpacted.setAnswers(answers);



        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        Question questionActual = (Question)context.getBean("Question") ;

        assertEquals(questionExpacted.toString(),questionActual.toString());


    }

    @Test
    void displayAnswerSet() {
    }

    @Test
    void displayAnswerMap() {
    }
}
