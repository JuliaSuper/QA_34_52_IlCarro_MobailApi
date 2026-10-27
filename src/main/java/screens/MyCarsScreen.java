package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/addCarBtn")
    WebElement btnAddNewCar;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Car was added!']")
    WebElement widgetAddCar;

    public boolean validateWidgetAddCar(String text){
        return isTextInElementPresent(widgetAddCar, text);
    }

    public void clickBtnAddNewCar(){
        clickWait(btnAddNewCar);
    }

}
