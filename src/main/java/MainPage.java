import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final static String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signInButtonMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By profileButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By createOrderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");
    private final By bunButton = By.xpath(".//div[span[text()='Булки']]");
    private final By sauceButton = By.xpath(".//div[span[text()='Соусы']]");
    private final By fillingButton = By.xpath(".//*[text()='Начинки']");
    private final By orderList = By.xpath(".//*[text()='Лента Заказов']");
    private final By actualSection = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]//span");

    public void openMainPage() {
        driver.get(BASE_URL);
    }

    public void clickSignInButton() {
        driver.findElement(signInButtonMainPage).click();
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }

    public boolean availableOrderButton() {
        return driver.findElement(createOrderButton).isDisplayed();
    }

    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    public String getActualSection() {
        return driver.findElement(actualSection).getText();
    }

    public boolean orderListAvailable() {
        return driver.findElement(orderList).isDisplayed();
    }
}
