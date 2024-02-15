import org.example.ClientAPI;
import org.example.User;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTest {

    @Test
    public void createUser() {
        User user = new User(0, "user1", "TestFirstName", "TestLastName", "test@io.com", "TestPassword", "12345678", 0);
        ClientAPI clientAPI = new ClientAPI();

        int statusCode = clientAPI.create(user);

        assertThat(statusCode, equalTo(200));
    }
}