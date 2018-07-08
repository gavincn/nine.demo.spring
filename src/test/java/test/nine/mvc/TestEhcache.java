package test.nine.mvc;

import junit.framework.TestCase;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;

/**
 * Created by pingping on 11/22/17.
 */
public class TestEhcache extends TestCase{


    public void testName() throws Exception {

        ManagementService.registerMBeans(new CacheManager(""),null,false,false,false,false);

    }

}
