package juan.hardskills.test.entities;

import lombok.Data;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Data
public class Account {
    private String type;
    private Integer accountID;
    private String owner;
    private Integer amount;
}
