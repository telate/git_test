import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// 模拟一个表现层。用于调用业务层

public class textPerson {
    /**
     * 获取Spring IOC核心容器
     * @param args
     */
    public static void main(String[] args) {

       /*// 获取核心容器对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
       // 根据Id获取对象
        Object person = ac.getBean("person");
        System.out.println(person);
*/
       // 获取核心容器的对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
       // 根据ID获取对象
        Object person = ac.getBean("person");
        // 输出
        System.out.println(person);


    }
}
