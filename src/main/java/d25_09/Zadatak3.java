package d25_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        WebElement addButton= driver.findElement(By.cssSelector("button.add-new"));
        for (int i = 0; i <=5 ; i++) {
            addButton.click();
            driver.findElement(By.name("name")).sendKeys("Nada");
            driver.findElement(By.name("department")).sendKeys("Management");
            driver.findElement(By.name("phone")).sendKeys("531239");
            driver.findElement(By.xpath("//a[@class = 'add'] [@style][last()]")).click(); //ne funkcionise dobro
            Thread.sleep(500);


        }
   driver.quit();

    }
}
