import org.example.ClientAPI;
import org.example.User;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserLoginTest {
    ClientAPI clientAPI = new ClientAPI();
    User user = new User();
    @Test // valid login
    public void validLoginUser() {
        user.setUsername("user1");
        user.setPassword("TestPassword");

        Response response = clientAPI.loginUser("user1", "TestPassword");

        int statusCode = response.then().extract().statusCode();
        assertThat(statusCode, equalTo(200));
    }
}