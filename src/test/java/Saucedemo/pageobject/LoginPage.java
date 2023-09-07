package Saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(id = "user-name")
    WebElementFacade usernameInput;

    @FindBy(id="password")
    WebElementFacade passwordInput;

    @FindBy(id = "login-button")
    WebElementFacade loginBtn;

    public void userLogin(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
