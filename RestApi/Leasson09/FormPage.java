package Leasson09;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
    @FindBy(id = "occupation")
    private WebElement occupationField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "location")
    private WebElement locationField;

    @FindBy(css = "input[value='Click Me']")
    private WebElement buttonField;

    @Step("Fill form  provided occupation  age and location")
    public void fillForm(String occupation,String age,String location){
        occupationField.sendKeys(occupation);
        ageField.sendKeys(age);
        locationField.sendKeys(location);
        buttonField.click();



    }
}
