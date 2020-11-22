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
import org.testng.annotations.AfterClass;

public class DashboardFeature {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
  @Test(priority=1, description="Welcome Message", groups= {"Sanity, Regression"})
  public void verifyWelcomeMsg() {
	  String str=dp.getWelcomeText();
	  //assertEquals("Welcome", str);
	  assertTrue(str.contains("Welcome"));
	  
  }
  
  @Test(priority=1, description="Fieldset List", enabled=true, groups= "Regression")
  public void verifyFieldSetList() {
	  List<String> str = dp.getFieldSet();
	  String[] arr= {"Quick Launch","Employee Distribution by Subunit","Legend", "Pending Leave Requests"};
	  int i=0;
	  for(String s:str)
	  {
		  assertEquals(arr[i], s.trim());
		  i++;
	  }
  }
  @Test(priority=1, description="Fieldset Count", enabled=true, dependsOnMethods="verifyFieldSetList")
  public void verifyFieldSetCount() {
	  assertEquals(4,dp.getFieldSetCount());
  }
  
  @Test(priority=1, description="Fieldset List", timeOut=2000, enabled=true, groups= {"Sanity","Regression"})
  public void verifyTimeout() throws InterruptedException
  {
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
	  TestUtility.addScreenToReport();
	  dr.quit();
  }

  
}
