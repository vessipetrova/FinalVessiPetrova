package pageObject;

import org.openqa.selenium.WebDriver;
public abstract class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Add any common methods or utilities used across the pages
}