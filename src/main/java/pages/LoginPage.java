package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver dr;
	
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}

	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(css="input[value='LOGIN']")
	WebElement login;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgtoPassword;
	
	public void loginToApplication(String user, String pass)
	{
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		login.click();
	}
	
	public void clickOnForgotPassword()
	{
		forgtoPassword.click();
	}
}
