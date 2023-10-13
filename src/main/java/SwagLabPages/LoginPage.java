package SwagLabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }


    public void clearNInsertUsername(String username) {

        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }


    public void clearNInsertPassword(String password) {

        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }


    public WebElement getLoginButton(){

        return driver.findElement(By.id("login-button"));
    }


    public void clickOnLoginButton(){

        getLoginButton().click();
    }


public WebElement getErrorMsg(){

    return driver.findElement(By.cssSelector("[data-test='error']"));
}



}



