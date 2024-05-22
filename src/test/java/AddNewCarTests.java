import api.CarController;
import dto.CarDto;
import dto.CarsDto;
import dto.UserDTO;
import dto.enumclass.Fuel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {

    @Test
    public void addNewCarPositiveTest() {

        UserDTO user = UserDTO.builder()
                .email("tretam0810@gmail.com")
                .password("Carro54321#")
                .build();

        int i = new Random().nextInt(1000) + 1000;
        CarDto car = CarDto.builder()
                .serialNumber("333-" + i)
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();

        new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .clickBtnDots()
                .clickBtnMyCarPositive();
        //.clickBtnAddNewCar()
        //.typeAddNewCarForm(car);

        CarController carController = new CarController();
        carController.getTokenCarController();
        CarsDto carsDto = carController.bodyGetAllUserCarResponse();
        for (CarDto car1 : carsDto.getCars()) {
            if (car.equals(car1)) {
                System.out.println("equals !!! " + car1.toString());
            } else {
                System.out.println("not equals !!!");
            }
        }

    }
}
