package hientester.com.Bai16_ThucHanhAutoTestCRM;

import hientester.com.WebUI;
import hientester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManageCustomers extends BaseTest {

    private  String customerName = "Nissan Techno";
    private  String website = "http://nissantechno.com.vn/";

    @BeforeMethod
    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebUI.waitForPageLoaded(driver);
    }

    @Test
    public void addCustomer(){
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        //Add thêm Customer new
        driver.findElement(By.xpath("//a[@class='btn btn-primary mright5 test pull-left display-block']")).click();
        WebUI.sleep(2);
        //Thêm mới 1 Customer (Client)
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(customerName);
        driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@id='website']")).sendKeys(website);
        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        WebUI.waitForPageLoaded(driver);

      //Search lại customer và verify
        //Click mở trang customer lại
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        WebUI.waitForPageLoaded(driver);
        //Search tên customer vừa add
        driver.findElement(By.xpath("//div[@id='DataTables_Table_0_wrapper']//input[@type='search']")).sendKeys(customerName, Keys.ENTER);
        WebUI.sleep(2);
        //Get text cột customer name
        driver.findElement(By.xpath("//th[@id='th-number']")).click();
        driver.findElement(By.xpath("//th[@id='th-number']")).click();
        driver.findElement(By.xpath("//tbody//tr[1]//td[3]//a[normalize-space()='Nissan Techno']")).click();
        WebUI.waitForPageLoaded(driver);
        String getCustomerNameInDetail = driver.findElement(By.xpath("//input[@id='company']")).getAttribute("value");
        System.out.println("Customer Name in Detail: " + getCustomerNameInDetail);
        Assert.assertEquals(getCustomerNameInDetail,customerName,"Failed, Customer Name not match");
        WebUI.sleep(3);

//        //Verify field Phone
//        driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("00110011");
//        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
//        WebUI.waitForPageLoaded(driver);
//
//       //Open Projects để verify lại Customer vừa add
//        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
//        WebUI.sleep(3);
//        driver.findElement(By.xpath("//a[@class='btn btn-primary pull-left display-block mright5']")).click();
//       //input value for field Project Name
//        driver.findElement(By.xpath("//label[@for='name']")).sendKeys("New Navara");

    }

}

