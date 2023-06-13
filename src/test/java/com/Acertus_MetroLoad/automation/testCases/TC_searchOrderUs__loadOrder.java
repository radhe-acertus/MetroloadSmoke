package com.Acertus_MetroLoad.automation.testCases;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Acertus_MetroLoad.automation.customeListeners.ListenTest;
import com.Acertus_MetroLoad.automation.excelReader.ExcelUtils;
import com.Acertus_MetroLoad.automation.testBase.BaseClass;
import com.Acertus_MetroLoad.automation.webPages.searchLoadByID;

@Listeners(ListenTest.class)
public class TC_searchOrderUs__loadOrder extends BaseClass{
	
	@Test(enabled=true)
	public void searchOrderUs__loadOrder() throws IOException, InterruptedException {
		
		ExcelUtils ex=new ExcelUtils();
		int rowNo=ex.excelReadTestCaseRowNo(getClass().getSimpleName());
		String tcName= getClass().getSimpleName();
		
		System.out.println("TC Name::"+tcName);
		System.out.println("TC Row no::"+rowNo);
		searchLoadByID sl=new searchLoadByID();
		sl.searchLoad(tcName,rowNo);
	}

}
