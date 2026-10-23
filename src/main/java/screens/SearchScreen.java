package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    WebElement btnDots;

    @AndroidFindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    WebElement btnLogin;

    @AndroidFindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    WebElement btnRegistration;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegName']")
    WebElement intelName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    WebElement intelLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    WebElement intelEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    WebElement intelPassword;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    WebElement btnCheckBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.telran.ilcarro:id/regBtn']")
    WebElement btnYalla;

    public void clickBtnDots(){
        clickWait(btnDots);
    }
    public void clickBtnLogin(){

        clickWait(btnLogin);
    }
    public void clickBtnRegistration(){
        clickWait(btnRegistration);
    }


}
