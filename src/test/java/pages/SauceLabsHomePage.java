package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceLabsHomePage {

    private WebDriver driver;

    private By allLinks = By.tagName("a");

    public SauceLabsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAllLinks() {
        return driver.findElement(allLinks);
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }
}