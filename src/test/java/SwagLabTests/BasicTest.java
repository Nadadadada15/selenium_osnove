package SwagLabTests;

import SwagLabPages.HeaderPage;
import SwagLabPages.InventoryPage;
import SwagLabPages.LeftNavMenu;
import SwagLabPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DeleteDialoguePage;
import pages.TablePage;
import pages.UpdateDialoguePage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected HeaderPage headerPage;
    protected InventoryPage inventoryPage;
    protected LeftNavMenu leftNavMenu;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        headerPage = new HeaderPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        leftNavMenu = new LeftNavMenu(driver, wait);


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void beforeMethod() {
        String username = "standard_user";
        String password = "secret_sauce";
        String baseUrl = "https://www.saucedemo.com";

        driver.navigate().to(baseUrl);
        loginPage.clearNInsertUsername(username);
        loginPage.clearNInsertPassword(password);
        loginPage.clickOnLoginButton();


    }


    @AfterMethod
    public void afterMethod() {

        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}











