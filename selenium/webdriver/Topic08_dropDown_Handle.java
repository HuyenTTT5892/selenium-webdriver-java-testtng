
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic08_dropDown_Handle {
    WebDriver driver;
    String firstName="John", lastName="Wick", password="123456789", companyName ="AutomationFC", emailAddress = getEmailAdress();
    String day ="1", month ="May", year ="1980";
    @BeforeClass
    public void beforeClass() {

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/");

        //input data
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        sleepInSeconds(3);
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
        //dropdown
        Select day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        Assert.assertFalse(day.isMultiple());
        Assert.assertFalse(month.isMultiple());
        Assert.assertFalse(year.isMultiple());
        Assert.assertEquals(day.getOptions().size(), 32);
        Assert.assertEquals(month.getOptions().size(),13);
        Assert.assertEquals(year.getOptions().size(),112);
        day.selectByVisibleText(this.day);
        month.selectByVisibleText(this.month);
        year.selectByVisibleText(this.year);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        sleepInSeconds(3);

        //verify register
        Assert.assertEquals(driver.findElement(By.className("result")).getText(),"Your registration completed");

        //verify nhập ngay/thang/nam đúng

        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),this.day);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),this.month);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),this.year);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"),emailAddress);

    }

    @Test
    public void TC_02_login() {
    driver.get("");
    }

    public void sleepInSeconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond * 1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAdress(){
        Random rand = new Random();
        return "automation" + rand.nextInt(99999)+ "@gmail.com";
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}