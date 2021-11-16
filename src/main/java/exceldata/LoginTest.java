package exceldata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdricer.chrome.driver","/Users/apple/Desktop/selenium jars/chromedriver");
        driver= new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.in/");
    }


    @DataProvider
    public Object[][] getLoginData() throws IOException {
       Object data[][]=  TestUtil.getTestData("loginsheet");
return data;
    }
   @Test
  public void loginTest(String username, String password)
   {
       driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
       driver.findElement(By.id("ap_email")).sendKeys(username);
       driver.findElement(By.id("continue")).click();
       driver.findElement(By.id("ap_password")).sendKeys(password);
       driver.findElement(By.id("signInSubmit")).click();
       driver.getTitle();

   }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
