package juan.hardskills.test.definition;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import juan.hardskills.test.AbstractContext;
import juan.hardskills.test.entities.AccessTokenDTO;
import juan.hardskills.test.security.SecurityActions;
import juan.hardskills.test.security.SecurityLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.util.Map;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
public class SecurityDefinitions extends AbstractContext implements En {

    private String userName;
    private String password;

    @Autowired
    private SecurityActions securityActions;

    @Autowired
    private SecurityLogic securityLogic;

    public SecurityDefinitions() {
        Given("^que existe un usuario con los siguientes datos$", (DataTable dataTable) -> {
            Map<String, String> data = dataTable.asMap(String.class, String.class);
            userName = data.get("username");
            password = data.get("password");
        });
        When("^el usuario solicita un AccessToken al API usando sus credenciales$", () -> {
            String authHeader = securityLogic.buildSecurityHeader(userName, password);
            ResponseEntity<AccessTokenDTO> responseEntity = securityActions.executeAuthCall(authHeader);
            testContext().setResponse(responseEntity);
            testContext().setACCESSTOKEN(responseEntity.getBody().getAccess_token());
        });
        When("^el usuario solicita un AccessToken al API usando creedenciales invalidas$", () -> {
            password = "InvalidPass123";
            String authHeader = securityLogic.buildSecurityHeader(userName, password);
            testContext().setResponse(securityActions.executeAuthCall(authHeader));
        });
    }
}
