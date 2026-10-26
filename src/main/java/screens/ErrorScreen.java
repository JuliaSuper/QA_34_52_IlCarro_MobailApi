package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ErrorScreen extends BaseScreen{
    public ErrorScreen(AppiumDriver driver) {
        super(driver);
    }

@AndroidFindBy(xpath = "//*[@resource-id='android:id/message']")
    WebElement errorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    WebElement errorPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    WebElement errorEmail;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
//    WebElement

    public boolean validateErrorMessage(String text){
        return isTextInElementPresent(errorMessage, text);
    }

    public boolean validateErrorPassword(String text){
        return isTextInElementPresent(errorPassword, text);
    }

    public boolean validateErrorEmail(String text){
        return isTextInElementPresent(errorEmail, text);
    }

}
