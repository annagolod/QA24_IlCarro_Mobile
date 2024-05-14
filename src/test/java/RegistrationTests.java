import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig{

    @Test
    public void registrationPositiveTest(){
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
                .isElementPresent_popUpMessageRegSuccess());
    }
}
