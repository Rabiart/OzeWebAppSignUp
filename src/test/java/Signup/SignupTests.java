package Signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignupTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp () throws InterruptedException {
        //import chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get ("https://app.oze.guru/register");
        //wait for 5 seconds
        Thread.sleep(5000);
        //maximize the window
        driver.manage ().window ().maximize ();
        System.out.println (driver.getTitle ());
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
    }

    @Test
    public void VerifyURL(){
        //verify Register Url
        if (driver.getCurrentUrl ().contains ("https://app.oze.guru/register"))
            //Pass
            System.out.println ("The Page URL passed");
        else
            //Fail
            System.out.println ("The Page URL did not pass");
    }

    @Test(priority = 1)
    public void RegisterPage(){
    driver.findElement(By.xpath("//*[@id=\"registerform\"]/div[1]/div[2]/input")).sendKeys("8121243914");
    driver.findElement(By.xpath("//*[@id=\"registerform\"]/div[2]/div/input")).sendKeys("rabiartoge@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Olayemi@21");
    driver.findElement(By.xpath("//*[@id=\"password-confirm\"]")).sendKeys("Olayemi@21");
    driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div/form/div[5]/button")).click();
    driver.findElement(By.xpath("//*[@id=\"acceptConditionDiv\"]/label")).click();
    driver.findElement(By.xpath("//html/body/section/div/div[2]/div[1]/div/div/form/div[7]/div/div/button")).click();
    }
    @AfterClass
    public void tearDown() {
        driver.quit ();
    }
}
