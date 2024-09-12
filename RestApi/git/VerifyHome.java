package git;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VerifyHome {

    @FindBy (xpath ="//*[@id=\"field_5_2\"]/div/span" )
    private WebElement PizzaPrice;

    @FindBy (name ="input_21" )
    private WebElement pickPrice;



    @Step("select Delivery from options")
    public void selectDeliveryOption() {
        Select myPick = new Select(pickPrice);
        myPick.selectByValue("Delivery|3");
    }



    @Step("Get pizza price")
    public String getPrice() {
        return PizzaPrice.getText();
    }


}
