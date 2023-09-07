package Saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends PageObject {
    @FindBy(id ="first-name")
    WebElementFacade firstNameInput;
    @FindBy(id = "last-name")
    WebElementFacade lastNameInput;
    @FindBy(id = "postal-code")
    WebElementFacade postalCodeInput;
    @FindBy(id = "continue")
    WebElementFacade continueBtn;

    public void fillData(String firstName, String lastName, String postalCode){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);

    }
    public void continueToCheckoutOverview(){
        continueBtn.click();
    }
}
