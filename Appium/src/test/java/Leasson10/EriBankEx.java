package Leasson10;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class EriBankEx {
    protected AppiumDriver driver=null;
    DesiredCapabilities dc=new DesiredCapabilities();
    String userName="company";
    String password="company";

    @BeforeClass
    public void startSession() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "R58R50HSZ2B");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test01(){
        signIn(userName,password);
        Assert.assertFalse(driver.findElement(By.id("logoutButton")).isDisplayed());

    }

    @AfterClass
    public void closeSession(){
        driver.quit();
    }
    @Step("sign in action")
    public void signIn(String user,String pass){
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys(user);
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys(pass);
        driver.findElement(By.id("loginButton")).click();

    }
}
