package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class homepageSteps {
    WebDriver driver;

    @Given("User open the url")
    public void userOpenTheUrl() {
        driver = new ChromeDriver();
        driver.get("https://www.urbanladder.com/");
    }

    @And("user is on the homepage and see the elements")
    public void userIsOnTheHomepageAndSeeTheElements() {
        boolean view = driver.findElement(By.id("home")).isDisplayed();
        Assert.assertTrue(view,"homepage not loaded");
    }

    @Then("user successfully landed on homepage")
    public void userSuccessfullyLandedOnHomepage() {
        driver.quit();
    }
}
