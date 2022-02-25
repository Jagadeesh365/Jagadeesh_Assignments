package Question2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");

		// calling list of answer
		Question question = (Question) context.getBean("Question");
		question.displayAnswerList();

		// calling set of answer
		for (int i = 0; i <= 40; i++) {
			System.out.print("=");

		}
		System.out.println();

		Question question1 = context.getBean("Question1", Question.class);
		question1.displayAnswerSet();

		// calling map of answer
		for (int i = 0; i <= 40; i++) {
			System.out.print("=");
		}
		System.out.println();
		Question question2 = context.getBean("Question2", Question.class);
		question2.displayAnswerMap();

	}
}
