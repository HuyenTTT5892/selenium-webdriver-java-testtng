
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic10_Custo_Dropdown_Handle {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Jquery() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInDropDown("//span[@id='speed-button']","//ul[@id='speed-menu']//div","Medium");
        selectItemInDropDown("//span[@id='files-button']","//ul[@id='files-menu']//div","ui.jQuery.js");
        selectItemInDropDown("//span[@id='number-button']","//ul[@id='number-menu']//div","17");
        selectItemInDropDown("//span[@id='salutation-button']","//ul[@id='salutation-menu']//div","Mrs.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),"Medium");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='files-button']//span[@class='ui-selectmenu-text']")).getText(),"ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(),"17");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']//span[@class='ui-selectmenu-text']")).getText(),"Mrs.");
    }

    @Test
    public void TC_02_ReactJS() {
    driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
    sleepInSeconds(3);
    selectItemInDropDown("//div//i[@class='dropdown icon']","//div//span[@class='text']","Jenny Hess");
    sleepInSeconds(3);
    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Jenny Hess");
        selectItemInDropDown("//div//i[@class='dropdown icon']","//div//span[@class='text']","Elliot Fu");
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Elliot Fu");
    }

    @Test
    public void TC_03_VueJS() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropDown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//a","First Option");
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"First Option");
        selectItemInDropDown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//a","Second Option");
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Second Option");
    }
    @Test
    public void TC_04_Editable(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditDropDown("//input[@class='search']","//div[contains(@class,'item')]//span","Bahrain");
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Bahrain");
        selectItemInEditDropDown("//input[@class='search']","//div[contains(@class,'item')]//span","American Samoa");
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"American Samoa");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    public void sleepInSeconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond * 1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectItemInDropDown(String parentsXpath, String childXpath, String itemTextExpected ){

    driver.findElement(By.xpath(parentsXpath)).click();
    List<WebElement> allItems = explicitWait.until(ExpectedConditions.
            presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
    for(WebElement item : allItems){
        if(item.getText().equals(itemTextExpected)){
            item.click();
            break;
        }
    }
}
    public void selectItemInEditDropDown(String parentsXpath, String childXpath, String itemTextExpected ) {
        driver.findElement(By.xpath(parentsXpath)).clear();
        driver.findElement(By.xpath(parentsXpath)).sendKeys(itemTextExpected);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}