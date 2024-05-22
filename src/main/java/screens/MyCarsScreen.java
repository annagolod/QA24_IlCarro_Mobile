package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    MobileElement btnAddNewCar;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editSerial']")
    MobileElement fieldSerialNumber;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editMan']")
    MobileElement fieldManufacture;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editModel']")
    MobileElement fieldModel;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editCity']")
    MobileElement fieldCity;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editPrice']")
    MobileElement fieldPrice;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editCarClass']")
    MobileElement fieldCarClass;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editYear']")
    MobileElement fieldCarYear;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editSeats']")
    MobileElement fieldSeats;




    public AddNewCarScreen clickBtnAddNewCar(){
        btnAddNewCar.click();
        return new AddNewCarScreen(driver);
    }


}
