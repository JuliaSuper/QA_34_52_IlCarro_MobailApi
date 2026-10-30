package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/addCarBtn")
    WebElement btnAddNewCar;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Car was added!']")
    WebElement widgetAddCar;

    @AndroidFindBy(id = "android:id/button1")
    WebElement btnYes;

    @AndroidFindBy(id = "com.telran.ilcarro:id/myCarTitleTxt")
    List<WebElement> carNumberList;

    public boolean validateWidgetAddCar(String text){
        return isTextInElementPresent(widgetAddCar, text);
    }

    public void clickBtnAddNewCar(){
        clickWait(btnAddNewCar);
    }
    public void clickBtnYes(){
        clickWait(btnYes);
    }

    public void deleteCar(){
        pause(3000);
        swipe(width/10, height/40*9, width/10*9, height/40*9 );
    }

    public List<String> readCarNumberList(){
        List<String> list = new ArrayList<>();
        for (WebElement e: carNumberList){
            list.add(e.getText());
        }
        return list;
    }
}
