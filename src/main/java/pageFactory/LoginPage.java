package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginBtn")
    private WebElement loginButton;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(className = "sign-in-element")
    private WebElement signInElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void signIn(String username, String password) {
        populateUsername(username);
        populatePassword(password);
        clickSignIn();
    }
    public void clickSignIn() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();
    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
    }

    public String getSignInElementText() {
        WebElement signInFormTitle = driver.findElement(By.className("h4"));
        wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
        return signInFormTitle.getText();
    }
    private void populatePassword(String password) {
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);
    }
    private void populateUsername(String username) {
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys(username);
    }
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}