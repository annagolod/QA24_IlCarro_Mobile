import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name("Nina")
                .lastName("Ricci" + i)
                .email("ricci" + i + "@gmail.com")
                .password("Ricci654321$")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaPositive()
                .isElementPresent_popUpMessageSuccess("Registration success!"));
    }

    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name("Nina")
                .lastName("Ricci" + i)
                .email("ricci" + i + "gmail.com")
                .password("Ricci654321$")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaNegative()
                .validateErrorMessage("username=must be a well-formed email address"));
    }
    @Test
    public void registrationNegativeTest_WithoutCheckBox() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name("Nina")
                .lastName("Ricci" + i)
                .email("ricci" + i + "@gmail.com")
                .password("Ricci654321$")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickBtnYallaNegative()
                .validateErrorMessage("All fields must be filled and agree terms"));
    }

//    @AfterMethod
//    public void afterTest() {
//        new ErrorScreen(driver).clickBtnOkRegScreen();
//    }

}
