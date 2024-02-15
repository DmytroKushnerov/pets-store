import io.restassured.response.Response;
import org.example.ClientAPI;
import org.example.Pet;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetCreationTest {

    public static long lastCreatedPetId;
    @Test
    public void addNewPetTest() {
        ClientAPI clientAPI = new ClientAPI();

            Map<String, Object> category = new HashMap<>();
            category.put("id", 0);
            category.put("name", "string");

            Map<String, Object> tag = new HashMap<>();
            tag.put("id", 0);
            tag.put("name", "string");

            List<Map<String, Object>> tags = new ArrayList<>();
            tags.add(tag);

            List<String> photoUrls = Arrays.asList("string");

            Pet pet = new Pet(0, category, "doggie", photoUrls, tags, "available");

            Response response = clientAPI.addPet(pet);

            assertThat(response.getStatusCode(), equalTo(200));

            Pet createdPet = response.as(Pet.class);

            lastCreatedPetId = createdPet.getId();

        System.out.println("Created petId: " + lastCreatedPetId);

    }
}
