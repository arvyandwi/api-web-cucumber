package webauto.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webauto.BasePageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ProductDetailPage extends BasePageObject {

    WebDriver driver;

    By productName = By.xpath("//*[@class='name']");
    By productPrice = By.xpath("//*[@class='price-container']");
    By btnAddCart = By.xpath("//*[contains(@onclick, 'addToCart')]");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductName(String expectedText) throws InterruptedException {
        Thread.sleep(5000);
        String actualText = driver.findElement(productName).getText();
        assertEquals(expectedText, actualText);
        if(actualText.equals(expectedText)) {
            System.out.println("Actual Product Name " + actualText + " is equal to Expected Product Name " + expectedText);
        } else {
            throw new IllegalArgumentException("Error: Expected Product Name " + expectedText + " is not equal to Actual Product Name " + actualText);
        }
    }

    public void verifyProductPrice(String expectedText) {
        waitForElement(productPrice);
        String actualText = driver.findElement(productPrice).getText().replaceAll("[^0-9]", "");
        assertEquals(expectedText, actualText);
        if(actualText.equals(expectedText)) {
            System.out.println("Actual Product Price " + actualText + " is equal to Expected Product Price " + expectedText);
        } else {
            throw new IllegalArgumentException("Error: Expected Product Price " + expectedText + " is not equal to Actual Product Price " + actualText);
        }
    }

    public void clickAddCart() {
        waitForElement(btnAddCart);
        driver.findElement(btnAddCart).click();
    }

    public void verifySuccessAddToCart() {
        waitForAlert();

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        assertTrue(text.contains("Product added"));

        alert.accept();
    }
}
