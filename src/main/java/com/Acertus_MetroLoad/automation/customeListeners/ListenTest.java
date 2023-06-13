/* Name: ListenTest 
 * Description: log report for all Tests 
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */
package com.Acertus_MetroLoad.automation.customeListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Acertus_MetroLoad.automation.testBase.BaseClass;
import com.Acertus_MetroLoad.automation.testBase.ExtReporterClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenTest extends BaseClass implements ITestListener {
	
	//ExtentHtmlReporter htmlReporter;
	ExtentReports extent = ExtReporterClass.extReportGenerator();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "SUCCESSFULL: " +result.getMethod().getMethodName());

	}

 public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

	 	try {
	 		test.addScreenCaptureFromPath(getScreenshotpath(result.getMethod().getMethodName()), "FAILED");
			
	 	} catch (IOException e) {
			
 		e.printStackTrace();
	 	}

	 }

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
