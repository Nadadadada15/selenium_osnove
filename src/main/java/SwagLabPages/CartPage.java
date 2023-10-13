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


    public boolean isItemDescriptionVisible(){

        List <WebElement> productDescription = driver.findElements(By.className("inventory_item_desc"));

        for (int i = 0; i < productDescription.size(); i++) {

            ArrayList<String>descText = new ArrayList<>();

            descText.add(productDescription.get(i).getText());

        }

        return !productDescription.isEmpty();

    }


   List <WebElement> quantityContainer = driver.findElements(By.className("cart_quantity"));

        public boolean isQtyContainerPresentForAllItems(){
            for (int i = 0; i < quantityContainer.size(); i++) {
            if(!elementExists(By.className("cart_quantity"))) { return false;}

            }
            return true;
        }




}
