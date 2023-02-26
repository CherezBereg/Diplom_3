import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileTests {
    WebDriver driver;
    private final String email = "free054@gmail.com";
    private final String password = "493043";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
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
        Assert.assertTrue(profilePage.availableProfileButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void profileToConstructorTest() {
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
        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.availableOrderButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void profileToConstructorLogoTest() {
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
        profilePage.clickLogoButton();
        Assert.assertTrue(mainPage.availableOrderButton());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
