package pages;

import pages.common.Common;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends Common {

    private By cookies = By.cssSelector(".c-button-inverse");
    private By searchBar = By.cssSelector("#top-search-form");
    private By searchSubmit = By.cssSelector(".main-search__submit");
//    private By searchBar = By.cssSelector(".main-search__input");

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
        sendKeysAction(searchBar,product);
        driver.findElement(searchSubmit).submit();
    }
}