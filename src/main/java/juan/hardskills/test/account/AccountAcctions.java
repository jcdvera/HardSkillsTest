package juan.hardskills.test.account;

import juan.hardskills.test.BancoFuturo;
import juan.hardskills.test.entities.AccountDetailsDTO;
import juan.hardskills.test.entities.Request;
import juan.hardskills.test.rest.TestsHttpActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Component
public class AccountAcctions extends TestsHttpActions <Request, AccountDetailsDTO>{

    @Autowired
    private BancoFuturo bancoFuturo;

    public ResponseEntity<AccountDetailsDTO> executeAccountDetailsCall(){
        return makeCall(null, AccountDetailsDTO.class);
    }

    @Override
    protected HttpMethod whichMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getEndpoint() {
        return bancoFuturo.getAccountDetailsEndpoint();
    }
}
