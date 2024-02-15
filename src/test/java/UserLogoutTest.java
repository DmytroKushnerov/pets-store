
import io.restassured.response.Response;
import org.example.ClientAPI;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Map;

public class UserLogoutTest {
    ClientAPI clientAPI = new ClientAPI();

    @Test
    public void logoutUserTest() {

        Response response = clientAPI.logoutUser();

        Map<String, String> responseBody = response.body().jsonPath().get();

        assertThat(response.getStatusCode(), equalTo(200));

    }
}
