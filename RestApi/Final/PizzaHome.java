package Final;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)

public class PizzaHome {

    String ExpectedPrice = "$7.50";
    String ExpectedNewPrice = "$10.50";
    String ExpectedCouponNum = "088-234";
    String ActualCouponNum;
    String ActualNewPrice;
    String ActualPrice;
    String actualFirstName;
    String actualLastName;
    String myFirstName = "alon";
    String myLastName = "balon";

    WebDriver driver;


    FormPage form;
    CouponSection coupon;
    AlertSection alert;


    

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/pizza/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        form = PageFactory.initElements(driver, FormPage.class);
        coupon=PageFactory.initElements(driver, CouponSection.class);
        alert=PageFactory.initElements(driver, AlertSection.class);


    }

    @Test(description = "Home Page price")
    @Description("verify Default Price")
    public void test01verifyPrice() {
        ActualPrice = form.getPrice();
        Assert.assertEquals(ActualPrice, ExpectedPrice);
    }

    @Test(description = "Personal Fields")
    @Description("Fill Personal Details ")
    public void test02FillFields() {
        form.FillDetails(myFirstName, myLastName);

         actualFirstName = form.getFirstNameValue();
         actualLastName = form.getLastNameValue();

        Assert.assertEquals(actualFirstName, myFirstName);
        Assert.assertEquals(actualLastName, myLastName);

    }

    @Test(description = "Delivery Pick")
    @Description("verify New Price")
    public void test03choosePick() {
        form.selectDeliveryOption();
        ActualNewPrice = form.getPrice();
        Assert.assertEquals(ActualNewPrice, ExpectedNewPrice);

    }

    @Test(description = "insert Coupon")
    @Description("Insert The Coupon To The Box")
    public void test04insertCoupon() {
        ActualCouponNum=coupon.getCouponNumber();
        coupon.insertCouponNumberIntoComment();
        Assert.assertEquals(ActualCouponNum,ExpectedCouponNum);

    }

    @Test(description = "Submit Order")
    @Description(" Submit the Order")
    public void test05SubmitOrder() {
        form.clickSubmitOrder();

    }

    @Test(description = "Alert")
    @Description("verify Alert Details")
    public void test06VerifyAlert() {
        alert.ShowAlertData(myFirstName,myLastName,ActualCouponNum);

    }


        @AfterClass
    public  void  endSession(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();

    }
}