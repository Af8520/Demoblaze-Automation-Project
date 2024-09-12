package Leasson09;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickPage {
    @FindBy(css = "button[type='button']")
    private WebElement clickField;

    @Step("Check if button is displayed")
    public boolean isDisplayed(){
        return
        clickField.isDisplayed();



    }
}
