package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UtilityTest;

import java.util.List;

public class DeskTopsTest extends UtilityTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        String desOrder = "Name (Z - A)";
        Assert.assertEquals(desOrder, getTextFromElement(By.xpath("//select[@id='input-sort' ]/option[contains(text(),'Name (Z - A)')]")));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        String Hp = "HP LP3065";
        Assert.assertEquals(Hp, getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));
        while (true) {
            String mothYear = driver.findElement(By.xpath("//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[2]")).getText();
            System.out.println(mothYear);
            String arr[] = mothYear.split(" ");
            //Actual Dates Nov 2022
            String month1 = arr[0];
            String year1 = arr[1];
            if (year1.equalsIgnoreCase(year) && month1.equalsIgnoreCase(month)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[3]"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        //List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker-days']//div//table//td"));
        for (WebElement date1 : allDates) {
            if (date1.getText().equalsIgnoreCase(date)) {
                date1.click();
                break;
            }
        }
        //2.7.Enter Qty "1” using Select class.
        mouseHoverToElement(By.xpath("//input[@id='input-quantity']"));
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "2");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String exMessage = "Success: You have added HP LP3065 to your shopping cart!" + "×";
        Assert.assertEquals(exMessage, getTextFromElement(By.xpath("//div[contains(text(),'Success: You have added ')]")));
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.11 Verify the text "Shopping Cart"
        String text = "Shopping Cart  (2.00kg)";
        Assert.assertEquals(text, getTextFromElement(By.xpath("//h1[contains(text(),' (2.00kg)')]")));
        //2.12 Verify the Product name "HP LP3065"
        String product = "HP LP3065";
        Assert.assertEquals(product, getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
        //2.13 Verify the Delivery Date "2022-11-30"
        String date1 = "Delivery Date: 2022-11-30";
        Assert.assertEquals(date1, getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]")));
        //2.14 Verify the Model "Product21"
        String model = "Product 21";
        Assert.assertEquals(model, getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]")));
        //2.15 Verify the Todat "£74.73"
        String total = "$244.00";
        Assert.assertEquals(total, getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));
    }

    @After
    public void tearDown() {
        //closeBrowser();}
    }


}
