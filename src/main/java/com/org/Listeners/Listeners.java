package com.org.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.org.Base.BaseClass;
import com.org.Utilities.ExtentReporter;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extentReporter = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	public Listeners() throws IOException {
		super();
	}
	
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		
		extentTestThread.set(extentTest); // making Extent Thread safe 
		
		extentTest = extentReporter.createTest(testName+" execution started");
	}

	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		extentTestThread.get().log(Status.PASS, testName+" got passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String fileName = result.getName();
		
		extentTestThread.get().fail(result.getThrowable());
		
		try {
			String screenshotFilePath = getScreenshot(fileName);
			
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, fileName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReporter.flush();
	}

}
