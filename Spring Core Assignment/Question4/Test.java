package in.Assignment.Q4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");

        BankAccountController controller =context.getBean("controller",BankAccountController.class);


        System.out.println("Bank Balance :"+controller.getBalance(0021211));
        System.out.println("Total Amount After Diposit:"+controller.deposit(0021211,3620));
        System.out.println("<================================================================>");
        System.out.println("Amount Withdraw:"+controller.withdraw(0021211,2000));
        System.out.println("Present Balance:"+controller.getBalance(1171));
        System.out.println("<================================================================>");
        System.out.println("Amount Transfer to 1172 :"+controller.fundTransfer(0021211,0021233,7000));
        System.out.println("Balace of 1171 :"+controller.getBalance(1171));
        System.out.println("Balace of 1171 :"+controller.getBalance(1172));


    }
}
