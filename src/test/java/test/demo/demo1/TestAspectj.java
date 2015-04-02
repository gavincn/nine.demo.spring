package test.demo.demo1;

import com.demo.handler.UserHandler;
import com.demo.handler.UserSecurityHandler;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pingping on 三月/15/15.
 */
public class TestAspectj extends TestCase {

    @Test
    public void testAop(){
        System.out.println(System.getProperty("user.dir"));
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "file:/Users/pingping/devworks/nine.demo.spring/web/WEB-INF/spring-mvc.xml" });
        UserHandler userSecurityHandler=(UserHandler)appContext.getBean("UserSecurityHandler");

        try {
            userSecurityHandler.isValid("liu","liu");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("测试结束");

    }
}
