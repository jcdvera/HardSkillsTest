package juan.hardskills.test.transfers;

import juan.hardskills.test.BancoFuturo;
import juan.hardskills.test.entities.WireTransferDTO;
import juan.hardskills.test.entities.WireTransferRequest;
import juan.hardskills.test.rest.TestsHttpActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Juan Camilo Dvera on 12/15/20
 */
@Component
public class WireTransferActions extends TestsHttpActions <WireTransferRequest, WireTransferDTO> {

    @Autowired
    private BancoFuturo bancoFuturo;

    public ResponseEntity<WireTransferDTO> executeWireTransfer(WireTransferRequest request){
        return makeCall(request, WireTransferDTO.class);
    }

    @Override
    protected HttpMethod whichMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getEndpoint() {
        return bancoFuturo.getWireTransferEndpoint();
    }
}
