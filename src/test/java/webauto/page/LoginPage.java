package webauto.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webauto.BasePageObject;

import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePageObject {

    WebDriver driver;

    By txtInputUsername = By.xpath("//input[@id='loginusername']");
    By txtInputPassword = By.xpath("//input[@id='loginpassword']");
    By btnLogin = By.xpath("//button[@onClick='logIn()']");
    By btnClose = By.xpath("//button[@onClick='logIn()']/preceding-sibling::button[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        waitForElement(txtInputUsername);
        driver.findElement(txtInputUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        waitForElement(txtInputPassword);
        driver.findElement(txtInputPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    public void clickClose() {
        driver.findElement(btnClose).click();
    }

    public void verifyErrorPassword() {
        waitForAlert();

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        assertEquals(text, "Wrong password.");

        alert.accept();

    }
}
