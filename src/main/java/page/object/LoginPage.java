package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public static String PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    private final WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void navigateTo() {
        this.driver.get("http://training.skillo-bg.com:4300/users/login");
        wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }
    public String getSignInElementText() {
        WebElement signInFormTitle = driver.findElement(By.className("h4"));
        wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
        return signInFormTitle.getText();
    }
    public void populatePassword(String password) {
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);
    }
    public void populateUsername(String username) {
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys(username);
    }
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
    public boolean isUrlLoaded() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }
    public boolean isLogoutButtonDisplayed() {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
        return logoutButton.isDisplayed();
    }
}