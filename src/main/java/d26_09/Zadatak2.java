package d26_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

       List<WebElement>alerts =  driver.findElements(By.cssSelector("div.col-md-12>div"));
        for (int i = 0; i < alerts.size(); i++) {

          WebElement xbutton =  alerts.get(i).findElement(By.className("close"));
          xbutton.click();
          Thread.sleep(2000);
         if (alerts.get(i).isDisplayed())  {
             System.out.println(" ALERT nije OBRISAN");
         } else {
             System.out.println("ALERT JE OBRISAN");
         }



        }


driver.quit();







    }
}
