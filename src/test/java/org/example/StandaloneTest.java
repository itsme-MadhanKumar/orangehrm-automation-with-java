package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Random;
public class StandaloneTest
{
    public static String getEmployeeId()
    {
        Random obj = new Random();
        return String.valueOf(obj.nextInt(90000)+10000);
    }
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String username = "Admin";
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys(username);
        String passowrd = "admin123";
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passowrd);
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        Thread.sleep(3000L);
        driver.findElement(By.xpath("//a[contains(@class,'oxd-main-menu-item')]/span[.='PIM']")).click();
        Thread.sleep(3000L);
        driver.findElement(By.cssSelector("button[class$='oxd-button--secondary']")).click();
        String f_name ="Madhan";
        String m_name ="kumar";
        String l_name= "B";
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(f_name);
        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(m_name);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(l_name);
        String employeeId = getEmployeeId();
        driver.findElement(By.xpath("//label[.='Employee Id']/following::input[1]")).sendKeys(employeeId);
        driver.findElement(By.xpath("//div[@class='oxd-form-row user-form-header']//following::div[@class='oxd-switch-wrapper'][1]")).click();
        Thread.sleep(2000L);
        String e_username ="maddy09";
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(e_username);
        WebElement enable_btn = driver.findElement(By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]"));
        Assert.assertTrue(enable_btn.isDisplayed(),"Enable is not enabled");
        String e_password = "maddy@123";
        Thread.sleep(2000L);
        WebElement password_field = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(password_field));
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(e_password);
        WebElement confirm_password =  driver.findElement(By.xpath("(//input[@type='password'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(confirm_password));
        Assert.assertTrue(confirm_password.isDisplayed(),"not available confirm password field");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(e_password);
        driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary')]")).click();
        WebElement successMsg = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//p[@class='oxd-text--toast-message']")
                )
        );
        Assert.assertTrue(successMsg.isDisplayed(),"Success message NOT displayed!");
    }

}
