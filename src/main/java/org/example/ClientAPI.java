package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ClientAPI {
    private final String BASE_URL = "https://petstore.swagger.io/v2";

    public Response addPet(Pet pet) {
        return performPost(Endpoint.PET, pet);
    }

    public Response uploadPetImage(long petId, String additionalMetadata, File imageFile) {
        return given().
                multiPart("additionalMetadata", additionalMetadata).
                multiPart("file", imageFile).
                when().
                post(BASE_URL + Endpoint.PET_UPLOAD_IMAGE.getPath(), petId);
    }

    public Response updatePet(Pet pet) {
        return performPut(Endpoint.PET, pet);
    }

    public Response deletePet(long petId) {
        return performDelete(Endpoint.PET, petId);
    }

    public int create(User user) {
        return performPost(Endpoint.USER, user).getStatusCode();
    }

    public Response loginUser(String username, String password) {
        return given().
                queryParam("username", username).
                queryParam("password", password).
                when().
                get(BASE_URL + Endpoint.USER_LOGIN.getPath());
    }

    public int createUsersWithList(List<User> userList) {
        return performPost(Endpoint.USER_CREATE_WITH_LIST, userList).getStatusCode();
    }

    public Response logoutUser() {
        return performGet(Endpoint.USER_LOGOUT);
    }

    private Response performPost(Endpoint endpoint, Object bodyPayload) {
        return given().
                contentType(ContentType.JSON).
                body(bodyPayload).
                when().
                post(BASE_URL + endpoint.getPath());
    }

    private Response performPut(Endpoint endpoint, Object bodyPayload) {
        return given().
                contentType(ContentType.JSON).
                body(bodyPayload).
                when().
                put(BASE_URL + endpoint.getPath());
    }

    private Response performDelete(Endpoint endpoint, long petId) {
        return given().
                pathParam("petId", petId).
                when().
                delete(BASE_URL + endpoint.getPath(), petId);
    }

    private Response performGet(Endpoint endpoint) {
        return given().when().get(BASE_URL + endpoint.getPath());
    }
}
