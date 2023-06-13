/* Name: ExtReporterClass Script 
 * Description: This script is used to drive the Extent Reports
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */
package com.Acertus_MetroLoad.automation.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtReporterClass {
	
	public static  ExtentReports extent;
	

	public static ExtentReports extReportGenerator() {
		
		String reportspath = System.getProperty("user.dir")+"\\Reports\\AutomationTestReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportspath);
		reporter.config().setReportName("Acertus_MetroLoad_Automation Results");
		reporter.config().setDocumentTitle("Automation Report MetroLoad");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		return extent;
		
	}
}
