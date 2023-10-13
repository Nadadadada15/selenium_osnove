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

    public WebElement getCartButton(){

        return driver.findElement(By.className("shopping_cart_link"));
    }

    public void clickOnAddToCartBtn() {

       getCartButton().click();
    }


    public WebElement getHamMenu() {

        return driver.findElement(By.id("react-burger-menu-btn"));
    }


    public void clickOnHamMenu() {
        getHamMenu().click();

    }


    public WebElement getHeader() {
        return driver.findElement(By.className("app_logo"));
    }

    public  String getHeaderTitle(){

        return getHeader().getText();
    }

    public boolean doesHamMenuExist(){

        return elementExists(By.id("react-burger-menu-btn"));
    }

    public boolean isHamMenuEnabled(){

        return getHamMenu().isEnabled();
    }

    public boolean isShoppingCartBtnEnabled(){

        return getCartButton().isEnabled();
    }
}
