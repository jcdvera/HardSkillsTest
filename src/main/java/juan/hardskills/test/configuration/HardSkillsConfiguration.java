package juan.hardskills.test.configuration;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Configuration
public class HardSkillsConfiguration {

    @Bean(name = "restTemplate")
    public TestRestTemplate restTemplate() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        return restTemplate;
    }
}
