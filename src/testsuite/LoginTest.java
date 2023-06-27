package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {       //Storing url
    String baseUrl = "http://the-internet.herokuapp.com/login";

    //Running @Before Annotation before test
    @Before
    public void setUp() {
        OpenBrowser(baseUrl); //Open Browser Setup
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Locating element by locators and entering the value into Username field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Locating element by locators and entering the value into password filed
       driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       //clicking on sign in button
         driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Expected Result
         String expectedResult ="Secure Area";
         //actual result
         String actualResult =driver.findElement(By.xpath("//div[@id='content']/div/h2")).getText();
        Assert.assertEquals("The Expected and ActualResult",expectedResult,actualResult);
    }
        @Test
        public void verifyTheUsernameErrorMessage()
        {
            //Locating element by locators and entering the value into Username field
            driver.findElement(By.id("username")).sendKeys("tomsmith1");
            //Locating element by locators and entering the value into password filed
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            //clicking on sign in button
            driver.findElement(By.xpath("//button[@class='radius']")).click();
          //Expected Error message
           String expectedErrorMessage =  "Your username is invalid!";
          String actualErrorMessage = driver.findElement(By.xpath("//div[@id=\"flash\"]")).getText();
           //Using Assert to compare the result
           Assert.assertEquals(expectedErrorMessage,expectedErrorMessage);

        }

        @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {
            //Locating element by locators and entering the value into Username field
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            //Locating element by locators and entering the value into password filed
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
            //clicking on sign in button
            driver.findElement(By.xpath("//button[@class='radius']")).click();
            //Expected Error Message for Wrong password
            String expectedMessageForWrongPassword = "Your password is invalid!";
            //Actual ErrorMessage
            String actualMessageForWrongPassword =driver.findElement(By.xpath("//div[@id='flash']")).getText();
            //Using Assert to compare Expected and Actual Message
            Assert.assertEquals(expectedMessageForWrongPassword,actualMessageForWrongPassword);

            Thread.sleep(5000);
        }
            @After
            public void tearDown(){

            }


}
