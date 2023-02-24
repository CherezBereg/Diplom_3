import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ConstructorTests {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void selectBuns() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickBunButton();
        assertEquals("Булки", mainPage.getActualSection());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void selectSauces() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        assertEquals("Соусы", mainPage.getActualSection());
    }

    @Test
    @DisplayName("Переход к разделу начинки")
    public void selectFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingButton();
        assertEquals("Начинки", mainPage.getActualSection());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
