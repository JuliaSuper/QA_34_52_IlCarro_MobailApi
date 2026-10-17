package utils;

public interface BaseApi {
    String BASE_URL = "https://ilcarro-backend.herokuapp.com";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    String LOGIN_URL = "/v1/user/login/usernamepassword";
    String ADD_CAR_URL = "/v1/cars";
    String BOOKING_CAR_URL = "/v1/cars/{serialNumber}/booking";
    String SEARCH_CAR_URL = "/v1/cars/search";
    String GET_CAR_URL = "/v1/cars/my";
    String DELETE_CAR_URL = "/v1/cars/";

    String AUTH = "Authorization";
}
