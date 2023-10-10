package p05_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class SwagLabTest {


    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @BeforeMethod                             //pre svake metode, stavljamo neki precondition
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/ ");

    }


    @Test
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error text did not appear")
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div.error")), "Epic sadface: Username is required"));

    }


    @Test

    public void VerifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "nada";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Error text did not appear")
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div.error")), "Epic sadface: Password is required"));


    }


    @Test
    public void VerifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Wrong credetials Error text did not appear")
                .until(ExpectedConditions.textToBePresentInElement
                        (driver.findElement(By.cssSelector("div.error")), "Epic sadface: Username and password do not match any user in this service"));

    }


    @Test
    public void VerifyErrorIsDisplayedWhenUserIsLocked() {

        String username = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Wrong credetials Error text did not appear")
                .until(ExpectedConditions.textToBePresentInElement
                        (driver.findElement(By.cssSelector("div.error")), "Epic sadface: Sorry, this user has been locked out."));


    }

    @Test
    public void verifySuccessfulLogin() {

        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();


        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/inventory.html"));


        driver.findElement(By.id("react-burger-menu-btn"))
                .click();


        wait
                .withMessage("Sidebar menu did not appear")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        driver.findElement(By.id("logout_sidebar_link"))
                .click();

        wait
                .withMessage("Login form did not appear")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));


    }

    @Test
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/inventory.html"));


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        WebElement removeBtn = driver.findElement(By.id("remove-sauce-labs-backpack"));

        Assert.assertTrue(removeBtn.isDisplayed());

        //wait
        // .withMessage("Product is not added to cart")
        //  .until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));


        WebElement products = driver.findElement(By.id("shopping_cart_container"));
        String productText = products.getText();

        Assert.assertEquals(productText, "1");
    }

    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void viewingProductDetails() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("item_4_title_link"))
                .click();


        WebElement title = driver.findElement(By.cssSelector(".inventory_details_name "));
        WebElement desc = driver.findElement(By.cssSelector(".inventory_details_desc  "));
        WebElement price = driver.findElement(By.cssSelector(".inventory_details_price  "));
        WebElement addBtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));


        Assert.assertTrue(title.isDisplayed());
        Assert.assertTrue(desc.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(addBtn.isDisplayed());


    }

    @Test

    public void removingProductsFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/inventory.html"));


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        driver.findElement(By.cssSelector(".shopping_cart_link"))
                .click();
        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/cart.html"));

        WebElement item = driver.findElement(By.className("inventory_item_name"));
        String itemTitle = item.getText();

        Assert.assertEquals(itemTitle, "Sauce Labs Backpack");

        driver.findElement(By.id("remove-sauce-labs-backpack"))
                .click();

        List<WebElement> items = driver.findElements(By.cssSelector("div.cart_list>.cart_item"));

        Assert.assertTrue(items.isEmpty());

    }

    @Test
    public void productCheckout() {
        String checkoutname = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/inventory.html"));


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        driver.findElement(By.cssSelector("a.shopping_cart_link"))
                .click();
        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/cart.html"));

        driver.findElement(By.id("checkout"))
                .click();

        wait
                .withMessage("Page did not redirect")
                .until(ExpectedConditions.urlContains("/checkout-step-one.html"));


        driver.findElement(By.id("first-name"))
                .sendKeys(checkoutname);

        driver.findElement(By.id("last-name"))
                .sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code"))
                .sendKeys(checkoutZip);

        driver.findElement(By.id("continue"))
                .click();

        WebElement price = driver.findElement(By.cssSelector(".inventory_item_price"));
        String priceAmount = price.getText();

        WebElement itemName = driver.findElement(By.cssSelector(".inventory_item_name"));
        String itemNameTitle = itemName.getText();

        Assert.assertEquals(priceAmount, "$29.99");
        Assert.assertEquals(itemNameTitle, "Sauce Labs Backpack");

        driver.findElement(By.id("finish"))
                .click();

        WebElement thankyou = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(thankyou.isDisplayed());


    }

    @AfterMethod
    public void afterMethod() {
//        KADA FAILTUJE PRAVI MI SCREENSHOT!

        driver.manage().deleteAllCookies(); // izloguje
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
