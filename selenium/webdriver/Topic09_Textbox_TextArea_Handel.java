
package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic09_Textbox_TextArea_Handel {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {

    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}