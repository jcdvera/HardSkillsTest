package juan.hardskills.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Data
@Component
public class BancoFuturo {
    @Value("${bancofuturo.base.url}")
    private String url;

    @Value("${bancofuturo.authentication}")
    private String authEndpoint;

    @Value("${bancofuturo.account.details.endpoint}")
    private String accountDetailsEndpoint;

    @Value("${bancofuturo.transfer.endpoint}")
    private String wireTransferEndpoint;

}
