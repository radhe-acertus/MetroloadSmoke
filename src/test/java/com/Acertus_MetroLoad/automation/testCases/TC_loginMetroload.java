/* Name: Automation script Login functionality
 * Description: log report for all Tests 
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */


package com.Acertus_MetroLoad.automation.testCases;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Acertus_MetroLoad.automation.customeListeners.ListenTest;
import com.Acertus_MetroLoad.automation.excelReader.ExcelUtils;
import com.Acertus_MetroLoad.automation.testBase.BaseClass;
import com.Acertus_MetroLoad.automation.webPages.loginPageMetroload;
import com.Acertus_MetroLoad.automation.webPages.searchLoadByID;

@Listeners(ListenTest.class)
public class TC_loginMetroload extends BaseClass{
	
	@Test(enabled=true)
	public void loginMetroloadValidCredentials() throws IOException, InterruptedException {
		
		loginPageMetroload lp=new loginPageMetroload();
		
		lp.loginFlow();
		
//		ExcelUtils ex=new ExcelUtils();
//		String tcName= getClass().getSimpleName();
//		int rowNo=ex.excelReadTestCaseRowNo(getClass().getSimpleName());
//		System.out.println("TC Name::"+tcName);
//		System.out.println("TC Row no::"+rowNo);
//		searchLoadByID sl=new searchLoadByID();
//		sl.searchLoad(tcName,rowNo);
	}

}
