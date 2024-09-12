package Leaosn06;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverExample {
    WebDriver driver;
    String expectedUrl ="https://www.imdb.com";
    String expectedTitle="IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";


    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.imdb.com");
        driver.manage().window().maximize();


    }
    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void test02VerifyUrl() {
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test-Passed!");
        }else {
            System.out.println("Test-Failed!");
            System.out.println("Actual URL:"+ actualUrl);
        }

//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().to("https://www.google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());


    }
    @Test
    public void test02VerifyTitle(){
        driver.navigate().refresh();
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test-Passed!");
        }else {
            System.out.println("Test-Failed!");

        }
        System.out.println("Actual Title:"+actualTitle);


    }

}
