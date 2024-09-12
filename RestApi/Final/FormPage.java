package Final;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage {


    @FindBy(name = "input_22.3")
    private WebElement firstNameField;

    @FindBy(name = "input_22.6")
    private WebElement lastNameField;

    @FindBy (xpath ="//*[@id=\"field_5_2\"]/div/span" )
    private WebElement PizzaPrice;

    @FindBy (name ="input_21" )
    private WebElement pickPrice;


    @FindBy(id = "gform_submit_button_5")
    private WebElement submitButton;





    @Step("Fill using provided firstName and lastName")
    public void FillDetails(String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);


    }

    public String getFirstNameValue() {
        return firstNameField.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastNameField.getAttribute("value");
    }


    @Step("select Delivery from options")
    public void selectDeliveryOption() {
        Select myPick = new Select(pickPrice);
        myPick.selectByValue("Delivery|3");
    }



    @Step("Get pizza price")
    public String getPrice() {
        return PizzaPrice.getText();
    }


    @Step("Click on Submit button")
    public void clickSubmitOrder() {
        submitButton.click();
    }



}


