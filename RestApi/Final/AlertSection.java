package Final;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AlertSection {
    private WebDriver driver;
    public AlertSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @Step("Read DATA from Alert")
    public void ShowAlertData(String firstName, String lastName,String couponName) {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Alert alert = driver.switchTo().alert();
        String actualAlertText=alert.getText();
        String expectedAlertText = firstName + " " + lastName+" "+couponName;
        alert.accept();
        Assert.assertEquals(actualAlertText, expectedAlertText);

    }



}
