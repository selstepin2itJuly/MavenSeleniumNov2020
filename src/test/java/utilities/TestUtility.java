package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase {

	public static void scrollToElement(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", ele); //default parameter is true
		//if false then element goes to bottom
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)", "");	
	}
	public static void clickOnElementJS(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
	}
	public static void addScreenToReport()
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "<img src=\"data:image/png;base64, "+file+ "\" width=\"800\" height=\"600\" />";
		Reporter.log(path);
	}
	public static void captureScreen() throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDateAndTime()+"_image.png"));
		getDateAndTime();
	}
	public static String getDateAndTime() {
		
		Date dt=new Date();
		//System.out.println(dt);
		SimpleDateFormat sdf=new SimpleDateFormat("Y_M_d_H_m_s_S_z");
		String date = sdf.format(dt);
		//System.out.println(date);
		return date;
	}
	
	public static void waitForElementClickable(WebElement ele) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	} 
	public static void waitForElement(WebElement ele) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ele));
	} 
}
