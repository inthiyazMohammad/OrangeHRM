package com.org.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporter {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;

	public static ExtentReports getExtentReport() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\extentReport.html");
		
		htmlReporter.config().setReportName("OrangeHRM Extent Reports Name");
		htmlReporter.config().setReportName("OrangeHRM Extent Reports Title");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Project Name", "OrangHRM");
		extentReport.setSystemInfo("Operating System", "Windows 10");
		extentReport.setSystemInfo("Browser", "Chrome and Firefox");
		extentReport.setSystemInfo("Tested By", "Inthiyaz Mohammad");
		
		return extentReport;
	}
}
