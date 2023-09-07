package Saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class CheckoutOverviewPage extends PageObject{
    @FindBy(xpath = "//div[contains(text(),'SauceCard')]")
    WebElementFacade paymentInfoLabel;

    @FindBy(xpath = "//div[contains(text(), 'Shipping Information')]/following-sibling::div[1]")
    WebElementFacade shippingInfoLabel;

    @FindBy(className = "summary_subtotal_label")
    WebElementFacade subtotalLabel;

    @FindBy(className = "summary_tax_label")
    WebElementFacade taxLabel;

    @FindBy(className = "summary_total_label")
    WebElementFacade totalLabel;

    @FindBy(id = "finish")
    WebElementFacade finishBtn;

    static String itemsPricesClass="inventory_item_price";
    static List<WebElementFacade> itemsPrices;

    public void isTotalPriceCorrect() {
        itemsPrices= withTimeoutOf(Duration.ofSeconds(5)).findAll(By.className(itemsPricesClass));
        System.out.println("isTotalPriceCorrect");
        System.out.println(itemsPrices.size());
        double sumOfItemPrices = 0.0;
        for (WebElementFacade itemPrice : itemsPrices) {
            String priceText = itemPrice.getText().replace("$", "");
            double itemPriceValue = Double.parseDouble(priceText);
            sumOfItemPrices += itemPriceValue;
        }

        String subtotalText = subtotalLabel.getText().replace("Item total: $", "");
        double totalFromLabel = Double.parseDouble(subtotalText);

        System.out.println(totalFromLabel);
        System.out.println(sumOfItemPrices);

        Assert.assertEquals( totalFromLabel, sumOfItemPrices, 0.01);
    }

    public void reportOverview(){
        String paymentInfo = paymentInfoLabel.getText();
        String shippingInfo = shippingInfoLabel.getText();
        String itemTotal = subtotalLabel.getText();
        String tax = taxLabel.getText();
        String total= totalLabel.getText();
        String info = "Payment Information: " + paymentInfo +"\n"+
                "Shipping Information: "+ shippingInfo + "\n" +
                "Item Total: " + itemTotal + "\n" +
                "Tax: " + tax + "\n" +
                "Total: " + total + "\n" ;

        Serenity.recordReportData().withTitle("Checkout Overview").andContents(info);
    }


    public void finishCheckout(){
        finishBtn.click();
    }


}
