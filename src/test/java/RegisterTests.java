import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTests {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    // Регистрация с корректными данными
    @Test
    public void registerTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        AuthPage authPage = new AuthPage(driver);
        registerPage.inputName("Paul");
        registerPage.inputEmail("5433678@gmail.com");
        registerPage.inputPassword("999999");
        registerPage.clickRegisterButton();
        Assert.assertEquals("Вход", authPage.getTitleText());
    }

    // Попытка регистрации с паролем менее 6 символов
    @Test
    public void passwordErrorTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Jack", "testEmail@gmail.com", "12345");
        Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
