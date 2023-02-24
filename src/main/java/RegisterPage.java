import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final static String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameRegister = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailRegister = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordRegister = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInButtonRegister = By.xpath(".//a[text()='Войти']");

    public void openRegisterPage() {
        driver.get(REGISTER_URL);
    }

    public void inputName(String text) {
        driver.findElement(nameRegister).sendKeys(text);
    }

    public void inputEmail(String text) {
        driver.findElement(emailRegister).sendKeys(text);
    }

    public void inputPassword(String text) {
        driver.findElement(passwordRegister).sendKeys(text);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public void clickSignInButtonRegister() {
        driver.findElement(signInButtonRegister).click();
    }

    public void register(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickRegisterButton();
    }
}
