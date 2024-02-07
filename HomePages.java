package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
public class HomePages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");


    public HomePages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnApplication(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void playButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
        WebElement a = driver.findElement(By.className("home-movie-play-button"));
        Assert.assertTrue(a.isDisplayed());
        return;
    }
    public void foot(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("contact-us-paragraph")));
        WebElement contact = driver.findElement(By.className("contact-us-paragraph"));
        Assert.assertTrue(contact.isDisplayed());
        return;
    }

}
