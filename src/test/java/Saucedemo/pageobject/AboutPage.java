package Saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;

public class AboutPage extends PageObject {
    //goes back to the Main Page (Product Page)
    public void goBack(){
        getDriver().navigate().back();
    }
}

