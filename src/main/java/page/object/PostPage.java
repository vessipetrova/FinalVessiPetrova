package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class PostPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/create";
    private final WebDriver driver;

    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    private WebDriverWait wait;

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.urlContains(PAGE_URL));
    }
    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public void clickNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement postLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-new-post")));
        postLink.click();
    }
    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a")));
        logoutButton.click();
    }
    public void clickHomeButton() {
        WebElement homeButton = driver.findElement(By.id("homeButton"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")));
        homeButton.click();
    }
}