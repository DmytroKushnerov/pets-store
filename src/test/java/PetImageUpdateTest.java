import io.restassured.response.Response;
import org.example.ClientAPI;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetImageUpdateTest {
    @Test
    public void updatePetImageTest() {
        ClientAPI clientAPI = new ClientAPI();

        int petId = 0;

        String additionalMetadata = "Test MetaData";

        String filePath = "C:\\Users\\Dmytro_Kushnerov\\w3kr4m2fi3111.png";
        File imageFile = new File(filePath);

        Response response = clientAPI.uploadPetImage(petId, additionalMetadata, imageFile);

        assertThat(response.statusCode(), equalTo(200));
    }
}
