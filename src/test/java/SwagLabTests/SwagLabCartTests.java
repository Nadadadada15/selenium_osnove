package SwagLabTests;

import SwagLabPages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabCartTests extends BasicTest {

    @Test
    public void verifyUserIsOnInventoryPage() {

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be on Inventory page");
    }

    @Test
    public void addProductsToCart() {
        inventoryPage.clickOnFirstAddToCartBtn();

        Assert.assertEquals(headerPage.getCartItemNum(), "1");
    }


    @Test
    public void verifyCartPageURL() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");

    }


}
