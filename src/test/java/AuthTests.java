import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AuthTests {
    WebDriver driver;
    private final String email = "free054@gmail.com";
    private final String password = "493043";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Авторизация через кнопку 'войти в аккаунт' на главной странице")
    public void authMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);

        mainPage.openMainPage();
        mainPage.clickSignInButton();
        authPage.auth(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @Test
    @DisplayName("Авторизация через кнопку на странице регистрации")
    public void authRegisterPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.openRegisterPage();
        registerPage.clickSignInButtonRegister();
        authPage.auth(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @Test
    @DisplayName("Авторизация через кнопку `личный кабинет` на главной странице")
    public void authProfileButtonTest() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);

        mainPage.openMainPage();
        mainPage.clickProfileButton();
        authPage.auth(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @Test
    @DisplayName("Авторизация через кнопку на странице восстановления пароля")
    public void authRecoveryPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = new AuthPage(driver);
        PasswordPage passwordPage = new PasswordPage(driver);

        passwordPage.openPasswordPage();
        passwordPage.clickAuthPasswordPage();
        authPage.auth(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}

