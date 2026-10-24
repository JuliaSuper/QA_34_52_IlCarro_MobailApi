package mobile_tests;

import dto.User;
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
                .firstName("Georgiy")
                .lastName("Savelev")
                .username(PropertiesReader.getProperty("base.properties", "emailTest"))
                .password(PropertiesReader.getProperty("base.properties","passwordRegistrationUser"))
                        .build();
        searchScreen.typeFormRegistration(user);
        searchScreen.clickBtnCheckBox();
        searchScreen.clickBtnYalla();

    }
}
