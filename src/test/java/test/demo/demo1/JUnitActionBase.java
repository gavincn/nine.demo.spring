package test.demo.demo1;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
//import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pingping on 三月/12/15.
 */
public class JUnitActionBase {
    private static HandlerMapping handlerMapping;
    private static HandlerAdapter handlerAdapter;

    @BeforeClass
    public static void setUp() {
        if (handlerMapping == null) {
            String[] configs = {"file:web/WEB-INF/spring-mvc.xml"};
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            context.setConfigLocations(configs);
            MockServletContext msc = new MockServletContext();
            context.setServletContext(msc);
            context.refresh();
            TestCase.assertNotNull(context);
            msc.setAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC", context);
//            msc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
            /*handlerMapping = (HandlerMapping) context
                    .getBean(DefaultAnnotationHandlerMapping.class);
            handlerAdapter = (HandlerAdapter) context.getBean(
                    context.getBeanNamesForType(AnnotationMethodHandlerAdapter.class)[0]);*/
        }
    }

    public ModelAndView excuteAction(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        final ModelAndView model = handlerAdapter.handle(request, response,
                chain.getHandler());
        return model;
    }
}
