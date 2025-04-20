package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class SearchSteps {
    WebDriver driver;

    @Given("user on the homepage")
    public void userOnTheHomepage() {
        driver = new ChromeDriver();
        driver.get("https://www.urbanladder.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @And("user click on search box and search a product")
    public void userClickOnSearchBoxAndSearchAProduct() {
        WebElement search_box = driver.findElement(By.id("search"));
        search_box.sendKeys("Sofa");
        search_box.sendKeys(Keys.ENTER);
    }

    @Then("user get data as per search")
    public void userGetDataAsPerSearch(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-gaaction=\"popup.auth.close\"]")));
        if(element.isDisplayed()){
            element.click();
        }
        List<WebElement> prod = driver.findElements(By.xpath("(//*[@class=\"row\"])[2]"));
        for(WebElement product:prod){
            String text = product.getText();
            if(text.contains("Sofa")){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
        }
    }

    @Then("user filter data as per choice")
    public void userFilterDataAsPerChoice() {
        WebElement list = driver.findElement(By.xpath("(//*[@class=\"gname\"])[1]"));
        Actions act = new Actions(driver);
        act.moveToElement(list).perform();
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"option \"]"));
        for(WebElement prod_list:list1){
            String text = prod_list.getText();
            if(text.equals("Fabric Sofa Sets")){
                prod_list.click();
            }
        }
        boolean view = driver.findElement(By.xpath("(//*[@class=\"row\"])[2]")).isDisplayed();
        Assert.assertTrue(view);
    }

    @Then("user successfully search the product")
    public void userSuccessfullySearchTheProduct() {
        driver.quit();
    }
}
