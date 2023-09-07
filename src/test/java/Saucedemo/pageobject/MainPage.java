package Saucedemo.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends PageObject {

    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade hamburgerMenu;

    @FindBy(className = "product_sort_container")
    WebElementFacade productSort;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[contains(text(),'Price (low to high)')]")
    WebElementFacade sortPriceLowToHigh;

    @FindBy(className = "shopping_cart_badge")
    WebElementFacade shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElementFacade shoppingCartIconLink;

    static String aboutLinkId = "about_sidebar_link";
    static WebElementFacade aboutLink;

    static String addToCartBtnClass = "btn_inventory";
    static List<WebElementFacade> listAddToCart;

    static String resetLinkId= "reset_sidebar_link";
    WebElementFacade resetLink;

    public void goToAboutPage(){
        hamburgerMenu.click();
        // Wait for the "About" link to be clickable
        aboutLink = withTimeoutOf(Duration.ofSeconds(10)).find(By.id(aboutLinkId));
        aboutLink.click();
    }

    public void verifyMainPage(){
        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void sortLowToHigh(){
        productSort.click();
        sortPriceLowToHigh.click();
    }

    public void addMostExpensiveProds(String items){

        listAddToCart = withTimeoutOf(Duration.ofSeconds(10)).findAll(By.className(addToCartBtnClass));
        int listAddToCartSize = listAddToCart.size();
        int itemsInteger = Integer.parseInt(items);
        //since the list is organized from Low to High we need the go through the list from the bottom to the top
        for (int i = listAddToCartSize-1; i>=listAddToCartSize-itemsInteger; i--){
            listAddToCart.get(i).click();
        }
    }

    public void verifyCartBadge(String items){
        Assert.assertEquals(items, shoppingCartBadge.getText());
    }

    public void goToCart(){
        shoppingCartIconLink.click();
    }

    public void resetAppState(){
        hamburgerMenu.click();
        resetLink = withTimeoutOf(Duration.ofSeconds(10)).find(By.id(resetLinkId));
        resetLink.click();
    }

}
