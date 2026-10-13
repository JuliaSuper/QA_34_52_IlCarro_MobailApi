package api_rest_tests;

import controllers.AuthenticationController;
import dto.ErrorMessageDtoString;
import dto.TokenDto;
import dto.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;
import utils.UserFactory;

import static io.restassured.RestAssured.given;
import  static utils.UserFactory.*;

public class RegistrationLoginTests extends AuthenticationController {
    @Test
    public void registrationPositiveTest(){
        User user = positiveUser();
        Assert.assertEquals(registrationLogin
                (user, REGISTRATION_URL).getStatusCode(), 200);
    }

    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .username(PropertiesReader.getProperty("base.properties", "email"))
                .password(PropertiesReader.getProperty("base.properties", "password"))
                .build();
        Response response = registrationLogin(user, LOGIN_URL);
//        System.out.println(response.getBody().asString());
//        TokenDto tokenDto = response.getBody().as(TokenDto.class);
//        System.out.println(tokenDto.getAccessToken());
        Assert.assertEquals(response.getStatusCode(),200);
    }

// HW_15
    // Невалидный email
    @Test
    public void registrationWithInvalidEmailNegativeTest() {
        User user = positiveUser();
        user.setUsername("juliyur-2023-gmail-com");
        Assert.assertEquals(registrationLogin
                (user, REGISTRATION_URL).getStatusCode(), 400);
    }

    // Пустой пароль
    @Test
    public void registrationWithEmptyPasswordNegativeTest() {
        User user = positiveUser();
        user.setPassword("");
        Assert.assertEquals(registrationLogin
                (user, REGISTRATION_URL).getStatusCode(), 400);
    }

    // Простой/короткий пароль
    @Test
    public void registrationWithWeakPasswordNegativeTest() {
        User user = positiveUser();
        user.setPassword("123");
        Assert.assertEquals(registrationLogin
                (user, REGISTRATION_URL).getStatusCode(), 400);
    }

    // Без обязательного поля email
    @Test
    public void registrationWithoutUsernameNegativeTest() {
        User user = positiveUser();
        user.setUsername(null);
        Assert.assertEquals(registrationLogin
                (user, REGISTRATION_URL).getStatusCode(), 400);
    }
    @Test
    public void registrationNegative_409_Test(){
        User user = positiveUser();
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL).getStatusCode(), 200);
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL).getStatusCode(), 409);
    } // ожидали 409 получили 400

    @Test
    public void loginWrongEmailNegativeTest(){
        User user = User.builder()
                .username("juliyur-2023-gmail-com")
                .password(PropertiesReader.getProperty("base.properties", "password"))
                .build();
        Response response = registrationLogin(user, LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(),401);
    }

    @Test
    public void loginPasswordNullNegativeTest(){
        User user = User.builder()
                .username(PropertiesReader.getProperty("base.properties", "email"))
                .password("")
                .build();
        Response response = registrationLogin(user, LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(),401);
    }
}
