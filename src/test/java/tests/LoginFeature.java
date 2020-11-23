package tests;

import org.testng.annotations.Test;

//import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LoginFeature {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;

	@Parameters({"user", "pass"})
  @Test(priority=1, description="Login failed", groups= {"Sanity, Regression"})
  public void verifyFailedLogin(String a, String b) {
	  lp.loginToApplication(a, b);
	  //dp.isWelcomeMegDisplayed();
	  Reporter.log(TestUtility.addScreenToReport());
	  assertFalse(dp.isWelcomeMegDisplayed());
  }
@Test(priority=3,description="Login Success", groups="Sanity")
  public void verifySuccessFulLogin() {
	  lp.loginToApplication("Admin", "admin123");
	  //dp.isWelcomeMegDisplayed();
	  Reporter.log(TestUtility.addScreenToReport());
	  assertTrue(dp.isWelcomeMegDisplayed());
  }
  @Test(priority=2,description="forgot password link", groups="Regression")
  public void verifyForgotPasswordLink() {
	  lp.clickOnForgotPassword();
	  assertFalse(true);
	  Reporter.log(TestUtility.addScreenToReport());
	  Assert.fail("Delibrate");
	  
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException 
  {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  Reporter.log(TestUtility.addScreenToReport());
	  dr.quit();
  }

	/*
	 * @BeforeClass public void beforeClass() { }
	 * 
	 * @AfterClass public void afterClass() { }
	 */



}
