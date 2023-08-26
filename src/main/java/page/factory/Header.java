package page.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "loginLink")
    private WebElement loginLink;

    @FindBy(id = "homeButton")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@id=\"navbarColor01\"]/ul[2]/li/a/i")
    private WebElement logoutButton;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickLogin() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }
    public boolean isLogoutButtonDisplayed(){
        try{
            WebElement searchField = driver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
            return isLogoutButtonDisplayed();
        } catch (NoSuchElementException e){
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