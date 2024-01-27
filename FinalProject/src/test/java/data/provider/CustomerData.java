package data.provider;

import org.example.configuration.Configuration;
import org.example.helper.ExcelHelper;
import org.testng.annotations.DataProvider;

public class CustomerData {

    @DataProvider(name = "customerData")
    public Object[][] data() {
        Configuration configuration = new Configuration("app.properties");
        return ExcelHelper.readExcelFromFile(configuration.getProperty("data"));
    }
}
