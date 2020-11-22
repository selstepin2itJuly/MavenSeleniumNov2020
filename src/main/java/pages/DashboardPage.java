package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private WebDriver dr;
	
	public DashboardPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement welcomeMsg;
	
	@FindBy(xpath="//fieldset[@id]/legend")
	List<WebElement> fieldset;
	
	public String getWelcomeText()
	{
		return welcomeMsg.getText();
	}
	
	public List<String> getFieldSet()
	{
		List<String> list=new ArrayList<String>();
		for(WebElement s:fieldset)
		{
			list.add(s.getText());
		}
		return list;
	}
	public int getFieldSetCount()
	{
		return fieldset.size();
	}
	
	public boolean isWelcomeMegDisplayed()
	{
		boolean b=false;
		try {
			b = welcomeMsg.isDisplayed();
		}catch(Exception e)
		{}
		
		return b;
	}
}






