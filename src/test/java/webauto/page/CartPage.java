package webauto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webauto.BasePageObject;

import static org.junit.Assert.assertEquals;

public class CartPage extends BasePageObject {

    WebDriver driver;

    By tdProductName = By.xpath("//*[@id='tbodyid']/tr/td[2]");
    By tdProductPrice = By.xpath("//*[@id='tbodyid']/tr/td[3]");
    By btnDelete = By.xpath("//a[contains(@onclick, 'deleteItem')]");
    By lblGrandTotal = By.xpath("//h3[@id='totalp']");
    By btnPlaceOrder = By.xpath("//button[@data-target='#orderModal']");
    By inputNameOverlay = By.xpath("//input[@id='name']");
    By inputCountryOverlay = By.xpath("//input[@id='country']");
    By inputCityOverlay = By.xpath("//input[@id='city']");
    By inputCardNumberOverlay = By.xpath("//input[@id='card']");
    By inputMonthOverlay = By.xpath("//input[@id='month']");
    By inputYearOverlay = By.xpath("//input[@id='year']");
    By btnPurchase = By.xpath("//button[@onclick='purchaseOrder()']");
    By lblPopup = By.xpath("//div[contains(@class, 'sweet-alert')]/h2");
    By btnCloseOverlay = By.xpath("//button[@onclick='purchaseOrder()']/preceding-sibling::button[1]");
    By btnConfirmPopup = By.xpath("//button[contains(@class, 'confirm')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductName(String expectedText) throws InterruptedException {
        Thread.sleep(5000);
        String productName = driver.findElement(tdProductName).getText();
        assertEquals(expectedText, productName);
        if(productName.equals(expectedText)) {
            System.out.println("Actual Product Name " + productName + " is equal to Expected Product Name " + expectedText);
        } else {
            throw new IllegalArgumentException("Error: Expected Product Name " + expectedText + " is not equal to Actual Product Name " + productName);
        }
    }

    public void verifyProductPrice(String expectedText) {
        String productPrice = driver.findElement(tdProductPrice).getText().replaceAll("[^0-9]", "");
        String grandTotal = driver.findElement(lblGrandTotal).getText().replaceAll("[^0-9]", "");
        assertEquals(grandTotal, productPrice);
        if(productPrice.equals(grandTotal)) {
            System.out.println("Actual Product Price " + productPrice + " is equal to Expected Product Price " + grandTotal);
        } else {
            throw new IllegalArgumentException("Error: Expected Product Price " + grandTotal + " is not equal to Actual Product Price " + productPrice);
        }
    }

    public void clickPlaceOrder() {
        driver.findElement(btnPlaceOrder).click();
    }

    public void inputName() {
        waitForElement(inputNameOverlay);
        driver.findElement(inputNameOverlay).click();
        driver.findElement(inputNameOverlay).sendKeys("name_1");
    }

    public void inputCountry() {
        waitForElement(inputCountryOverlay);
        driver.findElement(inputCountryOverlay).click();
        driver.findElement(inputCountryOverlay).sendKeys("country_1");
    }

    public void inputCity() {
        waitForElement(inputCityOverlay);
        driver.findElement(inputCityOverlay).click();
        driver.findElement(inputCityOverlay).sendKeys("city_1");
    }

    public void inputCardNumber() {
        waitForElement(inputCardNumberOverlay);
        driver.findElement(inputCardNumberOverlay).click();
        driver.findElement(inputCardNumberOverlay).sendKeys("1234567");
    }

    public void inputMonth() {
        waitForElement(inputMonthOverlay);
        driver.findElement(inputMonthOverlay).click();
        driver.findElement(inputMonthOverlay).sendKeys("month_1");
    }

    public void inputYear() {
        waitForElement(inputYearOverlay);
        driver.findElement(inputYearOverlay).click();
        driver.findElement(inputYearOverlay).sendKeys("year_1");
    }

    public void clickPurchase() {
        waitForElement(btnPurchase);
        driver.findElement(btnPurchase).click();
    }

    public void verifySucessfulCheckout() {
        driver.findElement(lblPopup).isDisplayed();
        String popup = driver.findElement(lblPopup).getText();
        assertEquals("Thank you for your purchase!", popup);
    }

    public void clickConfirmPopup() {
        waitForElement(btnConfirmPopup);
        driver.findElement(btnConfirmPopup).click();
    }

    public void clickDeleteProduct() {
        waitForElement(btnDelete);
        driver.findElement(btnDelete).click();
    }

    public void verifyCartIsEmpty() {
        boolean empty = driver.findElements(tdProductName).isEmpty();
        if(empty) {
            System.out.println("Cart is empty!");
        } else {
            throw new IllegalArgumentException("Cart is not empty!");
        }
    }

}
