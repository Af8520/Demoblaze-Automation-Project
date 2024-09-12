package Leasson09;

import Final.Listener;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)

public class AtidTests {

    LoginPage login;
    FormPage form;
    ClickPage click;
    WebDriver driver;
    String myUserName="selenium";
    String myPassword="webdriver";
    String myOccupation="QA";
    String myAge="27";
    String myLoaction="REHOVOT";

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/webdriveradvance.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login= PageFactory.initElements(driver,LoginPage.class);
        form=PageFactory.initElements(driver,FormPage.class);
        click=PageFactory.initElements(driver,ClickPage.class);

    }

    @Test(description = "testPages")
    @Description("verifyPages")
    public void test01(){
        login.signIn(myUserName,myPassword);
        form.fillForm(myOccupation,myAge,myLoaction);
        click.isDisplayed();
    }
    @AfterClass
    public  void  endSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }
//    @Step("Update Text Field")
//    public void update(WebElement elem, String value)
//    {
//        elem.sendKeys(value);
//    }
//
//    @Step("Click on Element")
//    public void click(WebElement elem)
//    {
//        elem.click();
//    }
//
//    @Step("Get Text from input Element")
//    public String getAttribute(WebElement elem)
//    {
//        return elem.getAttribute("value");
//    }
//
//    @Step("Verify Results")
//    public void verityEquals(String actual, String expected)
//    {
//        assertEquals(actual, expected);
//    }
//
//    @Attachment(value = "Page Screen-Shot", type = "image/png")
//    public byte[] saveScreenshot()
//    {
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
}


