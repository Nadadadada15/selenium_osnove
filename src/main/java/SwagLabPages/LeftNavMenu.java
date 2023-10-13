package SwagLabPages;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LeftNavMenu extends BasicPage {


    public LeftNavMenu(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

    public WebElement getLeftNavPage() {

        return driver.findElement(By.className("bm-menu"));
    }

    public WebElement getLogoutBtn() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }


    public int getNumberOfMenuOptions() {
        List<WebElement> leftNavElements = driver.findElements(By.cssSelector(".bm-item-list>a"));
        int counter = 0;
        for (int i = 0; i < leftNavElements.size(); i++) {
            counter++;

        }
        return counter;
    }

    public boolean checkSpellingOfAllMenuOptions() {

        ArrayList<String> text = new ArrayList<>();
        text.add("All Items");
        text.add("About");
        text.add("Logout");
        text.add("Reset App State");
        List<WebElement> leftNavElements = driver.findElements(By.cssSelector(".bm-item-list>a"));
        int counter =0;
        for (int i = 0; i < text.size()-1; i++) {
           if(leftNavElements.get(i).getAccessibleName().equals(text.get(i)))  {counter++;}

        }
        return counter==4;
    }


    public WebElement getAllItemsOption(){
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public void clickOnAllItemsOption(){

        getAllItemsOption().click();
    }

    public WebElement getAboutOption(){
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public void clickOnAboutOption(){

        getAboutOption().click();
    }

    public WebElement getLogoutOption(){
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public void clickOnLogoutOption(){

        getLogoutOption().click();
    }

    public WebElement getResetOption(){
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    public void clickOnResetOption(){

        getResetOption().click();
    }


    public boolean doesExitNavPageButtonExist(){
        return  elementExists(By.id("react-burger-cross-btn"));
    }

    public WebElement getExitNavPageButton () {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }



}