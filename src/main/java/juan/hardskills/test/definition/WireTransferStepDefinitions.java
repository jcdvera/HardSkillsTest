package juan.hardskills.test.definition;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import juan.hardskills.test.AbstractContext;
import juan.hardskills.test.entities.WireTransferRequest;
import juan.hardskills.test.transfers.WireTransferActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * Created by Juan Camilo Dvera on 12/15/20
 */
public class WireTransferStepDefinitions extends AbstractContext implements En {

    @Autowired
    private WireTransferActions wireTransferActions;

    @Value("${invalid.accesstoken}")
    private String invalidAccessToken;

    public WireTransferStepDefinitions() {
        When("^el usuario solicita hacer una transferencia usando un AccessToken valido a la siguiente cuenta$", (DataTable dataTable) -> {
            Map<String,String> data = dataTable.asMap(String.class, String.class);
            String owner = data.get("owner");
            String accountType = data.get("accountType");
            Integer accountID = Integer.valueOf(data.get("accountID"));
            Integer amount = Integer.valueOf(data.get("amount"));
            WireTransferRequest request = WireTransferRequest.builder().name(owner).accountID(accountID).type(accountType).amount(amount).build();
            testContext().setResponse(wireTransferActions.executeWireTransfer(request));
        });
        When("^el usuario solicita hacer una transferencia usando un AccessToken invalido a la siguiente cuenta$", (DataTable dataTable) -> {
            testContext().setACCESSTOKEN(invalidAccessToken);
            Map<String,String> data = dataTable.asMap(String.class, String.class);
            String owner = data.get("owner");
            String accountType = data.get("accountType");
            Integer accountID = Integer.valueOf(data.get("accountID"));
            Integer amount = Integer.valueOf(data.get("amount"));
            WireTransferRequest request = WireTransferRequest.builder().name(owner).accountID(accountID).type(accountType).amount(amount).build();
            testContext().setResponse(wireTransferActions.executeWireTransfer(request));
        });
    }
}
