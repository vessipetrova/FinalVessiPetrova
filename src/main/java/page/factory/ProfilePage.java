package page.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/";
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(xpath = "logoutButton")
    private WebElement logoutButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));
    }
    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a")));
        logoutButton.click();
    }
}
