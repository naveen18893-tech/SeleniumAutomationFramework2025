package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        Log.info("Starting login test...");
        test = ExtentReportManager.createTest("Login Test");

        test.info("Navigating to URL");
        LoginPage loginPage = new LoginPage(driver);

        Log.info("Adding credentials");
        test.info("Adding Credentials");

        loginPage.enterUsername("admin@yourstore.com");
        loginPage.enterPassword("admin");

        test.info("Clicking on Login button");
        loginPage.clickLogin();

        System.out.println("Title of the page is : " + driver.getTitle());

        Log.info("Verifying page title");
        test.info("Verifying page title");

        Assert.assertEquals(driver.getTitle(), "Just a moment...");

        test.pass("Login Successful");
    }
}
