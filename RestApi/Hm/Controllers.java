package Hm;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controllers {
    WebDriver driver;
    String myFirstName="Alon";
    String myLastName="Fiban";
    String sUrl;



    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void endSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }

    @Test
    public void test01(){
        driver.findElement(By.name("firstname")).sendKeys(myFirstName);
        driver.findElement(By.name("lastname")).sendKeys(myLastName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Select MyContinents=new Select(driver.findElement(By.id("continents")));
        MyContinents.selectByIndex(1);
        driver.findElement(By.id("submit")).click();
        sUrl=driver.getCurrentUrl();
        if (sUrl.contains(myFirstName)&& sUrl.contains(myLastName)){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed!");
        }
        System.out.println(sUrl);

    }
    @Test
    public void test02(){
        driver.findElement(By.id("datepicker")).click();
        WebElement dateWidget=driver.findElement(By.id("ui-datepicker-div"));
        List cells=dateWidget.findElements(By.tagName("td"));

    }
}
