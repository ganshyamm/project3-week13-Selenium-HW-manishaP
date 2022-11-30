package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UtilityTest;

import java.util.List;

public class TopMenuTest extends UtilityTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    public void selectMenu(String option, By by) {
        List<WebElement> options = driver.findElements(by);
        for (WebElement name : options) {
            if (name.getText().equalsIgnoreCase(option)) {
                name.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        String s = getTextFromElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        selectMenu(s, By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Verify the text ‘Desktops’
        String desk = "Desktops";
        Assert.assertEquals(desk, getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]")));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        String select = getTextFromElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        selectMenu(select, By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Verify the text ‘Laptops & Notebooks’
        String text = "Laptops & Notebooks";
        Assert.assertEquals(text, getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]")));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        String select = getTextFromElement(By.xpath("//a[contains(text(),'Show All Components')]"));
        selectMenu(select, By.xpath("//a[contains(text(),'Show All Components')]"));
        //3.3 Verify the text ‘Components’
        String text = "Components";
        Assert.assertEquals(text, getTextFromElement(By.xpath("//h2[contains(text(),'Components')]")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
