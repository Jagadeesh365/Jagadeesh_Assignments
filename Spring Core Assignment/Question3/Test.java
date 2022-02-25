package in.Aissignment.Q3;

import org.springframework.aop.framework.AopConfigException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml");

        BankAccountController controller = (BankAccountController)context.getBean("controller");


        System.out.println("Bank Balance :"+controller.getBalance(0021211));
        System.out.println("Total Amount After Diposit:"+controller.deposit(0021211,5000));
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("Amount Withdraw:"+controller.withdraw(0021211,5000));
        System.out.println("Present Balance:"+controller.getBalance(1171));
        System.out.println("___________________________________________");
        System.out.println("Amount Transfer to 1172 :"+controller.fundTransfer(0021211,0021233,5000));
        System.out.println("Balace of 1171 :"+controller.getBalance(1171));
        System.out.println("Balace of 1171 :"+controller.getBalance(1172));


    }
}
