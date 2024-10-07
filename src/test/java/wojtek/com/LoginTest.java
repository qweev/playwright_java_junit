package wojtek.com;

import org.junit.jupiter.api.*;
import wojtek.com.pages.HomePage;
import wojtek.com.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseChromeTest {
    LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        openLoginPage();
        loginPage = new LoginPage();
    }

    @DisplayName("Can login")
    @Test
    public void canLogin(){
        String user = "System";
        String pass = "System@123456";

        loginPage.enterUserName(user)
                 .enterPassword(pass)
                 .clickSignIn();

        assertEquals(user, new HomePage().getLoggedUserName());
    }


}
