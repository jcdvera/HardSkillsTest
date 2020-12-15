package juan.hardskills.test.security;

import juan.hardskills.test.BancoFuturo;
import juan.hardskills.test.entities.AccessTokenDTO;
import juan.hardskills.test.rest.TestsHttpActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Component
public class SecurityActions extends TestsHttpActions {

    @Autowired
    protected BancoFuturo bancoFuturo;

    public ResponseEntity<AccessTokenDTO> executeAuthCall(String authHeader) {
        return callAuthService(authHeader);
    }

    @Override
    protected HttpMethod whichMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getEndpoint() {
        return bancoFuturo.getAuthEndpoint();
    }
}
