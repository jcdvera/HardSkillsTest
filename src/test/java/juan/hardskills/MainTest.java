package juan.hardskills;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@CucumberOptions(
        features = {"src/main/resources/templateFeatures"},
        plugin = {"pretty","html:target/cucumber","json:target/cucumber.json"},
        monochrome = true,
        glue = "juan.hardskills",
        tags = {""}
)
@RunWith(Cucumber.class)
public class MainTest {
}
