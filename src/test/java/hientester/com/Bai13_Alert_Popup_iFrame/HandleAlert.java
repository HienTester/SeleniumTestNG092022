package hientester.com.Bai13_Alert_Popup_iFrame;

import hientester.com.common.BaseTest_OLD;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest_OLD {
    @Test
    public void TestAlert01() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("100056");
        driver.findElement(By.name("submit")).submit();
        Thread.sleep(1000);

        // Khai báo chuyển hướng đến Alert với đối tượng
        Alert alert = driver.switchTo().alert();

        // Get message trên alert
        String alertMessage = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(2000);

        // accept() = nhấn Ok button
        // driver.switchTo().alert().accept();
        alert.accept(); //Cách 2

        //Nhấn Cancel button (dismiss = cancel)
        //alert.dismiss();
        Thread.sleep(2000);

        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());

        Thread.sleep(2000);
    }

    @Test
    public void TestAlert02() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        //button[normalize-space()='click the button to demonstrate the prompt box']
        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        WebElement result = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("Anh Tester"),"Chưa điền được giá trị vào ô textbox");
        Thread.sleep(2000);
    }

}
