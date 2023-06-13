/* Name: ObjectRepository_LoginPage 
 * Description: This script is Central Hub for Reusable Global Locators
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */
package com.Acertus_MetroLoad.automation.objRepo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ObjectRepository_LoginPage {
	
	

	
	//login
		@FindBy(xpath="//input[@name='email']") 
		public WebElement userID;
		@FindBy(xpath="//input[@name='password']")
		public WebElement userPwd;
		@FindBy(xpath="//button[@id='loginButton']")
		public WebElement login_btn;
	
	//Logout webElements
		
		@FindBy(xpath="//title[contains(text(),'Loads')]")
		public WebElement login_title;
		//(//a[@href='#'])[6]
		//(//a[contains(text(),'Automation Test')])[3]/span
		//(//li[@class='dropdown'])[3]/a
		//(//a[@href='#'])[6]
		//(//li[@class='dropdown'])[3]/a[@class='dropdown-toggle']
		//(//li[@class='dropdown'])[3]/a[contains(text(),'Automation Test')]
		@FindBy(xpath="(//li[@class='dropdown'])[3]/a[contains(text(),'Automation Test')]")
		public WebElement automationTest_drpdown;
		//(//li[@class='dropdown'])[3]//ul/li/a[contains(text(),'Logout')]
		@FindBy(xpath="(//li[@class='dropdown'])[3]//ul/li/a[contains(text(),'Logout')]")
		public WebElement logout_lnk;
		
		//Search ID page elements
		@FindBy(xpath="(//a[contains(text(),'Search ID')])[3]")
		public WebElement searhID_btn;
		@FindBy(xpath="//input[@id='search-by-id-field']")
		public WebElement loadID_txtbox;
		@FindBy(xpath="//button[@id='search-by-id-button']")
		public WebElement searchByID_btn;
		
	//select product
	@FindBy(how =How.ID, using="search")
	public WebElement searchbtn;
	@FindBy(xpath="//h1[contains(text(),'Load Unavailable')]")
	public WebElement unavail_loadmsg;
	@FindBy(xpath="//button[contains(text(),'Load Board')]")
	public WebElement unavail_loadmsg_loadBoard_btn;
	
	
	
	
	
	
}
