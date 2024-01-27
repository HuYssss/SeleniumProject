package page;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword extends BasePage {
    public ChangePassword(WebDriver driver) {
        super(driver);
    }

    public LoginPage changePass(String password) {
        String validPass = checkValidPass(password);

        By oldPass = By.xpath("//input[@name='oldpassword']");
        By newPass = By.xpath("//input[@name='newpassword']");
        By confirmPass = By.xpath("//input[@name='confirmpassword']");
        By submit = By.xpath("//input[@name='sub']");

        this._actionKeyword.setText(oldPass, this._config.getProperty("password"));
        this._actionKeyword.setText(newPass, validPass);
        this._actionKeyword.setText(confirmPass, validPass);
        this._actionKeyword.findElement(submit).click();

        Alert alert = this._driver.switchTo().alert();
        alert.accept();

        this._config.updateProperty("password", validPass);

        return new LoginPage(this._driver);
    }

    public String checkValidPass(String password) {
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))
            password += "@";
        return  password;
    }
}
