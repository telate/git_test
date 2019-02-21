import com.itcast.service.IAccountService;
import com.itcast.service.impl.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

    public static void main(String[] args) {
        // 读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象

        IAccountService accountService=(IAccountService)ac.getBean("accountService");
        accountService.saveAccount();


      /*   AccountService bean = ac.getBean(AccountService.class);
        bean.saveAccount();*/

       // AccountService accountService = ac.getBean("accountService", AccountService.class);


    }
}
