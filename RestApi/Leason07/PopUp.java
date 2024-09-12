package Leason07;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PopUp {

        WebDriver driver;



        @BeforeClass
        public void startSession() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://atidcollege.co.il/Xamples/ex_switch_navigation.html");
            driver.manage().window().maximize();
        }

        @AfterClass
        public void endSession() {
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            driver.quit();

        }

        @Test
        public void tet01() {
            driver.findElement(By.id("btnAlert")).click();
            Alert popup=driver.switchTo().alert();
            popup.accept();
            String alertText=popup.getText();
            System.out.println(alertText);
            WebElement output = driver.findElement(By.id("output"));
            System.out.println("output is:"+ output);





        }
    }

