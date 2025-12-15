package utilities;

import Testcomponents.BaseTest;
import org.pageobjectmodel.LandingPage;
import org.testng.annotations.AfterMethod;

public class Reuseclass extends BaseTest
{
    public LandingPage landingPage;
    protected void loginAsAdmin(String username,String passowrd) throws InterruptedException
    {
        loginPage.login(username, passowrd);
        landingPage = loginPage.setClicklogin();
    }

    protected void loginAsEmployee(String username, String password) throws InterruptedException
    {
        loginPage.login(username, password);
        landingPage = loginPage.setClicklogin();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
