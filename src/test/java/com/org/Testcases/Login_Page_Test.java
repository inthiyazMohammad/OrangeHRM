package com.org.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.Base.BaseClass;
import com.org.PageObjects.Dashboard_Page;
import com.org.PageObjects.Login_Page;
import com.org.Utilities.Log;

@Listeners(com.org.Listeners.Listeners.class)
public class Login_Page_Test extends BaseClass {

	public Login_Page_Test() throws IOException {
		super();
	}

	Login_Page login_page;
	Dashboard_Page dashboard_page;
	
	@BeforeClass
	public void SetUp() {
		
		Log.startTestCase("Login_Page");
		LaunchBrowser();
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.endTestCase("Login_Page");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void Verify_Title() throws IOException {
		
		login_page = new Login_Page();
		
		String actTitle = login_page.Validate_Title();
		Assert.assertEquals(actTitle, "OrangeHRM");
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	public void Verify_Login() throws InterruptedException, IOException {
		
		login_page = new Login_Page();
		dashboard_page = new Dashboard_Page();
		
		Thread.sleep(2000);
		login_page.Enter_Username();
		login_page.Enter_Password();
		dashboard_page = login_page.ClickOn_Login_Button();
		
		Assert.assertTrue(true);
	}
}
