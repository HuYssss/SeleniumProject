package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewCustomer extends BasePage {
    public NewCustomer(WebDriver driver) {
        super(driver);
    }

    public HomePage addNewCustomer(String name, String gender, String dateOfBirth, String address
            , String city, String state, String PIN, String mobiNum, String email, String password)
    {
        this._actionKeyword.setText(By.xpath("//input[@name='name']"), name);
        this._actionKeyword.click(checkGender(gender));
        this._actionKeyword.setText(By.xpath("//input[@name='dob']"), isValidDate(dateOfBirth));
        this._actionKeyword.setText(By.xpath("//textarea[@name='addr']"), address);
        this._actionKeyword.setText(By.xpath("//input[@name='city']"), city);
        this._actionKeyword.setText(By.xpath("//input[@name='state']"), state);
        this._actionKeyword.setText(By.xpath("//input[@name='pinno']"), PIN);
        this._actionKeyword.setText(By.xpath("//input[@name='telephoneno']"), mobiNum);
        this._actionKeyword.setText(By.xpath("//input[@name='emailid']"), email);
        this._actionKeyword.setText(By.xpath("//input[@name='password']"), password);
        this._actionKeyword.findElement(By.xpath("//input[@name='sub']")).click();

        return new HomePage(this._driver);
    }

//    public boolean checkInformation(String name, String gender, String dateOfBirth, String address
//            , String city, String state, String PIN, String mobiNum, String email, String password) {
//
//    }

    public By checkGender(String gender){
        if (gender.equals("male"))
            return By.xpath("//input[@name='rad1' and @value='m']");
        else
            return By.xpath("//input[@name='rad1' and @value='f']");
    }



    public static String isValidDate(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate date = LocalDate.parse(dateStr, dateFormatter);

            return dateStr;
        } catch (Exception e) {
            return "01/01/2023";
        }
    }
}
