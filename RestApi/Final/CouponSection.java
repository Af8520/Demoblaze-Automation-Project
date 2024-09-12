package Final;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CouponSection {
    @FindBy(xpath = "//*[@id=\"coupon_Number\"]")
    private WebElement couponNumberElement;

    @FindBy(xpath = "//iframe[@src='coupon.html']")
    private WebElement couponFrame;

    @FindBy(id = "input_5_20")
    private WebElement commentTextArea;

    private WebDriver driver;
    public CouponSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get the coupon number")
    public String getCouponNumber() {
        driver.switchTo().frame(couponFrame);
        String couponNumber = couponNumberElement.getText();
        driver.switchTo().defaultContent();
        return couponNumber;

    }
    @Step("Insert the Coupon number into comment box")
    public void insertCouponNumberIntoComment() {
        String couponNumber = getCouponNumber();
        commentTextArea.sendKeys(couponNumber);
    }

}
