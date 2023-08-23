package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.BasePage;

import java.time.Duration;

public class HomePage extends BasePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/all";
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void navigateTo() {
        this.driver.get("http://training.skillo-bg.com:4300/posts/all");
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
    }
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("loginLink"));
        loginButton.click();
    }
}