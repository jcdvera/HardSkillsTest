package juan.hardskills.test.security;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
@Component
public class SecurityLogic {

    public String buildSecurityHeader(String user, String pass) {
        String encode = base64CredentialEncoder(user, pass);
        return "Basic " + encode;
    }

    private String base64CredentialEncoder(String user, String password) {
        String authorization = user + ":" + password;

        byte[] encodedBytes = authorization.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(encodedBytes);
    }
}
