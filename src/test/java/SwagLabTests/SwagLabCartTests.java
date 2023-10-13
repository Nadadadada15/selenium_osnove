package SwagLabTests;

import SwagLabPages.InventoryPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabCartTests extends BasicTest {

    @Test
    public void verifyUserIsOnInventoryPage() {

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be on Inventory page");
    }


    @Test
    public void verifyCartPageURL() {

        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");

    }

    @Test
    public void verifyCartPageTitle() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        Assert.assertTrue(driver.getTitle().equals("Swag Labs"));

    }

    @Test
    public void verifyHeaderTitleOnCartPage() {

        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        headerPage.getHeaderTitle();
    }


    @Test
    public void verifyHamMenuExistsOnCartPage() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        headerPage.doesHamMenuExist();
    }

    @Test
    public void verifyHamMenuIsEnabled() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        headerPage.clickOnHamMenu();
        Assert.assertTrue(headerPage.isHamMenuEnabled(), "Hamburger menu should be enabled on Cart page");

    }

    @Test
    public void verifyCartBtnIsEnabled() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        Assert.assertTrue(headerPage.isShoppingCartBtnEnabled(), "Shopping Cart button should be enabled on Cart page");

    }

    @Test
    public void verifyHamMenuBtnIsWorking() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        headerPage.clickOnHamMenu();
        wait
                .withMessage("Left Navigation Page should be visible")
                .until(ExpectedConditions.visibilityOf(leftNavMenu.getLeftNavPage()));


    }


    @Test
    public void verifyIfCartHasCorrectItemNumber() {
        inventoryPage.clickOnFirstAddToCartBtn();
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        Assert.assertEquals(headerPage.getCartItemNum(), "1");

    }

    @Test
    public void verifySecondayHeaderTitle() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        Assert.assertEquals(headerPage.getSecondaryHeaderTitle(), "Your Cart", "The title should be 'Your Cart'");
    }


    @Test
    public void verifyLeftNavMenuOptions() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");

        Assert.assertEquals(leftNavMenu.getNumberOfMenuOptions(), 4, "There should be four menu options displayed");

    }

    @Test
    public void verifyCorrectSpellingOfNavMenuOptions() {
        headerPage.clickOnAddToCartBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart.html"), "User Should Be on Cart page");
        headerPage.clickOnHamMenu();
        wait
                .withMessage("Left Navigation Page should be visible")
                .until(ExpectedConditions.visibilityOf(leftNavMenu.getLeftNavPage()));
        Assert.assertTrue(leftNavMenu.checkSpellingOfAllMenuOptions(), "All options should be spelled correctly");

    }



    @Test
    public void verifyGetAllItemsOption(){
        headerPage.clickOnHamMenu();
        wait
                .withMessage("Left Navigation Page should be visible")
                .until(ExpectedConditions.visibilityOf(leftNavMenu.getLeftNavPage()));

        leftNavMenu.clickOnAllItemsOption();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be on Inventory page");
    }


    @Test
    public void verifyAboutOption(){
        headerPage.clickOnHamMenu();
        wait
                .withMessage("Left Navigation Page should be visible")
                .until(ExpectedConditions.visibilityOf(leftNavMenu.getLeftNavPage()));

        leftNavMenu.clickOnAboutOption();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://saucelabs.com/"), "User should be on saucelab promopage");
    }
    @Test
    public void verifylogoutOption(){
        headerPage.clickOnHamMenu();
        wait
                .withMessage("Left Navigation Page should be visible")
                .until(ExpectedConditions.visibilityOf(leftNavMenu.getLeftNavPage()));

        leftNavMenu.clickOnLogoutOption();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/"), "User should be loggin page");
    }


}
