package org.example;

public enum Endpoint {
    PET("/pet/{petId}"),
    PET_UPLOAD_IMAGE("/pet/{petId}/uploadImage"),
    USER("/user"),
    USER_LOGIN("/user/login"),
    USER_LOGOUT("/user/logout"),
    USER_CREATE_WITH_LIST("/user/createWithList");

    private final String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    // This method will be useful for parameterized endpoints
    public String format(Object... args){
        return String.format(path, args);
    }
}
