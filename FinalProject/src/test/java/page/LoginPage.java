package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginToSystem() {
        By userId = By.xpath("//input[@name='uid']");
        By password = By.xpath("//input[@name='password']");
        By loginBtn = By.xpath("//input[@name='btnLogin']");
        this._actionKeyword.setText(userId, this._config.getProperty("userId"));
        this._actionKeyword.setText(password, this._config.getProperty("password"));
        this._actionKeyword.click(loginBtn);
        return new HomePage(this._driver);
    }
}
