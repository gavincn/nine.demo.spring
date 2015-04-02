package test.demo.demo1;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pingping on 三月/13/15.
 */
public class TestLogin extends JUnitActionBase {

    @Test
    public void testlogin() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setServletPath("/web/login");
        request.addParameter("name", "liu");
        request.addParameter("password", "liu");
        request.setMethod("POST");
        // 执行URI对应的action
        final ModelAndView mav = this.excuteAction(request, response);
        // Assert logic
        TestCase.assertEquals("main", mav.getViewName());
        String msg = (String) request.getAttribute("message");
        System.out.println(msg);
    }
}
