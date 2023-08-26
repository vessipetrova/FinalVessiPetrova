package page.object;

import org.openqa.selenium.WebDriver;
public abstract class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
public abstract boolean isUrlLoaded();
public abstract void navigateTo();
}