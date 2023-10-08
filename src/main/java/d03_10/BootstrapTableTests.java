package d03_10;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {

    private String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx";
    WebDriverWait wait;
    WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        wait
                .withMessage("Page title isnt 'Table with Edit and Update Data - Bootsnipp.com' ")
                .until(ExpectedConditions.titleIs("Table with Edit and Update Data - Bootsnipp.com"));
    }


    @Test
    public void editRow() {
        String firstName = "Nada";
        String lastName = "Nikolic";
        String middleName = "Vojkan";


        driver.findElement(By.cssSelector("#d1>td>button.update"))
                .click();
        wait
                .withMessage("Edit dialogue didnt appear")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Update Data']")));

        driver.findElement(By.cssSelector("div.modal-body>#fn"))
                .clear();
        driver.findElement(By.cssSelector("div.modal-body>#fn"))
                .sendKeys(firstName);


        driver.findElement(By.cssSelector("div.modal-body>#fn"))
                .clear();

        driver.findElement(By.cssSelector("div.modal-body>#ln"))
                .sendKeys(lastName);


        driver.findElement(By.cssSelector("div.modal-body>#mn"))
                .clear();

        driver.findElement(By.cssSelector("div.modal-body>#mn"))
                .sendKeys(middleName);

        driver.findElement(By.cssSelector(".modal-footer>#up"))
                .click();

        wait
                .withMessage("Edit dialogue didnt dissapear")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Update Data']")));


        Assert.assertEquals(driver.findElement(By.cssSelector("td#f1"))
                .getText(), firstName, "Edited First Name did not appear");

        Assert.assertEquals(driver.findElement(By.cssSelector("td#l1"))
                .getText(), lastName, "Edited Last Name did not appear");


        Assert.assertEquals(driver.findElement(By.cssSelector("td#m1"))
                .getText(), middleName, "Edited Middle Name did not appear");


    }


    @Test
    public void deleteRow() throws InterruptedException {
        String firstName = "Nada";
        String lastName = "Nikolic";
        String middleName = "Vojkan";

        List<WebElement> rows = driver.findElements(By.cssSelector("table.table-hover>tbody>tr"));

        for (int i = 0; i < rows.size(); i++) {

            WebElement deleteBtn = rows.get(i).findElement(By.className("delete"));
            deleteBtn.click();

            wait
                    .withMessage("Delete dialogue didnt appear")
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Delete Data']")));
            driver.findElement(By.cssSelector("button#del"))
                    .click();

            wait
                    .withMessage("Row didnt dissapear")
                    .until(ExpectedConditions.invisibilityOf(rows.get(i)));

            Thread.sleep(2000);

        }


    }

    @Test
    public void takeSS() throws IOException {

        File f =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Files.copy(f,new File("screenshots/ssBoots.jpeg"));

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
