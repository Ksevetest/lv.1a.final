package pages;

import common.Common;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage extends Common {

    private By addToCard = By.cssSelector(".btn-cart");
    private By productInCart = By.cssSelector(".product-is-in-cart");
    private By productName = By.cssSelector("div.product-main-info>h1");
    private By productPrice = By.cssSelector(".price-v2");

    public void setProductName() {
        String nameString = driver.findElement(productName).getText();
        product.setProductName(nameString);
        String priceString = driver.findElement(productPrice).getAttribute("data-sell-price-w-vat");
        float price = Float.parseFloat(priceString);
        product.setProductPrice(price);
    }

    public void addProductToCart() {
        closePopup();
        driver.findElement(addToCard).click();
        waitUntil(productInCart);
        assertThat(driver.findElement(productInCart).getText()).isEqualToIgnoringCase("Uz grozu");
        driver.findElement(productInCart).click();
    }
}
