package homework;
import Leasson08.AutomationListener;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListener.class)

public class ClassEX {
    WebDriver driver;




    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
        try {
            driver.findElement(By.id("btn")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("checkbox"));
            System.out.println("Test 01 Failed:Element is on screen");



        }catch (Exception e){
            System.out.println("Test 01 Passed:Element DOES NOT on screen");
        }
        
    }

    @AfterClass
    public void endSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }
}