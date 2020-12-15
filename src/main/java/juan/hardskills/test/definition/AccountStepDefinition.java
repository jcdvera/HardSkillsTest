package juan.hardskills.test.definition;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import juan.hardskills.test.AbstractContext;
import juan.hardskills.test.account.AccountAcctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
public class AccountStepDefinition extends AbstractContext implements En {

    @Value("${invalid.accesstoken}")
    private String invalidAccessToken;

    @Autowired
    private AccountAcctions accountAcctions;

    public AccountStepDefinition() {
        When("^el usuario solicita la informacion de su cuenta al API usando el AccessToken generado$", () -> {
            testContext().setResponse(accountAcctions.executeAccountDetailsCall());
        });
        When("^el usuario solicita la informacion de su cuenta al API usando AccessToken invalido$", () -> {
            testContext().setACCESSTOKEN(invalidAccessToken);
            testContext().setResponse(accountAcctions.executeAccountDetailsCall());
        });
    }
}
