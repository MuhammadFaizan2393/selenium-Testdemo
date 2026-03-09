package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import pages.SauceLabsHomePage;
import utils.WebDriverUtils;
import utils.BrokenLinks;

public class StepDefinitions {

    private WebDriver driver;
    private SauceLabsHomePage sauceLabsHomePage;

    public StepDefinitions() {
        // Initialize WebDriver and all page classes in the constructor
    }
    @Given("I launch the application in {string} browser")
    public void iLaunchTheApplicationInBrowser(String browser) {
        driver = WebDriverUtils.getDriver(browser);
        sauceLabsHomePage = new SauceLabsHomePage(driver);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        sauceLabsHomePage.navigateToHomePage(url);
    }

    @Then("I should find all brokenlink on this webpage")
    public void iShouldFindAllBrokenlinkOnThisWebpage() {
    }

    @Then("I verify the brokenlinks")
    public void iVerifyTheBrokenlinks() throws Exception {
        String webUrl = driver.getCurrentUrl();
        String directoryPath = "src/main/resources/BrokenLinkReport";
        String fileName = "BrokenLinksReport";
        BrokenLinks.findBrokenLinkOnUI(driver, webUrl, directoryPath, fileName);
    }

    @And("I closed the browser.")
    public void iClosedTheBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}