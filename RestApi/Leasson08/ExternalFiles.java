package Leasson08;

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

public class ExternalFiles {
    WebDriver driver;
    String myHeight="182";
    String myWeight="78";
    String exBmi="299";



    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testVerifyLogin() {
        driver.findElement(By.name("weight")).sendKeys(myHeight);
        driver.findElement(By.id("hight")).sendKeys(myWeight);
        driver.findElement(By.id("calculate_data")).click();
        String actualBmi = driver.findElement(By.id("bmi_result")).getAttribute("value");
        Assert.assertEquals(actualBmi,exBmi);

    }

    @AfterClass
    public void endSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }
}