package test;

import base.TestBase;
import data.provider.CustomerData;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class FlowTest extends TestBase {
    @Test
    public void changeNewPassword() {
        LoginPage loginPage = new LoginPage(this._driver);
        Assert.assertTrue(loginPage
                .loginToSystem()
                .navigateToChangePass()
                .changePass("Huynhlehuy123@")
                .loginToSystem()
                .Logout()
                .checkLogout());
    }

    @Test(dataProvider = "customerData", dataProviderClass = CustomerData.class)
    public void createNewCustomer(String name, String gender, String dateOfBirth, String address
            , String city, String state, String PIN, String mobiNum, String email, String password)
    {
        LoginPage loginPage = new LoginPage(this._driver);
        loginPage.loginToSystem()
                .navigateToNewCustomer()
                .addNewCustomer(name, gender, dateOfBirth, address, city, state, PIN, mobiNum, email, password);
    }
}
