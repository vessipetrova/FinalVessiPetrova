package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/all";
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(HomePage.PAGE_URL));
    }

    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("loginLink"));
        loginButton.click();
    }
    public boolean isLogoutButtonDisplayed() {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
        return logoutButton.isDisplayed();
    }
}
