package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCarScreen extends BaseScreen{
    public AddNewCarScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

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
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn'] ")
    MobileElement btnAddNewCarSubmitForm;

    public AddNewCarScreen typeAddNewCarForm(CarDto car) {
        fieldSerialNumber.sendKeys(car.getSerialNumber());
        fieldManufacture.sendKeys(car.getManufacture());
        fieldModel.sendKeys(car.getModel());
        fieldCity.sendKeys(car.getCity());
        String price = Double.toString(car.getPricePerDay());
        fieldPrice.sendKeys(price);
        fieldCarClass.sendKeys(car.getCarClass());
        fieldCarYear.sendKeys(car.getYear());
        fieldSeats.sendKeys(Integer.toString(car.getSeats()));


        return this;
    }


}
