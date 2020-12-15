package juan.hardskills.test.rest;

import juan.hardskills.test.BancoFuturo;
import juan.hardskills.test.TestContext;
import juan.hardskills.test.entities.AccessTokenDTO;
import juan.hardskills.test.entities.Request;
import juan.hardskills.test.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
public abstract class TestsHttpActions <REQUEST extends Request, RESPONSE extends Response> {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected BancoFuturo bancoFuturo;

    public ResponseEntity<RESPONSE> makeCall(REQUEST request, Class<RESPONSE> responseClass) {
        return restTemplate.exchange(bancoFuturo.getUrl() + getEndpoint(), whichMethod(), getEntity(request), responseClass);
    }

    public ResponseEntity<AccessTokenDTO> callAuthService(String authHeader) {
        return restTemplate.exchange(bancoFuturo.getUrl() + getEndpoint(), whichMethod(), getCredentialEntity(authHeader), AccessTokenDTO.class);
    }

    private HttpEntity<Object> getCredentialEntity(String authHeader) {
        return new HttpEntity<>(getCredentialHeaders(authHeader));
    }

    protected HttpEntity<Object> getEntity(REQUEST request) {
        return new HttpEntity<> (request, getHeaders());
    }

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", TestContext.CONTEXT.getACCESSTOKEN());
        return headers;
    }

    protected HttpHeaders getCredentialHeaders(String authHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", authHeader);
        return headers;
    }

    protected abstract HttpMethod whichMethod();

    protected abstract String getEndpoint();
}
