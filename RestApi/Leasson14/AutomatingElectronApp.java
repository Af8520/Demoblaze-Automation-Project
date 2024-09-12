package Leasson14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomatingElectronApp {
    private WebDriver driver;
    private ChromeOptions opt;
    private DesiredCapabilities capabilities;
    final String electronDriverPath="C:\\Users\\אלון פיבן\\Desktop\\QA\\Automation\\ElectronDriver\\electrondriver.exe";
    final String electronApplication="C:\\Users\\אלון פיבן\\Desktop\\QA\\Automation\\ElectronApiDemos\\ElectronApiDemos.exe";

    @BeforeClass
    public void startSession() {
        System.setProperty("webdriver.chrome.driver", electronDriverPath);
        opt = new ChromeOptions();
        opt.setBinary(electronApplication);
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", opt);
        capabilities.setBrowserName("chrome");

    }

    @Test()
    public void test01() {
        driver.findElement(By.id("button-windows")).click();
        driver.findElement(By.id("button-crash-hang")).click();
        driver.findElement(By.id("button-menus")).click();
    }

    @AfterClass
    public void endSession() {
        driver.quit();
    }
}
