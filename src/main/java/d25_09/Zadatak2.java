package d25_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> todos = new ArrayList<>();
        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");
        todos.add("Visit London");


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://example.cypress.io/todo");

        //********************* NECE :(
        // WebElement xButton = driver.findElement(By.cssSelector("button.destroy"));********************* NECE :(

        // actions.moveToElement(xButton);
        //  actions.click(xButton).perform();
        //  Thread.sleep(3000);



        //SAD OCE
        List <WebElement>exampleTodos = driver.findElements(By.cssSelector("ul.todo-list>li"));
        for (int i = 0; i < exampleTodos.size(); i++) {
            WebElement xButton = driver.findElement(By.cssSelector("button.destroy"));
            actions.moveToElement(exampleTodos.get(i)).perform();
            actions.click(xButton).perform();
            Thread.sleep(3000);

        }

        for (int i = 0; i < todos.size(); i++) {
            WebElement todoBox = driver.findElement(By.cssSelector(".new-todo"));
            todoBox.sendKeys(todos.get(i));
            todoBox.sendKeys(Keys.ENTER);

        }

        List<WebElement> addedTodos = driver.findElements(By.cssSelector(".toggle"));

        for (int i = 0; i < addedTodos.size() ; i++) {

            addedTodos.get(i).click();


        }
Thread.sleep(5000);
        driver.quit();


    }
}
