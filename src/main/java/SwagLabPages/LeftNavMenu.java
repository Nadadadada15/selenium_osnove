package SwagLabPages;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftNavMenu extends BasicPage {


    public LeftNavMenu(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

public WebElement getLeftNavPage (){

        return  driver.findElement(By.className("bm-menu"));
}

    public WebElement getLogoutBtn () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }




















}
