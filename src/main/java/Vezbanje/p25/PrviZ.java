package Vezbanje.p25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://cms.demo.katalon.com/");

        Thread.sleep(2000);
        driver.findElement(By.name("s")).sendKeys("Flying ninja");
        driver.findElement(By.cssSelector("button.search-submit")).click();
        Thread.sleep(5000);
        driver.quit();













    }
}
