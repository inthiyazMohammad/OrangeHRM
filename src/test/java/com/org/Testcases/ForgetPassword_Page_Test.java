package com.org.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.Base.BaseClass;
import com.org.PageObjects.ForgetPassword_Page;
import com.org.PageObjects.Login_Page;
import com.org.Utilities.Log;

public class ForgetPassword_Page_Test extends BaseClass {

	Login_Page login_page;
	ForgetPassword_Page forgetPassword_page;
	
	public ForgetPassword_Page_Test() throws IOException {
		super();
	}
	
	@BeforeClass
	public void SetUp() {
		
		LaunchBrowser();
		Log.startTestCase("ForgetPassword Page");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		Log.info("Browser closing");
		driver.quit();
		
		Log.endTestCase("ForgetPassword Page");
	}
	
	@Test(priority=1)
	public void Verify_Login_Page() throws IOException {
		
		login_page = new Login_Page();
		
		login_page.Validate_Title();
		login_page.ClickOn_ForgerPassword();
	}
	
	@Test(priority=2)
	public void Verify_ForgetPassword_Page() throws IOException, InterruptedException {
		
		forgetPassword_page = new ForgetPassword_Page();
		
		forgetPassword_page.Reset_Password();
		
		forgetPassword_page.Confirm_TextMessage();
		Assert.assertTrue(true);
	}

}
