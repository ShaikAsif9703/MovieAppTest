package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
public class AccountPages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By logoutButtonLocator = By.className("logout-button");
    public AccountPages(WebDriver driver){
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
    public void avatarButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));
        WebElement avatar = driver.findElement(By.className("avatar-button"));
        avatar.click();
        return;
    }
    public void lookEle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='account-information-container']")));
        WebElement accountEle = driver.findElement(By.xpath("//p[text()='Member ship']"));
        Assert.assertTrue(accountEle.isDisplayed());
        return;
    }
    public void logout(){
        driver.findElement(logoutButtonLocator).click();
    }
}
