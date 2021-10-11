package pages.common;

import model.Customer;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Common {

    protected static ChromeDriver driver;
    protected static Product product = new Product();
    protected Customer customer = new Customer();


    private By closePopUpButton = By.cssSelector(".close-button.animated");
    private By popUp = By.cssSelector(".mt-overlay > div > iframe");
    private By closeButton = By.cssSelector(".icon-slider-close");
    private By bottomBar = By.cssSelector(".mt-promo-bar iframe");

    protected void startBrowser() {
        String driverPath = "src/test/resources/";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void startBrowserHeadless() {
        String driverPath = "/Users/vulros/Documents/FinalProject/src/main/resources/";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.1a.lv/");
    }

    public void stopBrowser() {
        driver.quit();
    }

    public void stopBrowserHeadless() {
        driver.quit();
    }

    protected void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void waitForClick(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForInvisibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    protected void clickOnHiddenElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement brand = driver.findElement(element);
        js.executeScript("arguments[0].click();", brand);
    }

    protected void sendKeysAction (By element, String product){
        WebElement searchText = driver.findElement(element);
        Actions performAct = new Actions(driver);
        performAct.sendKeys(searchText, product).build().perform();
    }

    public void closePopup() {
        try {
            waitUntil(popUp);
            String bottomFrame = driver.findElement(popUp).getAttribute("id");
            driver.switchTo().frame(bottomFrame);
            waitForClick(closePopUpButton);
            driver.findElement(closePopUpButton).click();
        } catch (Exception ignored) {
        }
        driver.switchTo().parentFrame();
    }

    public void closeBottomBar() {
        try {
            waitUntil(bottomBar);
            String bottomFrame = driver.findElement(bottomBar).getAttribute("id");
            driver.switchTo().frame(bottomFrame);
            waitForClick(closeButton);
            driver.findElement(closeButton).click();
        } catch (Exception ignored) {
        }
        driver.switchTo().parentFrame();
    }
}
