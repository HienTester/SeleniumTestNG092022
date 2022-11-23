package hientester.com.Bai11_Asserttions;

import hientester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssertions extends BaseTest {
    @Test
    public void testSoftAssert(){
        driver.get("https://rise.fairsketch.com/signin");
        String headerSingInPage= driver.findElement(By.xpath("//div[@class='card-header text-center']//h2")).getText();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(headerSingInPage, "Sign in 123","Header Sign In page không đúng");
        System.out.println(headerSingInPage);

        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        WebElement menuClient = driver.findElement(By.xpath("//span[normalize-space()='Clients']"));
        softAssert.assertTrue(menuClient.isDisplayed(),"Menu Client không hiển thị");
        menuClient.click();

        WebElement headerTotalClient = driver.findElement(By.xpath("//span[normalize-space()='Total clients']"));
        softAssert.assertTrue(headerTotalClient.isEnabled(),"Header Total client không được bật");
        softAssert.assertEquals(headerTotalClient.getText(),"Selenium","Content of  Total client header not match");

        //Cuối cùng của SoftAssert là PHẢI DÙNG hàm assertAll() để xác nhận các soft assert  bên trên
        softAssert.assertAll();
    }
}
