package hientester.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
        public WebDriver driver;

        @BeforeMethod
        public void createBrowswe(){
            System.out.println("Start Chrome Browser from BaseTest");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            //Chờ đợi trang load xong (TH cụ thể là 30s)
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }
        @AfterMethod
        public void closeBrowser(){
            System.out.println("Close Browser");
            driver.quit();
        }
}
