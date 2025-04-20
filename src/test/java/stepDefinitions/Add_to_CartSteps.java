package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Set;

public class Add_to_CartSteps {
    WebDriver driver;

    @Given("User is on Homepage")
    public void userIsOnHomepage() {
        driver = new ChromeDriver();
        driver.get("https://www.urbanladder.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @And("User click on a product")
    public void userClickOnAProduct() throws InterruptedException {
        driver.findElement(By.xpath("(//*[@class=\"category-icon\"])[2]")).click();
        driver.findElement(By.xpath("(//*[@class=\"img-link\"])[1]")).click();
        String id = driver.getWindowHandle();
        Set<String> all_id = driver.getWindowHandles();
        for(String str:all_id){
            if(!str.equals(id)){
                driver.switchTo().window(str);
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-gaaction=\"popup.auth.close\"]")));
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(3000);
    }

    @Then("user add to cart that product")
    public void userAddToCartThatProduct(){
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"product-img\"])[1]"))).click();
        driver.findElement(By.xpath("//button[@name=\"button\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        boolean view = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"line_items\"]")))
                .isDisplayed();
        Assert.assertTrue(view);
    }

    @Then("User click on the checkout")
    public void userClickOnTheCheckout() {
        driver.findElement(By.xpath("(//button[@id=\"checkout-link\"])[1]")).click();
        String Actual = driver.getCurrentUrl();
        String Expected = "https://www.urbanladder.com/checkout/address";
        Assert.assertEquals(Actual, Expected);
    }

    @And("User give details")
    public void userGiveDetails() throws InterruptedException {
        driver.findElement(By.id("order_email")).sendKeys("satya@gmail.com");
        driver.findElement(By.id("order_ship_address_attributes_zipcode")).sendKeys("752054");
        driver.findElement(By.id("order_ship_address_attributes_address1")).sendKeys("Khordha");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("Satya");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys(("Sahu"));
        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("8423641235");
        Thread.sleep(2000);
        driver.findElement(By.id("address-form-submit")).click();
    }

    @Then("User redirect to payment page")
    public void userRedirectToPaymentPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@type=\"submit\"])[1]")).click();
        driver.quit();
    }
}
