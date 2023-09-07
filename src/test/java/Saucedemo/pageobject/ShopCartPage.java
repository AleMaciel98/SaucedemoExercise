package Saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShopCartPage extends PageObject {

    @FindBy(id = "checkout")
    WebElementFacade checkoutBtn;

    static String cartItemClass="cart_item";
    static List<WebElementFacade> cartItemList;

    static String cartItemNameClass="inventory_item_name";
    static String cartItemDescClass="inventory_item_desc";
    static String cartItemPriceClass="inventory_item_price";

    public void storeAllProductInfo(){
        cartItemList = withTimeoutOf(Duration.ofSeconds(5)).findAll(By.className(cartItemClass));

        for (WebElementFacade cartItem : cartItemList) {
            String name = cartItem.findBy(By.className(cartItemNameClass)).getText();
            String description = cartItem.findBy(By.className(cartItemDescClass)).getText();
            String price = cartItem.findBy(By.className(cartItemPriceClass)).getText();

        String info = "Name: " + name + "\n" + "Description: " + description  + "\n" + "Price: " + price + "\n\n";
        Serenity.recordReportData().withTitle("Product Information").andContents(info);

        }
    }

    public void goToCheckout(){
        checkoutBtn.click();
    }
}
