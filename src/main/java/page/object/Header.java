package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebDriverWait wait;

    public void clickLogin() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        wait.until(ExpectedConditions.urlContains(LoginPage.PAGE_URL));
    }
    public boolean isLogoutButtonDisplayed(){
        try{
            WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
            return logoutButton.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public void clickHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-home")));
        WebElement home = driver.findElement(By.id("nav-link-home"));
        home.click();
    }
    protected WebDriver getDriver() {
        return driver;
    }
}
