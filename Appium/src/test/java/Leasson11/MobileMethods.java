package Leasson11;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MobileMethods {


    protected AppiumDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeClass
    public void startSession() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "R58R50HSZ2B");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test01() {
        int count = driver.findElementsById("text1").size();
        assertTrue(count == 11);


    }


    @Test
    public void test02() {
        String source = driver.getPageSource();
        String words[] = source.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.contains("ListView")) {
                count++;
            }

        }
        Assert.assertEquals(count, 4);
    }

//    @Test
//    public void test02() {
//        String name=driver.getPageSource();
//        int count=name.split("ListView").length-1;
//        System.out.println(count);
//        assertTrue(count == 4);
//}



    @Test
    public void test03verify(){
        WebElement contentElement = driver.findElement(By.xpath("//*[@contentDescription='Content']"));
        System.out.println("Element Width: " + contentElement.getRect().getWidth());
        System.out.println("Element Height: " + contentElement.getRect().getHeight());
        System.out.println("Element X Coordinate: " + contentElement.getRect().getX());
        System.out.println("Element Y Coordinate: " + contentElement.getRect().getY());


    }
//    @Test
//    public void test03() {
//          driver.findElement(By.xpath("//*[@text='Content']").getRect();
//    }

    @Test
    public void test04verify(){

    }


    @AfterClass
    public void closeSession() {
        driver.quit();
    }

}


