package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UtilityTest;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends UtilityTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    public void selectMyAccountOptions(String option, By by) {
        List<WebElement> options = driver.findElements(by);
        for (WebElement name : options) {
            if (name.getText().equalsIgnoreCase(option)) {
                name.click();
                break;
            }
        }
    }

    @Test
    //Login page
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
        String select = getTextFromElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        selectMyAccountOptions(select, By.xpath("//span[contains(text(),'My Account')]"));
        //2.3 Verify the text “Returning Customer”.
        String returnC = "Returning Customer";
       // Assert.assertEquals(returnC, getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]")));
    }

    @Test
    //RegisterPage
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Clickr on My Account Link
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        String register = getTextFromElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));
        selectMyAccountOptions(register, By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));
        //1.3 Verify the text “Register Account”.
        String reg = "Register Account";
        Assert.assertEquals(reg, getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]")));
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.org";
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        String reg = getTextFromElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));
        selectMyAccountOptions(reg, By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "mann");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "pate");
        //3.5 Enter Email
        //final String randomEmail = randomEmail();
        //driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(randomEmail);
         sendTextToElement(By.xpath("//input[@id='input-email']"), "mann123@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "01923 630 555");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "perfect1245");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "perfect1245");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String created = "Your Account Has Been Created!";
        Assert.assertEquals(created, getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")));
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        String log = getTextFromElement(By.xpath("//a[contains(text(),'Logout')]"));
        selectMyAccountOptions(log, By.xpath("//a[contains(text(),'Logout')]"));
        //3.16 Verify the text “Account Logout”
        String accountLog = "Account Logout";
        Assert.assertEquals(accountLog, getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]")));
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        String log = getTextFromElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        selectMyAccountOptions(log, By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "mann123@gmail.com");
        //4.4 Enter Last Name
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "perfect1245");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //4.7 Verify text “My Account”
        String myAcc = "My Account";
        Assert.assertEquals(myAcc, getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]")));
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        String out = getTextFromElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        selectMyAccountOptions(out, By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //4.10 Verify the text “Account Logout”
        String accLog = "Account Logout";
        Assert.assertEquals(accLog, getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]")));
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
