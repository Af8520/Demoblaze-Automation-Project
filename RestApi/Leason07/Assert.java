package Leason07;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assert {
    WebDriver driver;
    String myHeight="182";
    String myWeight="78";
    String exBmi="50";

    String actualBmi;



    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void endSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }
    @Test
    public void tet01(){
        driver.findElement(By.id("weight")).sendKeys(myWeight);
        driver.findElement(By.name("height")).sendKeys(myHeight);
        driver.findElement(By.id("calculate_data")).click();
        actualBmi=driver.findElement(By.id("bmi_result")).getAttribute("value");
        org.testng.Assert.assertEquals(actualBmi,exBmi);




    }

}
