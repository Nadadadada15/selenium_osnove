package d26_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Scanner s = new Scanner(System.in);

        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/automation-practice-form");


        Thread.sleep(1000);

        System.out.print("Unesite ime: ");
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(s.next());

        System.out.print("Unesite prezime: ");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(s.next());

        System.out.print("Unesite imejl: ");
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(s.next());

        System.out.print("Unesite pol: ");
        String gender =s.next();

        if (gender.equals("male"))
        {driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();}
        else if (gender.equals("female")){driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();}
        else {driver.findElement(By.cssSelector("label[for='gender-radio-3']")).click();}


        System.out.print("Unesite broj telefona: ");
        driver.findElement(By.id("userNumber")).clear();
        driver.findElement(By.id("userNumber")).sendKeys(s.next());

       // System.out.println("Unesite datum rodjenja");
       // driver.findElement(By.id("dateOfBirthInput")).clear();
       // driver.findElement(By.id("dateOfBirthInput")).sendKeys(s.next());

        System.out.println("Unesite predmet (za zavrsetak unosa kucajte 'kraj'):  ");

        boolean end = false;

        while(!end) {
            System.out.println("Unesite predmet: ");
            String subject = s.next();
            if (!subject.equals("kraj")){
                driver.findElement(By.id("subjectsInput")).sendKeys(subject);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            } else { end = true;}
        }

////label[@for='hobbies-checkbox-1']


        System.out.println("Unesite hobi: ");
        String hobby = s.next();

        if (hobby.equals("Sport")) {

            driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

        }else if (hobby.equals("Reading")) {driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();}
        else {driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();}


        System.out.print("Unesite trenutnu adresu: ");
        driver.findElement(By.id("#currentAddress")).sendKeys(s.next());







    }



}
