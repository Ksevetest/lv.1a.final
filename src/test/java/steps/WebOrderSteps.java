package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import pages.FilterPage;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCart;

public class WebOrderSteps {

    private HomePage homePage = new HomePage();
    private FilterPage filterPage = new FilterPage();
    private ProductPage productPage = new ProductPage();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @Given("client opens (.*) website")
    public void clientOpensWebsite(String website) {
        homePage.webPage(website);
        homePage.setCookies();
    }

    @When("client makes search by text:(.*)")
    public void clientTypesInSearchField(String product) {
        homePage.searchProduct(product);
    }

    @And("sets up new filter")
    public void clientSetsUpNewFilter() {
        filterPage.pickBrand();
        filterPage.closeBottomBar();
        filterPage.closePopup();
        filterPage.closeAdvertisement();
    }

    @And("adds most stared product in shopping cart")
    public void clientAddsMostStaredProductInShoppingCart() {
        filterPage.pickBestRated();
        filterPage.selectBestRated();
    }

    @And("goes to delivery page")
    public void clientOpensOrderPage() {
        productPage.setProductName();
        productPage.addProductToCart();
        shoppingCart.checkOutWithoutUser();
    }

    @Then("client enters personal information")
    public void clientEntersPersonalInformation() {
        shoppingCart.setCustomer();
        shoppingCart.customerData();
    }

    @And("chooses delivery and payment way")
    public void clientChoosesDeliveryAndPaymentWay() {
        shoppingCart.getInOffice();
        shoppingCart.payOption();
    }

    @And("checks order summary")
    public void clientChecksOrderSummary() {
        shoppingCart.productNameValidation();
        shoppingCart.priceValidation();
        shoppingCart.customerValidation();
    }
}
