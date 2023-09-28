package d25_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://artplayer.org/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(" i.art-icon.art-icon-play.hint--rounded.hint--top > svg > path")).click();

driver.findElement(By.cssSelector("i.art-icon.art-icon-volume > svg > path:nth-child(1)")).click();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.art-icon.art-icon-screenshot>svg>path")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.art-icon-pip")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("i.art-icon-pip")).click();
                                     // i.art-icon.art-icon-fullscreenWebOn > svg > path// zasto nece??
  driver.findElement(By.cssSelector(" i.art-icon.art-icon-fullscreenWebOn ")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("i.art-icon.art-icon-fullscreenWebOff")).click();
        Thread.sleep(5000);
        driver.quit();


    }
}
