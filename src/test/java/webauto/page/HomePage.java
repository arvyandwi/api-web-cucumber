package webauto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webauto.BasePageObject;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HomePage extends BasePageObject {

    WebDriver driver;

    By loginNavItem = By.xpath("//a[@id='login2']");
    By logoutNavItem = By.xpath("//a[@id='logout2']");
    By selectedItem = By.xpath("//a[.='Samsung galaxy s6']");
    By selectedItemPrice = By.xpath("//div[@id='tbodyid']/div[1]//h5");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomepage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickLoginTab() {
        waitForElement(loginNavItem);
        driver.findElement(loginNavItem).click();
    }

    public void clickLogoutTab() {
        waitForElement(logoutNavItem);
        driver.findElement(logoutNavItem).click();
    }

    private void scrollToElement(By obj) {
        WebElement element = driver.findElement(obj);
        new Actions(driver).scrollToElement(element).perform();
    }

    public Map getItemDetails() {
        scrollToElement(selectedItem);
        Map<String, String> itemDetails = new HashMap<>();
        String productName = driver.findElement(selectedItem).getText();
        String productPrice = driver.findElement(selectedItemPrice).getText();
        itemDetails.put("Name", productName);
        itemDetails.put("Price", productPrice);
        return itemDetails;
    }

    public String getItemName() throws InterruptedException {
        Thread.sleep(5000);
        String productName = driver.findElement(selectedItem).getText();
        return productName;
    }

    public String getItemPrice() {
        String productPrice = driver.findElement(selectedItemPrice).getText().replaceAll("[^0-9]", "");
        return productPrice;
    }

    public void selectItem() throws InterruptedException {
        //waitForElement(selectedItem);
        Thread.sleep(5000);
        driver.findElement(selectedItem).click();
    }

    public void verifyLogoutTabAppear() {
        driver.findElement(logoutNavItem).isDisplayed();
    }
}
