package d22_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> urls = new ArrayList<>();

        urls.add("https://www.google.com/");
        urls.add("https://www.facebook.com/");
        urls.add("https://www.youtube.com/");
        urls.add("https://www.ebay.com/");
        urls.add("https://www.katalon.com/");


        for (int i = 0; i < urls.size(); i++) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get(urls.get(i));
            Thread.sleep(1000);
            driver.quit();

        }


    }
}
