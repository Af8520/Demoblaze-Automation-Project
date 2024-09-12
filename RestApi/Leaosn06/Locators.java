package Leaosn06;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Locators {

    WebDriver driver;
//    String expectedUrl ="https://www.selenium.dev/";
//    String expectedTitle="IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";


    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");
        driver.manage().window().maximize();


    }
    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void test01VerifyLogo(){
//        WebElement way1=driver.findElement(By.tagName("svg"));
//        WebElement way3=driver.findElement(By.className("navbar-logo"));
        WebElement logo1=driver.findElement(By.id("locator_id"));
        System.out.println(logo1);
        WebElement logo2=driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/span"));
        System.out.println(logo2);
        WebElement logo3=driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/p"));
        System.out.println(logo3);
        WebElement logo4=driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/div[3]"));
        System.out.println(logo4);
        WebElement logo5=driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/a[1]"));
        System.out.println(logo5);







        }

//        @Test
//    public void test01verifyLinks(){
////            List<WebElement> links;
////            links = driver.findElement(By.tagName("a"));
////            System.out.println("Total Links: "+ links.size());
//
//        }

}
