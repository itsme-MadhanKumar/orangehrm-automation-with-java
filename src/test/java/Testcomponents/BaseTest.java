package Testcomponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.pageobjectmodel.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class BaseTest
{
    public WebDriver driver;
    ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public LoginPage loginPage;


    public WebDriver getDriver()
    {
        return tlDriver.get();
    }
    public WebDriver initialize() throws IOException
    {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");
        properties.load(inputStream);
        String browser = System.getProperty("browser") != null
                ? System.getProperty("browser")
                : properties.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LoginPage launchApplication() throws IOException
    {
        driver = initialize();
        tlDriver.set(driver);
        loginPage = new LoginPage(driver);
        loginPage.load_url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        return loginPage;
    }
}
