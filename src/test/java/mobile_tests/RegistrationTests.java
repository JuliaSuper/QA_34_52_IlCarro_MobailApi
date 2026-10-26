package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import utils.UserFactory;

public class RegistrationTests extends TestBase {
    SearchScreen searchScreen;
    RegistrationScreen registrationScreen;
    User user;

    @BeforeMethod
    public void goToRegistrationScreen() {
        new SplashScreen(driver).goToSearchScreen();
        searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        registrationScreen = new RegistrationScreen(driver);
        user = UserFactory.positiveUser();
    }

    @Test
    public void registrationPositiveTest() {
        registrationScreen.typeFormRegistration(user);
        registrationScreen.clickBtnCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(searchScreen.
                validatePopUpRegistrationSuccess("Registration success!"));

    }

    @Test
    public void registrationEmptyFieldNegativeTest() {
         user.setFirstName("");
        registrationScreen.typeFormRegistration(user);
        registrationScreen.clickBtnCheckBox();
        registrationScreen.clickBtnYalla();
       Assert.assertTrue(new ErrorScreen(driver).
               validateErrorMessage("All fields must be filled and agree terms"));
    }

    @Test
    public void registrationShortPasswordNegativeTest() {
        user.setPassword("InWal2!");
        registrationScreen.typeFormRegistration(user);
        registrationScreen.clickBtnCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver).
                validateErrorPassword("{password= At least 8 characters; " +
                        "Must contain at least 1 uppercase letter, 1 lowercase letter," +
                        " and 1 number; " +
                        "Can contain special characters [@$#^&*!]}"));
    }

    @Test
    public void registrationInvalidEmailNegativeTest() {
        user.setUsername("georgiy2023gmail.com");
        registrationScreen.typeFormRegistration(user);
        registrationScreen.clickBtnCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver).
                validateErrorEmail("{username=must be a well-formed email address}"));
    }
}
