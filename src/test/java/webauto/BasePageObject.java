package webauto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    protected static WebDriver driver;

    protected void getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        //WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    protected static void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
