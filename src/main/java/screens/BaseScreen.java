package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public int[] getScreenSize() {// get screen size [0] height, [1] - width
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        return new int[]{height, width};
    }

    public void pause(int time){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean textInElementPresent(MobileElement element, String text, int time){
        try{
            return new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
        }catch(TimeoutException e){
            System.out.println("create exception");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementPresentWithWait(MobileElement element, int time){
        return !new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
    }

    public void should(MobileElement element, int time) {
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
