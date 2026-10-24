package screens;

import dto.User;
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
    WebElement inputName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    WebElement inputLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    WebElement inputEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    WebElement inputPassword;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    WebElement btnCheckBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.telran.ilcarro:id/regBtn']")
    WebElement btnYalla;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/findTitle']")
    WebElement textCarNow;

    public void clickBtnDots(){
        clickWait(btnDots);
    }
    public void clickBtnLogin(){
        clickWait(btnLogin);
    }
    public void clickBtnRegistration(){
        clickWait(btnRegistration);
    }
    public void typeFormRegistration(User user){
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }
    public void clickBtnCheckBox(){
        clickWait(btnCheckBox);
    }
public void clickBtnYalla(){
        clickWait(btnYalla);
}
    public String isFindTitleText(){
        return textCarNow.getText();
    }
}
