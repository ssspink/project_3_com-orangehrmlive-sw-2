package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest
{
        // Declare the driver
    public static WebDriver driver;


    public void OpenBrowser(String baseUrl)
    {
    //set The browser
    driver =new ChromeDriver();
    //Getting Url
    driver.get(baseUrl);
    //maximizing page
    driver.manage().window().maximize();
    }
}
