package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //@FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement btnDots;

    @FindBy(xpath = "//*[@resource-id ='com.telran.ilcarro:id/title' and @text = 'Registration']")
    MobileElement btnRegistration;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    MobileElement btnLogin;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='My Cars']")
    MobileElement btnMyCars;

    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    MobileElement popUpMessageSuccess;



    public SearchScreen clickBtnDots() {
        should(btnDots, 10);
        btnDots.click();
        return this;
    }

    public RegistrationScreen clickBtnRegistration() {
        btnRegistration.click();
        return new RegistrationScreen(driver);
    }

    public LoginScreen clickBtnLogin() {
        btnLogin.click();
        return new LoginScreen(driver);
    }

//    public boolean isElementPresent_popUpMessageRegSuccess(){
//        return isElementPresentWithWait(popUpMessageRegSuccess, 5);
//    }

    public boolean isElementPresent_popUpMessageSuccess(String text){
        return textInElementPresent(popUpMessageSuccess, text, 5);
    }

    public MyCarsScreen clickBtnMyCarPositive() {
        btnMyCars.click();
        return new MyCarsScreen(driver);
    }
}
