package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class DashboardFeature {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
  @Test(priority=1, description="Welcome Message", groups= {"Sanity, Regression"})
  public void verifyWelcomeMsg() {
	  String str=dp.getWelcomeText();
	  //assertEquals("Welcome", str);
	  Reporter.log(TestUtility.addScreenToReport());
	  assertTrue(str.contains("Welcome"));
	  
  }
  
  @Test(priority=1, description="Fieldset List", enabled=true, groups= "Regression")
  public void verifyFieldSetList() {
	  List<String> str = dp.getFieldSet();
	  String[] arr= {"Quick Launch","Employee Distribution by Subunit","Legend", "Pending Leave Requests"};
	  int i=0;
	  Reporter.log(TestUtility.addScreenToReport());
	  for(String s:str)
	  {
		  assertEquals(arr[i], s.trim());
		  i++;
	  }
  }
  @Test(priority=1, description="Fieldset Count", enabled=true, dependsOnMethods="verifyFieldSetList")
  public void verifyFieldSetCount() {
	  Reporter.log(TestUtility.addScreenToReport());
	  assertEquals(4,dp.getFieldSetCount());
  }
  
  @Test(priority=1, description="Fieldset List", timeOut=2000, enabled=true, groups= {"Sanity","Regression"})
  public void verifyTimeout() throws InterruptedException
  {
	  Reporter.log(TestUtility.addScreenToReport());
	  Thread.sleep(3000);
  }
  @BeforeClass(alwaysRun=true)
  public void beforeClass() throws IOException {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
	  lp.loginToApplication("Admin", "admin123");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  Reporter.log(TestUtility.addScreenToReport());
	  dr.quit();
  }

  
}
