package webauto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webauto.BasePageObject;

public class HomePage extends BasePageObject {

    WebDriver driver;

    By loginNavItem = By.xpath("//a[@id='login2']");
    By logoutNavItem = By.xpath("//a[@id='logout2']");

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

    public void verifyLogoutTabAppear() {
        driver.findElement(logoutNavItem).isDisplayed();
    }
}
