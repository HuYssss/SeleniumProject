package base;

import org.example.configuration.Configuration;
import org.example.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver _driver;
    public Configuration _conf;

    @BeforeMethod
    public void setUp(){
        _conf = new Configuration("app.properties");
        _driver = DriverFactory.getDriver(_conf.getProperty("browser"));
        _driver.get(_conf.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){
        _driver.quit();
    }
}
