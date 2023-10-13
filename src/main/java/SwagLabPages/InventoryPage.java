package SwagLabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasicPage {
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

    public WebElement getFirstAddToCartBtn() {

        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

public void clickOnFirstAddToCartBtn(){

        getFirstAddToCartBtn().click();
}

public WebElement getFirstRemoveBtn(){

        return driver.findElement(By.id("remove-sauce-labs-backpack"));
}

}
