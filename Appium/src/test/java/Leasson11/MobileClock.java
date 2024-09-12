package Leasson11;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileClock {

    protected AndroidDriver<AndroidElement> driver = null;
    TouchAction action;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public void startSession() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "R58R50HSZ2B");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action=new TouchAction(driver);

    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    @AfterMethod
    public void reset(){
        driver.resetApp();
    }

    @Test
    public void test01VerifyClock(){
        //Navigate to Clock:
        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='Date Widgets']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='2. Inline']")).click();
        //Drag From 12 to 9
        AndroidElement startHours=driver.findElement(By.xpath("//*[@contentDescription='12']"));
        AndroidElement finishHours=driver.findElement(By.xpath("//*[@contentDescription='9']"));
        dragAndDrop(startHours,finishHours);
        //Drag From 15 to 45
        AndroidElement startMinutes=driver.findElement(By.xpath("//*[@contentDescription='15']"));
        AndroidElement finishMinutes=driver.findElement(By.xpath("//*[@contentDescription='45']"));
        dragAndDrop(startMinutes,finishMinutes);
        //Verify results
        String resultHours=driver.findElement(By.id("hours")).getText();
        String resultMinutes=driver.findElement(By.id("minutes")).getText();
        String actualTime=resultHours+":"+resultMinutes;
        Assert.assertEquals(actualTime,"09:45");

    }
    @Test
    public void test02VerifyLongPress(){
        //Navigate to Custom Adapter
        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='Expandable Lists']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='1. Custom Adapter']")).click();
        //Long Press
        longPress(driver.findElement(By.xpath("//*[@text='People Names']")),2);
        //Verifications
        Assert.assertEquals(driver.findElement(By.xpath("//*[@text='Sample action']")).getText(),"Sample action");//verify by text
        Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Sample action']")).isDisplayed());//Verify is displayed

    }







    public void dragAndDrop(MobileElement start, MobileElement finish) {
        action.press(new ElementOption()
                        .withElement(start))
                .moveTo(new ElementOption().withElement(finish))
                .release()
                .perform();
    }

    public void longPress(MobileElement elem, int duration) {
        action.longPress(new LongPressOptions()
                        .withElement(ElementOption.element(elem))
                        .withDuration(Duration.ofSeconds(duration)))
                .perform();
    }





}
