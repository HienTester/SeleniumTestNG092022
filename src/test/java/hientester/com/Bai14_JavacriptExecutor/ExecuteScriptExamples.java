package hientester.com.Bai14_JavacriptExecutor;

import hientester.com.WebUI;
import hientester.com.common.BaseTest_OLD;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExecuteScriptExamples extends BaseTest_OLD {

    @Test
    public void testScript01() {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");

        // C1: Click Object với Selenium
//      driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click(); //Tắt dấu nhân trước
//      driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")).click();

        // C2: Click Object với JavascriptExecitor
        JavascriptExecutor js = (JavascriptExecutor) driver; //Khai báo và khởi tạo giá trị cho đối tượng
        // js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")));
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        //Điền giá trị vào input
        //C1:
//        js.executeScript("document.getElementById('email').setAttribute('value','customer@example.com');");
//        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        //C2:
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);", driver.findElement(By.xpath("//input[@id='email']")), "customer@example.com");
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);", driver.findElement(By.xpath("//input[@id='password']")), "123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.sleep(2);

        //Cuộn chuột tới phần tử trong trang
        WebElement buttonUpgradePackage = driver.findElement(By.xpath("//a[normalize-space()='Upgrade Package']"));
        js.executeScript("arguments[0].scrollIntoView(true);", buttonUpgradePackage);
        WebUI.sleep(2);
    }

    @Test
    public void testScript02() throws IOException {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");

        //Khai báo và khởi tạo giá trị cho đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        //tạo Alert trong Selenium Webdriver
        //js.executeScript("alert('Welcome To Anh Tester - Automation Testing');");

        // Lấy Chiều cao và Chiều rộng của một trang web
        System.out.println(js.executeScript("return window.innerHeight;").toString());
        System.out.println(js.executeScript("return window.innerWidth;").toString());


        //Highlight phần tử trên web
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")));
        js.executeScript("arguments[0].style.border='3px solid blue'", driver.findElement(By.xpath("//input[@id='email']")));
        WebUI.sleep(2);

        //Bài 30 moi học
        // Tạo tham chiếu của TakesScreenshot với driver hiện tại
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Gọi hàm capture screenshot - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
       //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
        File theDir = new File("./Screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình luôn
        try {
            FileHandler.copy(source, new File("./Screenshots/screenshot.png"));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot taken");
        WebUI.sleep(2);

    }
}
