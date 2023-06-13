/* Name: Automation script Login Page 
 * Description: log report for all Tests 
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */

package com.Acertus_MetroLoad.automation.webPages;

import java.io.IOException;
import java.util.Properties;

import com.Acertus_MetroLoad.automation.testBase.BaseClass;

import junit.framework.Assert;

public class loginPageMetroload extends BaseClass{
	
	
	Properties prop;
	
	public void loginFlow() throws IOException, InterruptedException {
		
		
		System.out.println("printing from loginFlow");
		prop=init_configProp();
		System.out.println("printing from loginFlow");
		System.out.println("Before launch Browser");
		launchBrowser();
		System.out.println("After launch Browser");
		System.out.println("Before LaunchURL Browser");
		launchURL();
		System.out.println("After LaunchURL Browser");
		login();
		//shortWaitSync();
		logout();
		shortWaitSync();
		tearDown();
		
	}

}
