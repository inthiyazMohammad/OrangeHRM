package com.org.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.Base.BaseClass;
import com.org.Utilities.Log;

public class Login_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"txtUsername\"]")
	WebElement username;
	
	@FindBy(xpath="//*[@id=\"txtPassword\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"btnLogin\"]")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"forgotPasswordLink\"]/a")
	WebElement forgetPassword_Link;
	
	public Login_Page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_Title() {
		
		Log.info("Validating Login Page Title");
		return driver.getTitle();
	}
	
	public void Enter_Username() {
		
		Log.info("Entering username");
		username.sendKeys(prop.getProperty("username"));
	}
	
	public void Enter_Password() {
		
		Log.info("Entering password");
		password.sendKeys(prop.getProperty("password"));
	}

	public Dashboard_Page ClickOn_Login_Button() throws IOException {
		
		Log.info("Clicking on Login button");
		loginButton.click();

		Log.info("Navigating to Dashboard Page");
		return new Dashboard_Page();
	}

	public ForgetPassword_Page ClickOn_ForgerPassword() {
		
		Log.info("Clicking on Forget_password link");
		forgetPassword_Link.click();
		
		Log.info("Navigating to ForgetPassword Page");
		return new ForgetPassword_Page();
	}
}
