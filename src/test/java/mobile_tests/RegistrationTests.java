package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;
import utils.PropertiesReader;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositiveTest(){
        new SplashScreen(driver).goToSearchScreen();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        User user = User.builder()
                .firstName("George")
                .lastName("Eruel")
                .username(PropertiesReader.getProperty("base.properties", "email1"))
                .password(PropertiesReader.getProperty("base.properties",
                        "passwordUser"))
                        .build();
        searchScreen.typeFormRegistration(user);
        searchScreen.clickBtnCheckBox();
        searchScreen.clickBtnYalla();
        Assert.assertEquals(searchScreen.isFindTitleText(),"Find your car now!");

    }
}
