package d25_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

       driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("Admin"); // ne razumem zastp ne nalazi element

        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("admin123");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Me");
        driver.findElement(By.cssSelector("ul.oxd-main-menu> li:nth-child(1)>a")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(5000);
        driver.quit();



    }
}
s