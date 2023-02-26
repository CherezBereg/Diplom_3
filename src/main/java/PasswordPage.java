import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private final WebDriver driver;
    private final By authPasswordPage = By.xpath(".//a[text()='Войти']");

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPasswordPage() {
        driver.get(URI.BASE + URI.PASSWORD);
    }

    public void clickAuthPasswordPage() {
        driver.findElement(authPasswordPage).click();
    }
}
