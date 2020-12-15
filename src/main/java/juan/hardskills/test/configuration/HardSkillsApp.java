package juan.hardskills.test.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@SpringBootApplication
@ComponentScan(basePackages = {"juan.hardskills"})
@PropertySource("classpath:test.properties")
public class HardSkillsApp {
}
