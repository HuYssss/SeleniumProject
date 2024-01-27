package base;

import org.example.configuration.Configuration;
import org.example.keyword.WebActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver _driver;
    public WebActionKeywords _actionKeyword;
    public Configuration _config;

    public BasePage(WebDriver driver){
        this._driver = driver;
        this._actionKeyword = new WebActionKeywords(this._driver);
        this._config = new Configuration("app.properties");
    }

    public WebElement findElementWithWait(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return null;
        }
    }
}
