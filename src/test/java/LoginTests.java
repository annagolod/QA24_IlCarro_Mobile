import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @Test
    public void loginPositiveTest() {
        UserDTO user = UserDTO.builder()
                .email("tretam0810@gmail.com")
                .password("Carro54321#")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .isElementPresent_popUpMessageSuccess("Login success!"));

    }

    @Test
    public void loginNegativeTest_WrongEmail() {
        UserDTO user = UserDTO.builder()
                .email("tretam0810gmail.com")
                .password("Carro54321#")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                        .goToSearchScreen()
                        .clickBtnDots()
                        .clickBtnLogin()
                        .typeLoginForm(user)
                        .clickBtnYallaNegative()
                        .validateErrorMessage("Login or Password incorrect"));

    }

    @Test
    public void loginNegativeTest_WrongPassword() {
        UserDTO user = UserDTO.builder()
                .email("tretam0810@gmail.com")
                .password("arro54321")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaNegative()
                .validateErrorMessage("Login or Password incorrect"));
    }
}
