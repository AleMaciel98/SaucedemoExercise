package Saucedemo.stepsdefinitions;

import Saucedemo.steps.SaucedemoUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserStepsDefinition {
    @Steps(shared=true)
    SaucedemoUser user;

    // Background:
    @Given("^user navigates to https://www.saucedemo.com/$")
    public void userNavigateToSaucedemo(){
        user.navigatesTo();
        Serenity.takeScreenshot();
    }

    @And("^user logs with standard user$")
    public void userLogsIn(){
        user.login("standard_user","secret_sauce");
        Serenity.takeScreenshot();
    }



    // Scenario: User Navigation
    @And("^user navigates to the About tab$")
    public void userNavigateToAbout(){
        user.goToAboutPage();
        Serenity.takeScreenshot();
    }

    @And("^user returns to the Products page$")
    public void userNavigateToProductsPage(){
        user.returnToMainPage();
        Serenity.takeScreenshot();
    }

    @Then("^user should see the product page$")
    public void userSeesProductPage(){
        user.verifyUserInMainPage();
        //no screenshot since it is an extra step to close scenario correctly(the function used before already does the screenshot)
    }


    //Scenario Outline: Adding Products to Cart
    @And("^user sorts the products from low to high price$")
    public void userSortLowToHigh(){
        user.sortProdLowToHigh();
        Serenity.takeScreenshot();
    }

    @And("^user adds the top (.*) most expensive products to the shopping cart$")
    public void userAddTopProducts(String prodCount){
        user.addMostExpensiveProds(prodCount);
        Serenity.takeScreenshot();
    }

    @Then("^user should see the cart icon displaying the number (.*) in the top right corner$")
    public void userCheckCart(String prodCount){
        user.verifyCartBadge(prodCount);
        Serenity.takeScreenshot();
        user.resetAppState();
    }



    //Scenario Outline: Buying the product

    @And("^user goes on the shopping cart$")
    public void userNavigatesToCart(){
        user.goToCartPage();
        user.reportCartProdInfo();
        Serenity.takeScreenshot();
    }

    @When("^user proceeds to checkout$")
    public void userNavigatesToCheckout(){
        user.goToCheckout();
        Serenity.takeScreenshot();
    }

    @And("^user enters personal information (.*), (.*), (.*) and continue$")
    public void userEntersPersonalInfo(String firstName, String lastName, String postalCode){
        user.enterPersonalData(firstName, lastName, postalCode);
        Serenity.takeScreenshot();
        user.goToCheckoutOverview();
    }

    @And("^user verifies the correct total price$")
    public void userVerifyPrice(){
        user.verifyProdPrices();
        user.reportOverview();
        Serenity.takeScreenshot();
    }

    @And("^user completes the purchase$")
    public void userCompletePurchase(){
        user.goToCheckoutComplete();
        Serenity.takeScreenshot();
    }

    @Then("^user should see a success message$")
    public void userSuccessMessage(){
        user.verifySuccessMessage();
        Serenity.takeScreenshot();
    }


}
