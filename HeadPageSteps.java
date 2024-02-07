package LoginPageStepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
public class HeadPageSteps {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
    }
    @Given("I am on Home")
    public void homePage(){
        WebElement usernameField = driver.findElement(By.id("usernameInput"));
        usernameField.sendKeys("rahul");
        WebElement passwordField = driver.findElement(By.id("passwordInput"));
        passwordField.sendKeys("rahul@2021");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
    }
    @Then("check logo")
    public void logo(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement logo = driver.findElement(By.className("website-logo"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Then("check nav elements")
    public void nav(){
        String total = "NotDisplayed";
        List<WebElement> navItems = driver.findElements(By.cssSelector("div[class='nav-content'] *"));
        if(navItems.size() > 0){
            total = "Displayed";
        } else {
            total = "NotDisplayed";
        }
    }
    @Then("getting navlinks")
    public void navlinks(){
        List<WebElement> navLink = driver.findElements(By.xpath("//ul[@class='nav-menu-list']/child::li/child::a"));
        for(int i = 0; i < navLink.size(); i++){
            WebElement a = navLink.get(i);
            Assert.assertTrue(a.isDisplayed());
        }
    }
    @Then("checking account")
    public void account(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        WebElement accountImage = driver.findElement(By.className("avatar-img"));
        accountImage.isDisplayed();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
