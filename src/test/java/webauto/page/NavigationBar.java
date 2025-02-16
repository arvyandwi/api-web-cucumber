package webauto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webauto.BasePageObject;

public class NavigationBar extends BasePageObject {

    WebDriver driver;

    By contactNavItem = By.xpath("//a[@data-target='#exampleModal']");
    By aboutUsNavItem = By.xpath("//a[@data-target='#videoModal']");
    By cartNavItem = By.xpath("//a[@id='cartur']");

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContact() {
        waitForElement(contactNavItem);
        driver.findElement(contactNavItem).click();
    }

    public void clickAboutUs() {
        waitForElement(aboutUsNavItem);
        driver.findElement(aboutUsNavItem).click();
    }

    public void clickCart() {
        waitForElement(cartNavItem);
        driver.findElement(cartNavItem).click();
    }
}
