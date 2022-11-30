package laptopandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.UtilityTest;


public class LaptopsAndNotebooksTest extends UtilityTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        String hlOrder = "Price (High > Low)";
        Assert.assertEquals(hlOrder, getTextFromElement(By.xpath("//select[@id='input-sort']/option[contains(text(),'Price (High > Low)')]")));
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        //2.5 Verify the text “MacBook Pro”
        String proMac = "MacBook";
        Assert.assertEquals(proMac, getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]")));
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String vSuccess = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals(vSuccess, getTextFromElement(By.xpath("//div[contains(text(),'Success: You have added ')]")));
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        // String sCart="Shopping Cart  (0.00kg)";
        // Assert.assertEquals(sCart,getTextFromElement(By.xpath("//h1[contains(text(),' (0.00kg)')]")));
        //2.10 Verify the Product name "MacBook"
        String productN = "MacBook";
        Assert.assertEquals(productN, getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String messageS = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals(messageS, getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]")));
        //2.14 Verify the Total £737.45
        String total = "$1,204.00";
        Assert.assertEquals(total, getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        String text = "Checkout";
        Assert.assertEquals(text, getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']")));
        //2.17 Verify the Text “New Customer”
        String newC = "New Customer";
        Assert.assertEquals(newC, getTextFromElement(By.xpath("//h2[text()='New Customer']")));
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "manisha");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "pate");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "manish@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "02089049898");
        sendTextToElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[2]/input[1]"), "15 The");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "ha3 5at");
        clickOnElement(By.xpath("//select[@id='input-payment-country']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        clickOnElement(By.xpath("//select[@id='input-payment-zone']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='input-payment-zone']"), "Aberdeen");
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Not available then leave next door");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        String message = "Warning: No Payment options are available. Please contact us for assistance!";
        Assert.assertEquals(message, getTextFromElement(By.xpath("//div[@class='alert alert-warning alert-dismissible']")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
