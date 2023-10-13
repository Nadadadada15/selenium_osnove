package SwagLabPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasicPage {


    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }




    public boolean areAddedItemsVisibleOnCartPage() {
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_list>.cart_item"));
        return !cartItems.isEmpty();

    }

    public boolean areItemTitlesDisplayed(){
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_list>.cart_item"));

        for (int i = 0; i < cartItems.size(); i++) {
            List<String>cartTitle = new ArrayList<>();
            cartTitle.add(cartItems.get(i).getText());


        }
     return !cartItems.isEmpty();
    }


}
