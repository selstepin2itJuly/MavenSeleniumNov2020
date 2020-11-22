package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static WebDriver getInstance() throws IOException
	{
		prop=new Properties();
		String configFile="./src/main/java/config/config.properties";
		FileInputStream inStream= new FileInputStream(configFile);
		prop.load(inStream);
		browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("ignore-certificate-errors");
			driver=new ChromeDriver(opt);
			//driver.get("http://www.toolsqa.com");		
		}else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagent"));
			FirefoxOptions opt= new FirefoxOptions();
			opt.addArguments("ignore-certificate-errors");
			driver=new FirefoxDriver(opt);
			
		}else if(browser.equalsIgnoreCase("ie"))
		{
		
		}else if(browser.equalsIgnoreCase("edge"))
		{
			//System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagent"));
			EdgeOptions opt= new EdgeOptions();
			opt.setCapability("ignore-certificate-errors", true);
			driver=new EdgeDriver(opt);
		}else
		{
			Throwable thr=new Throwable();
			thr.initCause(null);
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
