package hientester.com.Bai16_ThucHanhAutoTestCRM;

import hientester.com.WebUI;
import hientester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithoutEmailAndPassword () {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify 2 message Email and Password required hiển thị
        //Verify 2 message hiển thị đúng câu từ

        SoftAssert softAssert = new SoftAssert();

        //Viết hàm kiểm tra Element tồn tại trong DOM
        boolean emailRequired = WebUI.checkElementExist(driver, "//form/div[1]");// Message Email required
        boolean passwordRequired = WebUI.checkElementExist(driver, "//form/div[2]");// Message Pass required
        System.out.println(emailRequired);
        System.out.println(passwordRequired);
        softAssert.assertTrue(emailRequired,"Message Email required no exist.");
        softAssert.assertTrue(passwordRequired,"Message Password required no exist.");


        //Viết hàm kiểm tra Element hiển thị trên UI
        boolean messageEmailVisible = driver.findElement(By.xpath("//form/div[1]")).isEnabled();// Message Email enable
        boolean messagePassVisible = driver.findElement(By.xpath("//form/div[2]")).isEnabled();// Message Pass enable
        System.out.println(messagePassVisible);
        System.out.println(messagePassVisible);
        softAssert.assertTrue(messageEmailVisible,"Message Email no displays");
        softAssert.assertTrue(messagePassVisible,"Message Password no displays");

        //Kiểm tra text của message
        String textFormessageEmailrequired = driver.findElement(By.xpath("//form/div[1]")).getText();// get text Email required
        String textFormessagePassrequired = driver.findElement(By.xpath("//form/div[2]")).getText();// get text Password required
        System.out.println(textFormessageEmailrequired);
        System.out.println(textFormessagePassrequired);
        softAssert.assertEquals(textFormessageEmailrequired,"The Password field is required.","text chưa đúng");
        softAssert.assertEquals(textFormessagePassrequired,"The Email Address field is required.","text chưa đúng");

        softAssert.assertAll();

    }
}
