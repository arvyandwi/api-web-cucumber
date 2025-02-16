package webauto.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webauto.BasePageObject;

import static org.junit.Assert.assertTrue;

public class ContactPage extends BasePageObject {

    WebDriver driver;

    By inputEmail = By.xpath("//input[@id='recipient-email']");
    By inputContactName = By.xpath("//input[@id='recipient-name']");
    By inputMessage = By.xpath("//textarea[@id='message-text']");
    By btnSend = By.xpath("//button[@onclick='send()']");
    By btnClose = By.xpath("//button[@onclick='send()']/preceding-sibling::button[1]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail() {
        waitForElement(inputEmail);
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys("test_email1@email.com");
    }

    public void inputContactName() {
        waitForElement(inputContactName);
        driver.findElement(inputContactName).click();
        driver.findElement(inputContactName).sendKeys("random_name");
    }

    public void inputTextMessage() {
        waitForElement(inputMessage);
        driver.findElement(inputMessage).click();
        driver.findElement(inputMessage).sendKeys("Keep your heads up!");
    }

    public void clickSend() {
        waitForElement(btnSend);
        driver.findElement(btnSend).click();
    }

    public void verifySuccessSendMessage() {
        waitForAlert();

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        assertTrue(text.contains("Thanks for the message"));

        alert.accept();
    }
}
