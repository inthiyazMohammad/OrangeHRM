package com.org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.org.Utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() throws IOException {
		
		DOMConfigurator.configure("log4j.xml");
		
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+
				                        "\\src\\main\\java\\com\\org\\Configuration\\ConfigData.properties");
		prop.load(file);
	}
	
	public void LaunchBrowser() {
		
		String browserName = prop.getProperty("browser");
		
		Log.info("Browser Launching");
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Log.info("Application Launching");
		driver.get(prop.getProperty("url"));
	}
	
	public String getScreenshot(String fileName) throws IOException {
		
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String destFilePath = System.getProperty("user.dir")+"\\Screenshot\\"+fileName+".png";
		
		FileUtils.copyFile(sourceFile, new File(destFilePath));
		
		return destFilePath;
	}
}
