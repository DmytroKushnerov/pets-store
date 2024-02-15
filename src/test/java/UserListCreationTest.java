import org.example.ClientAPI;
import org.example.User;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class UserListCreationTest {
    @Test
    public void createMultipleUsersWithList() {
        ClientAPI clientAPI = new ClientAPI();

        // Create users
        User user1 = new User(10, "user2", "TestFirstName2", "TestLastName2", "test2@io.com", "TestPassword2", "22345678", 0);
        User user2 = new User(11, "user3", "TestFirstName3", "TestLastName3", "test3@io.com", "TestPassword3", "32345678", 0);
        User user3 = new User(12, "user4", "TestFirstName4", "TestLastName4", "test4@io.com", "TestPassword4", "42345678", 0);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        int status = clientAPI.createUsersWithList(userList);

        assertEquals(200, status, "Failed to create user list");
    }
}