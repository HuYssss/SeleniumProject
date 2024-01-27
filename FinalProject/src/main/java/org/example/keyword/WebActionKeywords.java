package org.example.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebActionKeywords {
    public WebDriver _driver;
    public WebDriverWait _wait;
    public WebActionKeywords(WebDriver driver){
        this._driver = driver;
        this._wait = new WebDriverWait(this._driver, Duration.ofSeconds(30));
    }

    public void openUrl(String url) throws Exception {
        if(!(url.startsWith("http://") || url.startsWith("https://"))){
            throw new Exception("Invalid Url format - please input have protocal http or https");
        }
        this._driver.get(url);
    }

    public WebElement findElement(By locator){
        return this._wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setText(By locator, String text){
        WebElement element = this.findElement(locator);
        try{
            element.clear();
            element.sendKeys(text);
        }
        catch (WebDriverException e){
            throw new WebDriverException("Element is not able to set text");
        }
    }

    public String textElement(String elementName) {
        String xpath = String.format("//tr[td[1][text()='%s']]", elementName);
        List<WebElement> elements = this._driver.findElements(By.xpath(xpath));
        return elements.get(1).getText();
    }

    public void click(By elementLocator){
        WebElement element = this.findElement(elementLocator);
        Actions action = new Actions(this._driver);
        action.moveToElement(element).build().perform();
        element.click();
    }

    public void select(WebElement elem, SelectType type, String options) throws Exception {
        Select select = new Select(elem);
        switch (type){
            case SELECT_BY_INDEX:
                try{
                    select.selectByIndex(Integer.parseInt(options));
                }
                catch (Exception e){
                    throw new Exception("Please input numberic on select option for selectType.SELECT_BY_INDEX");
                }
                break;
            case SELECT_BY_TEXT:
                select.selectByVisibleText(options);
                break;
            case SELECT_BY_VALUE:
                select.selectByValue(options);
                break;
            default:
                throw new Exception("Get error in using selected");
        }
    }

    public enum SelectType{
        SELECT_BY_INDEX,
        SELECT_BY_TEXT,
        SELECT_BY_VALUE
    }


}