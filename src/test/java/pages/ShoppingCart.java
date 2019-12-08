package pages;


import pages.common.Common;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCart extends Common {

    // Buttons
    private By forwardButton = By.cssSelector(".order-form-forward-button");
    private By skipButton = By.cssSelector(".btn-v2");

    // Customer
    private By firstName = By.cssSelector("#order_main_data_name");
    private By lastName = By.cssSelector("#order_main_data_surname");
    private By email = By.cssSelector("#order_main_data_email");
    private By phone = By.cssSelector("#order_main_data_contact_phone_number");

    // Communication and agreements
    private By communication = By.cssSelector(".ui-button-icon");
    private By doNotEmailMe = By.cssSelector("#ui-id-2");
    private By agreement = By.cssSelector("#accept_purchase_agreement");

    // Delivery and payment way
    private By deliveryType = By.cssSelector("article:nth-child(7)");
    private By deliveryContainer = By.cssSelector(".form-cols.predefined-delivery-address-container");
    private By paymentType = By.cssSelector("a[payment_type='CASH_INDIVIDUAL_PERSON']");
    private By paymentTab = By.cssSelector(".payment-type-tab");

    // Order summary valiation
    private By productNameCheck = By.cssSelector(".ait-cart-item-info>h4>a");
    private By confirmationPrice = By.cssSelector("div:nth-child(1) > span.ait-cart-total-count");
    private By deliveryPrice = By.cssSelector("div:nth-child(2) > span.ait-cart-total-count");
    private By clientData = By.cssSelector(".col-1 > p");

    public void checkOutWithoutUser() {
        driver.findElement(forwardButton).click();
        driver.findElement(skipButton).click();
    }

    public void setCustomer() {
        customer.setFirstName("Janis");
        customer.setLastName("Ozoliņš");
        customer.setEmail("blablabla@gmail.com");
        customer.setPhoneNumber("+37126265611");
    }

    public void customerData() {
        driver.findElement(firstName).sendKeys(customer.getFirstName());
        driver.findElement(lastName).sendKeys(customer.getLastName());
        driver.findElement(email).sendKeys(customer.getEmail());
        driver.findElement(phone).sendKeys(customer.getPhoneNumber());
    }

    public void getInOffice() {
        driver.findElement(communication).click();
        waitForClick(doNotEmailMe);
        driver.findElement(doNotEmailMe).click();
        driver.findElement(agreement).click();
        driver.findElement(deliveryType).click();
        waitUntil(deliveryContainer);
        driver.findElement(forwardButton).click();
    }

    public void payOption() {
        driver.findElement(paymentType).click();
        waitUntil(paymentTab);
        driver.findElement(forwardButton).click();
    }

    public void productNameValidation() {
        waitUntil(productNameCheck);
        assertThat(driver.findElement(productNameCheck).getText()).isEqualToIgnoringCase(product.getProductName());
        String checkPriceString = driver.findElement(confirmationPrice).getText().replaceAll("[^\\d.]", "");
        String deliveryString = driver.findElement(deliveryPrice).getText().replaceAll("[^\\d.]", "");
        float priceFloat = Float.parseFloat(checkPriceString);
        float deliveryFloat = Float.parseFloat(deliveryString);
        float finalPrice = priceFloat + deliveryFloat;
        assertThat(finalPrice).isEqualTo(product.getProductPrice());
    }

    public void priceValidation() {
        String checkPriceString = driver.findElement(confirmationPrice).getText().replaceAll("[^\\d.]", "");
        String deliveryString = driver.findElement(deliveryPrice).getText().replaceAll("[^\\d.]", "");
        float priceFloat = Float.parseFloat(checkPriceString);
        float deliveryFloat = Float.parseFloat(deliveryString);
        float finalPrice = priceFloat + deliveryFloat;
        assertThat(finalPrice).isEqualTo(product.getProductPrice());
    }

    public void customerValidation() {
        String client = driver.findElement(clientData).getText();
        String[] clientSplit = client.split("\\n");
        assertThat(clientSplit).contains(
                (customer.getFirstName() + " " + customer.getLastName()),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
}

