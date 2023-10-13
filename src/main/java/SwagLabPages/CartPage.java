package SwagLabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasicPage {
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public boolean areAddedItemsVisibleOnCartPage() {
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_list>.cart_item"));
        return !cartItems.isEmpty();

    }


}
