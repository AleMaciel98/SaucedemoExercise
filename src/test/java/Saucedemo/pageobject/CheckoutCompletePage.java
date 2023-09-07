package Saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends PageObject {
    @FindBy(className = "complete-header")
    WebElementFacade completedHeader;

    public void verifySuccessfulOrder(){
        Assert.assertEquals("Thank you for your order!", completedHeader.getText());
    }
}
