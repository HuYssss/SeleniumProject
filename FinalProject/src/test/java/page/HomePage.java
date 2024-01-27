package page;

import base.BasePage;
import org.openqa.selenium.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closeAd() {
        WebElement adElement = this.findElementWithWait(By.id("ad_position_box"));
        if (adElement != null)
            ((JavascriptExecutor) _driver).executeScript("arguments[0].style.display='none'", adElement);
    }

    public ChangePassword navigateToChangePass() {
        By changePassOption = By.xpath("//a[@href='PasswordInput.php']");
        this._actionKeyword.click(changePassOption);
        closeAd();
        return new ChangePassword(this._driver);
    }

    public NewCustomer navigateToNewCustomer() {
        By newCustomerOption = By.xpath("//a[@href='addcustomerpage.php']");
        this._actionKeyword.click(newCustomerOption);
        closeAd();
        return new NewCustomer(this._driver);
    }


    public HomePage Logout() {
        By logout = By.xpath("//a[@href='Logout.php']");
        this._actionKeyword.findElement(logout).click();

        return this;
    }

    public boolean checkLogout() {
        String logoutSuccess = "You Have Succesfully Logged Out!!";
        Alert alert = this._driver.switchTo().alert();
        return alert.getText().equals(logoutSuccess);
    }
}
