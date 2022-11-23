package hientester.com.Bai11_Asserttions;

import hientester.com.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssertions extends BaseTest {

    @Test(priority = 1)
    public void TestAssertEquals() {

        driver.get("https://anhtester.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester - Automation";

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle,"Tiêu để trang chưa đúng");
        //message: là dành cho mô tả TH sai thì mới show ra, còn đúng thì không show ra

        System.out.println("Hello Automation class");
    }

    @Test(priority = 2)
    public void TestAssertTrue() {

        driver.get("https://anhtester.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester 123";


        System.out.println("*** Checking For The Title ***");

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Tiêu đề không chứa " + expectedTitle);

        System.out.println(actualTitle);
    }
}
