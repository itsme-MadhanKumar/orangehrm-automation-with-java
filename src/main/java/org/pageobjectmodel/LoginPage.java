package org.pageobjectmodel;
import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends AbstractComponents
{
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement clicklogin;

    @FindBy(xpath ="//input[@placeholder='Username']" )
    WebElement u_name;

    @FindBy(xpath ="//input[@name='password']" )
    WebElement pass;

    public void login(String username,String passowrd) throws InterruptedException
    {

        u_name.sendKeys(username);
        pass.sendKeys(passowrd);
    }

    public LandingPage setClicklogin()
    {
        clicklogin.click();
        return new LandingPage(driver);
    }
    public void load_url(String url)
    {
        driver.get(url);
    }
}
