package org.example.pim;

import org.openqa.selenium.By;
import org.pageobjectmodel.PimPage;
import org.testng.annotations.Test;
import utilities.CredentialsReader;
import utilities.Reuseclass;

public class EditdetailsofEmployee extends Reuseclass
{
    public String emp_id = "14577";
    PimPage pimPage;
    @Test(dependsOnMethods = "employeeCanLogin")
    public void editEmployee() throws InterruptedException
    {
        loginAsAdmin(CredentialsReader.get("admin.username"), CredentialsReader.get("admin.password"));
        pimPage = landingPage.clickPim();
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys();
    }
}
