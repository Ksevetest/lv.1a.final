package pages;


import pages.common.Common;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends Common {

    private By cookies = By.cssSelector(".c-button-inverse");
    private By searchBar = By.cssSelector("#search_products_text_field");

    public void webPage(String website) {
        driver.get(website);
        String title = "Lielākais interneta veikals Latvijā - www.1a.lv";
        assertThat(driver.getTitle().contains(title));
    }

    public void setCookies() {
        waitForClick(cookies);
        driver.findElement(cookies).click();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBar).sendKeys(product);
        driver.findElement(searchBar).submit();
    }
}