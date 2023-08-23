package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderRegisteredUser extends Header{
    public HeaderRegisteredUser(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebDriverWait wait;

    public void clickHome() {
        super.clickHome();
    }
    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        WebElement profile = getDriver().findElement(By.id("nav-link-profile"));
        profile.click();
    }
    public void clickLogoutButton() {
        WebElement logoutButton = getDriver().findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
        logoutButton.click();
    }
    public void clickNewPost() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement postLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-new-post")));
        postLink.click();
}
    public void clickCreatePost() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-create-post")));
        WebElement createPost = getDriver().findElement(By.id("nav-link-create-post"));
        createPost.click();
    }

}