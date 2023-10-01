package Vezbanje.p26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Drugi {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(2000);


List<WebElement> firstRow = driver.findElements(By.cssSelector("div#lorem tbody> tr:nth-child(1)>td"));

        for (int i = 0; i <firstRow.size() ; i++) {

           String text=  firstRow.get(i).getText();

            System.out.print(text + " | Drugi");



        }
Thread.sleep(1000);

        System.out.println();
        System.out.println("***********Column data**************");
        for (int i = 1; i <=3; i++) {

          WebElement columnTD =  driver.findElement(By.cssSelector("div#lorem tbody>tr:nth-child("+i+")>td:nth-child(1)"));

          String text = columnTD.getText();
          System.out.println(text);

        }
Thread.sleep(5000);
driver.quit();
    }
}
