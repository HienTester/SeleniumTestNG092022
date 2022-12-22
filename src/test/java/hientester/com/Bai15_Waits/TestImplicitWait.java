package hientester.com.Bai15_Waits;

import hientester.com.WebUI;
import hientester.com.common.BaseTest;
import hientester.com.common.BaseTest_OLD;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestImplicitWait extends BaseTest {

    @Test
    public void loginHRM(){
        //Chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với thời gian cụ thể ví dụ như TH này là 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();
        WebUI.sleep(2);



    }
}
