import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    private final By profileButton = By.xpath(".//a[text()='Профиль']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    private final By logOutButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean availableProfileButton() {
        return driver.findElement(profileButton).isDisplayed();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogoButton() {
        driver.findElement(logo).click();
    }

    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }
}
