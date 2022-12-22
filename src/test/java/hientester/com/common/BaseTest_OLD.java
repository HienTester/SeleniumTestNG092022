package hientester.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest_OLD {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowswe(){
        System.out.println("Start Chrome Browser from BaseTest_OLD");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với thời gian cụ thể ví dụ như TH này là 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Chờ đợi trang load xong (TH cụ thể là 30s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close Browser");
        driver.quit();
    }
}
