package api;

import okhttp3.MediaType;

public interface BaseApi {

    String BASE_URL = "https://ilcarro-backend.herokuapp.com";
    String LOGIN_URL = "/v1/user/login/usernamepassword";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    String ADDNEWCAR_URL = "/v1/cars";
    String GET_ALL_USER_CARS_URL = "/v1/cars/my";
    String DELETE_CAR_URL = "/v1/cars/";
    MediaType JSON = MediaType.get("application/json");
    String EMAIL = "tretam0810@gmail.com";
    String PASSWORD = "Carro54321#";
}
