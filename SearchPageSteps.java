package LoginPageStepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.SearchPages;
import java.time.Duration;
public class SearchPageSteps {
    WebDriver driver;
    SearchPages searchDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        searchDriver = new SearchPages(driver);
    }
    @Given("Home page")
    public void homePage(){
        searchDriver.clickOnApplication("rahul","rahul@2021");
    }
    @When("I click on search logo")
    public void search(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='search-empty-button']")));
        WebElement searchLogo = driver.findElement(By.cssSelector("button[class='search-empty-button']"));
        searchLogo.click();
    }
    @And("I entered the movie name")
    public void enterMovieName(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys("Titanic");
        WebElement searchButton = driver.findElement(By.className("search-button"));
        searchButton.click();

    }
    @Then("movie list will be displayed")
    public void movieDisplay(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        WebElement movie = driver.findElement(By.className("movie-image"));
        Assert.assertTrue(movie.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
