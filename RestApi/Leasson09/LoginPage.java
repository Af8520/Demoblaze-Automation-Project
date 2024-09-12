package Leasson09;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username2")
    private WebElement usernamefield;

    @FindBy(name="password2")
    private WebElement passwordfield;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @Step("Sign in using provided username and password")
    public void signIn(String username,String password){
        usernamefield.sendKeys(username);
        passwordfield.sendKeys(password);
        submitButton.click();

    }


}
