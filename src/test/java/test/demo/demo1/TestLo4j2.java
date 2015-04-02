package test.demo.demo1;

//import junit.framework.Assert;

import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pingping on 三月/9/15.
 */
public class TestLo4j2 {

    //    Logger logger = LogManager.getLogger(TestLo4j2.class);
    Logger logger = LogManager.getLogger("logger");

    @Before
    public void setUp() throws Exception {
        logger.info("before");
    }

    @Test
    public void testLog4j2() {
        logger.trace("testLog4j2----------------------");
        for (int i = 0; i < 1; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
//                    logger.entry();//同等于logger.trace("entry");
                    logger.trace("trace" + Thread.currentThread().getName());
                    logger.debug("debug");
                    logger.info("info");
                    logger.warn("warn");
                    logger.error("error");
                    logger.fatal("fatal" + Thread.currentThread().getName());
//                    logger.exit();//同等于logger.trace("exit");
                }
            });
            t.start();
        }
    }

    @After
    public void tearDown() throws Exception {
        logger.debug("after");
    }
}
