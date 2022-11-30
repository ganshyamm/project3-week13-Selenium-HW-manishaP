package utility;

import brosfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityTest extends BaseTest {
    //this method will click on element

    public void clickOnElement(By by) {
        WebElement loginlink = driver.findElement(by);
        loginlink.click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }
    public void selectMenu(String menu) {
        String clickOnMenu;


    }
//****************************Alert Methods*************************************

    // This method will switch to alert

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void dismissAlert() {
        //switch alert
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();//Accept the alert
    }

    //*********************************select class method******************************

    //this method will select option by visible text
    public void selectbyvisibleTextFRomDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    // This method will select the option by value
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by value
        select.selectByIndex(index);
    }
    //*********************************mouse hoover method******************************
    public void mouseHoverToElement(By by) {
        Actions action = new Actions(driver);
        WebElement e = driver.findElement(by);
        action.moveToElement(e).build().perform();
    }

    public void mouseHoverAndClick(By by) {

        Actions action = new Actions(driver);
        WebElement e = driver.findElement(by);
        action.moveToElement(e).click().build().perform();
    }
}

