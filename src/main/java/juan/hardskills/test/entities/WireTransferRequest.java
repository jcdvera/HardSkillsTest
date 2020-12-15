package juan.hardskills.test.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Juan Camilo Dvera on 12/15/20
 */
@Data
@Builder
public class WireTransferRequest extends Request {

    private String name;
    private Integer accountID;
    private Integer amount;
    private String type;
}
