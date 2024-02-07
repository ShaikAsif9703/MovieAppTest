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
import pages.LoginPages;
import java.time.Duration;
public class LoginUisteps {
    WebDriver driver;
    LoginPages loginPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPages(driver);
    }
    @Given("I am on the movie login page")
    public void moviePage(){
        driver.get("https://qamoviesapp.ccbp.tech");

    }
    @When("I click on the login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @When("I entered the password input")
    public void passwordField(){
        loginPage.enterPassword("rahul@2021");
    }
    @When("I entered the username input")
    public void enterusername(){
        loginPage.enterUsername("rahul");
    }
    @When("I entered the username and password input")
    public void invalidCredentials(){
        loginPage.enterUsername("rahul");
        loginPage.enterPassword("rahul2021");
    }
    @When("I entered the inputs")
    public void validCredentials(){
        loginPage.enterUsername("rahul");
        loginPage.enterPassword("rahul@2021");
    }
    @And("I click on  login button")
    public void clickOnTheLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @Then("I want to check app logo")
    public void websiteLogo(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-website-logo")));
        WebElement logo = driver.findElement(By.className("login-website-logo"));
        Assert.assertTrue(logo.isDisplayed(),"Not Displayed");
    }
    @Then("I check the movie page heading")
    public void checkingHeadingText(){
        WebElement heading = driver.findElement(By.className("sign-in-heading"));
        String expectedHeading = heading.getText();
        Assert.assertEquals(expectedHeading,"Login","Login's doesn't match");
    }
    @Then("I check the username label")
    public void checkingUsernameLabel(){
        WebElement usernameLabel = driver.findElement(By.xpath("//label[text()='USERNAME']"));
        String expectedUsernameLabel = usernameLabel.getText();
        Assert.assertEquals(expectedUsernameLabel,"USERNAME","Username label doesn't match");
    }
    @Then("I check the password label")
    public void checkingPasswordLabel(){
        WebElement passwordLabel = driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        String expectedPasswordLabel = passwordLabel.getText();
        Assert.assertEquals(expectedPasswordLabel,"PASSWORD","Password label doesn't match");
    }
    @Then("Error message will be displayed")
    public void errorMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errorMessage = driver.findElement(By.className("error-message"));
        String text = errorMessage.getText();
        Assert.assertEquals(text,"*Username or password is invalid");
    }
    @Then("Error Message")
    public void errormessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement error = driver.findElement(By.className("error-message"));
        String errorText = error.getText();
        Assert.assertEquals(errorText,"*username and password didn't match");
    }
    @Then("return to home page")
    public void homePage(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl,"Url's do not match");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
