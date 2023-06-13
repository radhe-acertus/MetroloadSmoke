package com.Acertus_MetroLoad.automation.webPages;

import java.io.IOException;

import com.Acertus_MetroLoad.automation.testBase.BaseClass;

public class searchLoadByID extends BaseClass{

	public void searchLoad(String expClassName, int rowNo) throws IOException, InterruptedException {
	
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
	shortWaitSync();
	lookUp_LoadID(expClassName,rowNo);
	
	}
	
}
