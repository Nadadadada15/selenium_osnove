package Vezbanje.p26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Prvi {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://s.bootsnipp.com/iframe/oV91g");

      List<WebElement> pagination =
              driver.findElements(By.cssSelector("a.page_link"));

        for (int i = 0; i <pagination.size() ; i++) {

            pagination.get(i).click();
            Thread.sleep(1000);

        }
driver.quit();

    }
}
