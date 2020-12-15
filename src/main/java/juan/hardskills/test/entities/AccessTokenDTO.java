package juan.hardskills.test.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessTokenDTO extends Response {

    private String access_token;
    private Integer expires_in;
    private String token_type;
    private String message;
}
