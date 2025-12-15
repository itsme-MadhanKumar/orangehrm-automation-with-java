package org.example.pim;
import org.pageobjectmodel.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CredentialsReader;
import utilities.Reuseclass;
import utilities.random.Randomnumber;
public class AddEmployeeTest extends  Reuseclass
{
    String e_username ;
    String e_password = "Maddy@123";
    PimPage pimPage;

    @Test
    public void adminCreatesEmployee() throws InterruptedException
    {

        loginAsAdmin(CredentialsReader.get("admin.username"), CredentialsReader.get("admin.password"));
        pimPage = landingPage.clickPim();
        pimPage.addEmployeeBtn();

        e_username = Randomnumber.getEmployeeId();
        String employeeId = Randomnumber.getEmployeeId();

        String f_name = "Maddy";
        String m_name = "Kumar";
        String l_name = "B";
        pimPage.entername(f_name, m_name,l_name, employeeId);
        System.out.println("Employee id : "+employeeId);
        pimPage.enterEmpUsername(e_username);

        Assert.assertTrue(
                pimPage.getLoginAccess().isDisplayed(),
                "Login access checkbox not enabled"
        );

        pimPage.enterEmpPassword(e_password, e_password);

        Assert.assertTrue(
                pimPage.getSuccessStatus().isDisplayed(),
                "Employee creation success message not shown"
        );

        landingPage.setLogout_btn();
    }

    @Test(dependsOnMethods = "adminCreatesEmployee")
    public void employeeCanLogin() throws InterruptedException
    {

        loginAsEmployee(e_username, e_password);
//        landingPage = loginPage.setClicklogin();
        landingPage.setLogout_btn();
    }
}

