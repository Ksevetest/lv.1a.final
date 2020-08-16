package pages;


import pages.common.Common;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends Common {

    protected By cookies = By.cssSelector(".c-button-inverse"),
            searchBar = By.cssSelector("#q.sn-suggest-input");

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
//        driver.findElement(searchBar).click();
        waitForClick(searchBar);
        driver.findElement(searchBar).sendKeys(product);
        driver.findElement(searchBar).submit();
    }
}