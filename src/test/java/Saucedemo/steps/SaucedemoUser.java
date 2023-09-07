package Saucedemo.steps;

import Saucedemo.pageobject.*;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class SaucedemoUser extends ScenarioActor {
    String actor;

    @Steps(shared=true)
    LoginPage loginPage;
    MainPage mainPage;
    AboutPage aboutPage;
    ShopCartPage cartPage;
    CheckoutInfoPage checkoutInfo;
    CheckoutOverviewPage checkoutOverview;
    CheckoutCompletePage checkoutComplete;

    public void navigatesTo(){
        loginPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        loginPage.open();
    }

    public void login(String username, String password){
        loginPage.userLogin(username, password);
    }

    public void goToAboutPage(){
        mainPage.goToAboutPage();
    }

    public void returnToMainPage(){
        aboutPage.goBack();
    }

    public void verifyUserInMainPage(){
        mainPage.verifyMainPage();
    }

    public void sortProdLowToHigh(){
        mainPage.sortLowToHigh();
    }

    public void addMostExpensiveProds(String prodCount){
        mainPage.addMostExpensiveProds(prodCount);
    }

    public void verifyCartBadge(String prodCount){
        mainPage.verifyCartBadge(prodCount);
    }

    public void resetAppState(){
        mainPage.resetAppState();
    }

    public void goToCartPage(){
        mainPage.goToCart();
    }

    public void reportCartProdInfo(){
        cartPage.storeAllProductInfo();
    }

    public void goToCheckout(){
        cartPage.goToCheckout();
    }

    public void enterPersonalData(String firstName, String lastName, String postalCode){
        checkoutInfo.fillData(firstName, lastName, postalCode);
    }

    public void goToCheckoutOverview(){
        checkoutInfo.continueToCheckoutOverview();
    }

    public void verifyProdPrices(){
        checkoutOverview.isTotalPriceCorrect();
    }

    public void reportOverview(){
        checkoutOverview.reportOverview();
    }

    public void goToCheckoutComplete(){
        checkoutOverview.finishCheckout();
    }

    public void verifySuccessMessage(){
        checkoutComplete.verifySuccessfulOrder();
    }

}
