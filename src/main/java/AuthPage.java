import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By titleText = By.xpath(".//h2[text()='Вход']");
    private final By emailAuth = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordAuth = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By signInInButtonAuth = By.xpath(".//button[text()='Войти']");
    private final By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By registerButtonAuthPage = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");

    public void openAuthPage() {
        driver.get(URI.BASE + URI.AUTH);
    }

    public String getTitleText() {
        return driver.findElement(titleText).getText();
    }

    public void inputEmail(String text) {
        driver.findElement(emailAuth).sendKeys(text);
    }

    public void inputPassword(String text) {
        driver.findElement(passwordAuth).sendKeys(text);
    }

    public void clickAuthButton() {
        driver.findElement(signInInButtonAuth).click();
    }

    public void auth(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickAuthButton();
    }

    public boolean availableForgotPassword() {
        return driver.findElement(forgotPasswordButton).isDisplayed();
    }
}
