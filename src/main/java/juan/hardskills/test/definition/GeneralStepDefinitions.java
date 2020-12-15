package juan.hardskills.test.definition;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import juan.hardskills.test.AbstractContext;
import juan.hardskills.test.entities.AccessTokenDTO;
import juan.hardskills.test.entities.Account;
import juan.hardskills.test.entities.AccountDetailsDTO;
import juan.hardskills.test.entities.WireTransferDTO;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;


/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
public class GeneralStepDefinitions <T> extends AbstractContext implements En {
    public GeneralStepDefinitions() {
        Then("^el API responde con un codigo \"([^\"]*)\"$", (Integer httpCode) -> {
            final ResponseEntity response = testContext().getResponse();
            assertThat(response.getStatusCode().value()).isEqualTo(httpCode);
        });
        And("^el API retorna un AccessToken$", () -> {
            final ResponseEntity<AccessTokenDTO> response = testContext().getResponse();
            assertThat(response.getBody().getAccess_token()).isNotNull();
        });
        And("^el API retorna como mensaje \"([^\"]*)\"$", (String message) -> {
            final ResponseEntity<T> response = testContext().getResponse();
            if (response.getBody() instanceof AccessTokenDTO) {
                AccessTokenDTO body = (AccessTokenDTO) response.getBody();
                assertThat(body.getMessage()).isEqualTo(message);
            }
            else if (response.getBody() instanceof AccountDetailsDTO) {
                AccountDetailsDTO body = (AccountDetailsDTO) response.getBody();
                assertThat(body.getMessage()).isEqualTo(message);
            }
            else if (response.getBody() instanceof WireTransferDTO) {
                WireTransferDTO body = (WireTransferDTO) response.getBody();
                assertThat(body.getMessage()).isEqualTo(message);
            }

        });
        And("^el API retrona el tipo de cuenta$", () -> {
            final ResponseEntity<AccountDetailsDTO> respone = testContext().getResponse();
            assertThat(respone.getBody().getAccount().getType()).isEqualTo("Ahorros");
        });
        And("^el API retorna el ID de la cuenta$", () -> {
            final ResponseEntity<AccountDetailsDTO> response = testContext().getResponse();
            assertThat(response.getBody().getAccount().getAccountID()).isEqualTo(1234);
        });
        And("^el API retorna el nombre del propietario de la cuenta$", () -> {
            final ResponseEntity<AccountDetailsDTO> response = testContext().getResponse();
            assertThat(response.getBody().getAccount().getOwner()).isEqualTo("Juan Camilo D vera");
        });
        And("^el API retorna el dinero guardado en la cuenta$", () -> {
            final ResponseEntity<AccountDetailsDTO> response = testContext().getResponse();
            assertThat(response.getBody().getAccount().getAmount()).isNotNull();
        });
    }
}
