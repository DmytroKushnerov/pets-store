import io.restassured.response.Response;
import org.example.ClientAPI;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetDeletionTest {
    @Test // should be run after addNewPetTest
    public void deletePetTest() {
        ClientAPI clientAPI = new ClientAPI();

        long petId = PetCreationTest.lastCreatedPetId;
        Response response = clientAPI.deletePet(petId);
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test
    public void deletePetNotFoundTest() {
        ClientAPI clientAPI = new ClientAPI();

        int petId = 0;
        Response response = clientAPI.deletePet(petId);
        assertThat(response.statusCode(), equalTo(404));
    }
}
