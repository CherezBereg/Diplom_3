import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OutProfileTests {
    WebDriver driver;
    private final String email = "free054@gmail.com";
    private final String password = "493043";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void profileTest() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        // Авторизация
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        authPage.auth(email, password);
        // Переход в личный кабинет
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        profilePage.clickLogOutButton();
        Assert.assertTrue(authPage.availableForgotPassword());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
