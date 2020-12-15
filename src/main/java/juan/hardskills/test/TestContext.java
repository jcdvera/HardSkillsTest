package juan.hardskills.test;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juan Camilo Dvera on 12/14/20
 */
public enum TestContext {
    CONTEXT;

    private static final String RESPONSE = "RESPONSE";
    private static final String ACCESSTOKEN = "access_token";
    private final ThreadLocal<Map<String,Object>> testContexts = ThreadLocal.withInitial(HashMap::new);

    public <T> T get(String name) {
        return (T) testContexts.get().get(name);
    }

    public <T> T set(String name, T object) {
        testContexts.get().put(name, object);
        return object;
    }

    public <T> ResponseEntity<T> getResponse() {
        return get(RESPONSE);
    }

    public <T> ResponseEntity<T> setResponse(ResponseEntity<T> response) {
        return set(RESPONSE,response);
    }

    public String getACCESSTOKEN() {
        return get(ACCESSTOKEN);
    }

    public String setACCESSTOKEN(String accessToken) {
        return set(ACCESSTOKEN, accessToken);
    }

    public void reset() {
        testContexts.get().clear();
    }
}
