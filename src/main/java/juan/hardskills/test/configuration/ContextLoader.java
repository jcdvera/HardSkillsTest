package juan.hardskills.test.configuration;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import juan.hardskills.test.TestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@SpringBootTest
public class ContextLoader {
    private final static Logger logger = LogManager.getLogger(ContextLoader.class.getName());

    @Before
    public void setup() {
        logger.info("Starting spring context...");
    }

    @After
    public void tearDown() {
        TestContext.CONTEXT.reset();
    }
}