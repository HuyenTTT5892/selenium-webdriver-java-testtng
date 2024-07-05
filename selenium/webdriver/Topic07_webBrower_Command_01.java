
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic07_webBrower_Command_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Verify_Url() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_Verify_Title() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_03_Navigate_Function() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/customer/account/create/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_04_Get_Page_Source_Code() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
        }


    @Test
    public void TC_05_Is_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);
        //Kiểm tra các phần tử hiển thị trên trang
        //Kiểm tra email
        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());
        if (driver.findElement(By.xpath("//Input[@id='mail']")).isDisplayed()) {
            driver.findElement(By.xpath("//Input[@id='mail']")).sendKeys("Automation Testing");
            System.out.println("Email texbox is displayed");
        }
        else{
            System.out.println(" Email texbox is not displayed");
        }
        //Kiểm tra educaiton
        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed()) {
            driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
            System.out.println("Education textarea is displayed");
        }
        else{
            System.out.println(" Education textarea is not displayed");
        }
        // Kiểm tra age
        if (driver.findElement(By.xpath("//Input[@id='under_18']")).isDisplayed()) {
            driver.findElement(By.xpath("//Input[@id='under_18']")).click();
            System.out.println("Under_18 is displayed");
        }
        else{
            System.out.println(" Under_18 is not displayed");
        }
        //Kiểm tra name
        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name: User5 is displayed");
        }
        else{
            System.out.println(" Name: User5 is not displayed");
        }
    }

    @Test
    public void TC_05_IsEnabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);
        if (driver.findElement(By.xpath("//Input[@id='mail']")).isEnabled()) {
            System.out.println("Email texbox is enabled");
        }
        else{
            System.out.println(" Email texbox is disabled");
        }

        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled()) {
            System.out.println("Education textarea is enabled");
        }
        else{
            System.out.println(" Education textarea is not disabled");
        }

        if (driver.findElement(By.xpath("//Input[@id='under_18']")).isEnabled()) {
            System.out.println("Under_18 is enabled");
        }
        else{
            System.out.println(" Under_18 is disabled");
        }

        if (driver.findElement(By.xpath("//div//select[@id='job1']")).isEnabled()) {
            System.out.println("job1 single dropdown is enabled");
        }
        else{
            System.out.println(" job1 single dropdown is disabled");
        }
        if(driver.findElement(By.xpath("//div//input[@id='development']")).isEnabled()) {
            System.out.println("development is enabled");
        }
        else {
                System.out.println("development is disabled");
            }

        if(driver.findElement(By.xpath("//div//input[@id='slider-1']")).isEnabled()) {
            System.out.println("slider-1 is enabled");
        }
            else{
                System.out.println("slider-1 is disabled");
            }
        if(driver.findElement(By.xpath("//div//input[@id='disable_password']")).isEnabled()) {
            System.out.println("disable_password is enabled");
        }
        else{
            System.out.println("disable_password is disabled");
        }
        if(driver.findElement(By.xpath("//div//input[@id='radio-disabled']")).isEnabled()) {
            System.out.println("radio-disabled is enabled");
        }
        else{
            System.out.println("radio-disable is disabled");
        }
        if( driver.findElement(By.xpath("//div//textarea[@id='bio']")).isEnabled()) {
            System.out.println("bio is enabled");
        }
        else{
            System.out.println("bio is disabled");
        }
        if( driver.findElement(By.xpath("//div//select[@id='job3']")).isEnabled()) {
            System.out.println("Job3 is enabled");
        }
        else{
            System.out.println("Job3 is disabled");
        }
        if(driver.findElement(By.xpath("//div//input[@id='check-disbaled']")).isEnabled()) {
            System.out.println("check-disabled is enabled");
        }
        else{
            System.out.println("check-disabled is disabled");
        }
        if(driver.findElement(By.xpath("//div//input[@id='slider-2']")).isEnabled()) {
            System.out.println("slider-2 is enabled");
        }
        else{
            System.out.println("slider-2 is disabled");
        }
        }


    @Test
    public void TC_06_Is_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//Input[@id='under_18']")).click();
        driver.findElement(By.xpath("//div//input[@id='java']")).click();
        sleepInSeconds(3);
        Assert.assertTrue(driver.findElement(By.xpath("//Input[@id='under_18']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//div//input[@id='java']")).isSelected());
        driver.findElement(By.xpath("//div//input[@id='java']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//div//input[@id='java']")).isSelected());
        }


    @Test
    public void TC_07_Mail_Chimp() {
    driver.get("https://login.mailchimp.com/signup/");
    driver.findElement(By.xpath("//div//input[@id='email']")).sendKeys("huyenptit5892@gmail.com");
    //Number
    driver.findElement(By.xpath("//div//input[@id='new_password']")).sendKeys("3456");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
    //lowerCase
        driver.findElement(By.xpath("//div//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//div//input[@id='new_password']")).sendKeys("abcdf");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
        //UpperCase
        driver.findElement(By.xpath("//div//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//div//input[@id='new_password']")).sendKeys("ABCDE");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
        //Special character
        driver.findElement(By.xpath("//div//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//div//input[@id='new_password']")).sendKeys("!@#$%^");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
        // > 8 character
        driver.findElement(By.xpath("//div//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//div//input[@id='new_password']")).sendKeys("123Hdfvfsss");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
        // valid
        driver.findElement(By.xpath("//div//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//div//input[@id='new_password']")).sendKeys("123Hd@tr");
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
    }

    @Test
    public void TC_08_Login_empty_Email_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
    }
    @Test
    public void TC_09_Login_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }
    @Test
    public void TC_10_Invalid_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }
    @Test
    public void TC_11_Incorrect_Email_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");
    }
    @Test
    public void TC_12_success_Login() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(2);

        String firstName ="Automation", lastName="FC", emailAddress = getEmailAdress(), password ="123456789";
        String fullName = firstName + " " + lastName;

        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='hello']/strong")).getText(),"Hello, " + fullName+"!");
        //verify Account
        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        //LogOut
        driver.findElement(By.xpath("//div[@class='skip-links']//span[text()='Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//li[@class=' last']/a[@title='Log Out']")).click();

        //Login
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='hello']/strong")).getText(),"Hello, " + fullName+"!");
        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        //chuyển tab " Mobile
        driver.findElement(By.xpath("//div[@class='page-header-container']//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[@class='product-image' and @title='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//div[@class='ratings']//a[text()='Add Your Review']")).click();
        sleepInSeconds(3);
        //input valua
        driver.findElement(By.xpath("//input[@id='Quality 1_5']")).click();
        driver.findElement(By.xpath("//textarea[@id='review_field']")).sendKeys("Good application"+"\n"+"Pretty easy to navigate");
        driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("Best Phone");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();
        sleepInSeconds(3);
        //verify
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Your review has been accepted for moderation.");
        //log out
        driver.findElement(By.xpath("//div[@class='skip-links']//span[text()='Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//li[@class=' last']/a[@title='Log Out']")).click();
        //verify navigate về home page




    }
    @Test
    public void TC_13_Run_Safari() {

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