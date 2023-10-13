package SwagLabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasicPage {
    public HeaderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public String getCartItemNum() {
        WebElement cartContainer = driver.findElement(By.className("shopping_cart_badge"));
        return cartContainer.getText();
    }

public void  clickOnAddToCartBtn (){

   WebElement cartLink= driver.findElement(By.className("shopping_cart_link"));
   cartLink.click();
}


    public WebElement getHamMenu() {

        return driver.findElement(By.id("react-burger-menu-btn"));
    }


    public void clickOnHamMenu(){
        getHamMenu().click();

    }

}
