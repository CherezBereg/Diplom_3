import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private final WebDriver driver;
    private final static String PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By authPasswordPage = By.xpath(".//a[text()='Войти']");

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPasswordPage() {
        driver.get(PASSWORD_URL);
    }

    public void clickAuthPasswordPage() {
        driver.findElement(authPasswordPage).click();
    }
}
