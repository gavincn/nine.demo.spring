package test.nine.mvc;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.math.BigDecimal;

/**
 * Created by pingping on 三月/17/15.
 */
@Configuration
public class TestContext {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);

        BigDecimal b1 = new BigDecimal("712569312664357328695151392");
        BigDecimal b2 = new BigDecimal("8100824045303269669937");

        BigDecimal b3 = b1.add(b2);
//        b3.toString();

        return messageSource;
    }

    /*@Bean
    public TodoService todoService() {
        return Mockito.mock(TodoService.class);
    }*/
}
