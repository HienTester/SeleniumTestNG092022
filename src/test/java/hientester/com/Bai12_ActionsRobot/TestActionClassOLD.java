package hientester.com.Bai12_ActionsRobot;

import hientester.com.common.BaseTest_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionClassOLD extends BaseTest_OLD {

        @Test
        public void TestSendKeys() throws InterruptedException {

            driver.get("https://www.google.com/");

            WebElement element = driver.findElement(By.xpath("//input[@name='q']")); // xpath ô search của google

            // Tạo đối tượng của Actions class và để driver vào
            Actions action = new Actions(driver);

            // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
            action.sendKeys(element, "SeleniumJava").sendKeys(Keys.ENTER).build().perform();
            //Dùng hàm build mục đích để liên kết 2 hàm sendKeys lại với nhau, còn nếu chỉ dùng 1 hàm sendKeys thì có thể bỏ hàm build đi

            //Lấy xpath của kết quả được hiển thị đầu tiên sau khi gõ tìm kiếm trong Google" SeleniumJava"
            WebElement titleResult = driver.findElement(By.xpath("//h3[contains(text(),'[Selenium Java] Bài 4: Cài đặt môi trường Selenium với Java')]"));
            action.click(titleResult).perform();//Click vào 1 element cụ thể
            Thread.sleep(2000);
        }

    @Test
    public void TestdoubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);

        //Element của Header page
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));
        Actions action = new Actions(driver);
        //Click chuột trái 2 lần vào header page
        action.doubleClick(element).perform(); // chỉ có 1 hàm nên bỏ build cũng được
        Thread.sleep(2000);
    }

    @Test
    public void TestcontextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));
        Actions action = new Actions(driver);

        //Click chuột phải vào element trên website
        action.contextClick(element).perform(); // chỉ có 1 hàm nên bỏ build cũng được
        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);

        //Bắt 1 element bị khuất màn hình
        WebElement element1 = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));
        Actions action = new Actions(driver);

        //Move to element (di chuyển trỏ chuột tới element)
        action.moveToElement(element1).perform();
        Thread.sleep(2000);

        //Bắt 1 element khác bị khuất màn hình
        WebElement element2 = driver.findElement(By.xpath("//a[normalize-space()='Tất Cả Khóa Học']"));
        action.moveToElement(element2).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(2000);

        // Element which needs to drag.
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));

        // Element on which need to drop.
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(driver);

        // Gọi hàm dragAndDrop giữa Element From và To
        action.dragAndDrop(From, To).release().perform();
        Thread.sleep(1000);

        // Drag and Drop by Pixel. (Đè chuột kéo và Di chuyển trỏ chuột đến tọa độ xong thả ra)
        WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
        action.dragAndDropBy(from_5000, 168, 40).build().perform(); //di chuyển đến 1 tọa độ
        Thread.sleep(2000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chuyển đổi chữ thường thành Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh").keyUp(Keys.SHIFT).sendKeys(" tester").build().perform();
        // Đè phím keyDown giữ SHIFT để nhập text " ANH" ( thành chữ hoa). Sau đó, nhả phím keyUp giữ SHIFT để nhập text "tester" (chữ thường)

        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);
        Thread.sleep(1000);

        // Scroll down cuối trang
        action.keyDown(Keys.CONTROL).keyDown(Keys.END).build().perform();
        Thread.sleep(2000);

        // Scroll up đầu trang
        action.keyDown(Keys.CONTROL).keyDown(Keys.HOME).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);
        Thread.sleep(1000);

        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);

        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);

        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);

        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);

        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

}

