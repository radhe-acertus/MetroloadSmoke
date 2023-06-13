/* Name: BaseClass 
 * Description: This script is for Reusable Methods
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */


package com.Acertus_MetroLoad.automation.testBase;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.Acertus_MetroLoad.automation.excelReader.ExcelUtils;
import com.Acertus_MetroLoad.automation.objRepo.ObjectRepository_LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver; //commented for using threadLocal at line no 67. Uncomment if not using threadlocal
	public static WebDriverWait wait;
	
	public static EnvVariableClass ev;
	public static Properties prop;
	public static ObjectRepository_LoginPage or;
	public static String URL;
	

	
	public static void launchBrowser() throws IOException {
		
		//String browsername = ExcelUtils.excelreadBrowser();
		System.out.println("Before reading browser name");
		String browsername=prop.getProperty("browser").trim();
		System.out.println("Browser Type: "+browsername);
		if (browsername.equalsIgnoreCase("CHROME")) {
			try {
				
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--disable-web-security");
//				options.addArguments("--disable-gpu");
//				options.addArguments("--user-data-dir=~/chromeTemp");
//				
     				WebDriverManager.chromedriver().setup();
		            //ChromeOptions options = new ChromeOptions();
		            //options.addArguments("--incognito");
		            
//		            options.addArguments("test-type");
//		            options.addArguments("--start-maximized");
//		            options.addArguments("--disable-web-security");
//		            options.addArguments("--allow-running-insecure-content");
		            //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		            //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		            driver = new ChromeDriver(capabilities);		
     			
     				
		       driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().deleteAllCookies();
				System.out.println("[PASSED]" + browsername + "browser launched maximized successfully");
			} 
			catch (Exception e) 
			{
				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
			}}
//		} else if (browsername.equalsIgnoreCase("FIREFOX")) {
//			try {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				driver.manage().window().maximize();
//				System.out.println("[PASSED]" + browsername + "browser launched and maximized successfully");
//			} catch (Exception e) {
//				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
//			}
//		}
//
//		else if (browsername.equalsIgnoreCase("EDGE")) {
//			try {
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				driver.manage().window().maximize();
//				System.out.println("[PASSED]" + browsername + "browser launched and maximized successfully");
//			} catch (Exception e) {
//				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
//			}
//		}
//
//		else if (browsername.equalsIgnoreCase("IE")) {
//			try {
//				WebDriverManager.iedriver().setup();
//				driver = new InternetExplorerDriver();
//				driver.manage().window().maximize();
//				System.out.println("[PASSED]" + browsername + "browser launched and maximized successfully");
//			} catch (Exception e) {
//				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
//			}
//		}
//
//		else {
//			throw new RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers");
//		}
            
	}


	public static String getScreenshotpath(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String despath = System.getProperty("user.dir") + "\\reports\\" + filename + ".jpg";
		File des = new File(despath);
		FileUtils.copyFile(src, des);
		return despath;
	}

	public static void launchURL() throws IOException {
		
		URL=prop.getProperty(ev.ENV_VALUE);
		try {
			driver.get(URL);

		} catch (Exception e) {
			System.err.println("[ERROR] Unable to launch" + URL + e.toString());
		}
	}
	
	public static Properties init_configProp() throws IOException {
		
		try {
			FileInputStream file=new FileInputStream("./Resources/config.properties");
			prop=new Properties();
			prop.load(file);
		} 
		catch (FileNotFoundException e) {
			System.err.println("[ERROR] Unable to read properties file"+ e.toString());
			
		}
		
		return prop;
		
	}
	
		public String readURL() throws IOException {
			return ExcelUtils.excelreadURL();
		}
	
	
	
		public String returnelementTxt(WebElement webelement) {
		
		String updatecardtxt= webelement.getText().toString();
		return updatecardtxt;
		
		}

	public static void inputtext(WebElement webelemeref, String txt) {
		webelemeref.sendKeys(txt);

	}

	public static void inputtextLoginPassword(WebElement webelemeref, String txt) {
		webelemeref.sendKeys(txt);

	}

	public static void clickelement(WebElement webelemeref) {
		webelemeref.click();

	}

	public void impwait() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

	}

	public void expwaitVisibility(WebElement webelementref) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(webelementref));
	}

	public void expwaitClickable(WebElement webelementref) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(webelementref));
	}
	
	public void windowScroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	public void longwindowScroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)","");
	}
	
	public void allThewayPageDown() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
	}
	
	public void waitSync() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public void shortWaitSync() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public boolean isDisplayed(WebElement webelementref) {
		
		boolean flag = webelementref.isDisplayed();
		return flag;
		
	}
	
	public void logout() throws InterruptedException {
		
		JSclickelement(or.logout_lnk);
		shortWaitSync();
	}
	
	public void tearDown()
	{
//		ExtReportToPDF pdfReport=new ExtReportToPDF();
//		pdfReport.convertTopdf();
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	public void login() throws InterruptedException, IOException {
		
		
		
		 or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		
		try {
			expwaitVisibility(or.userID);
			System.out.println("[PASSED]" + "Showing Login screen");
		} catch (Exception e) {
			throw new RuntimeException("[FAILED] Not showing Login screen");
		}
		inputtext(or.userID, prop.getProperty("metroloadID"));
		shortWaitSync();
		inputtext(or.userPwd, prop.getProperty("metroloadPWD"));
		shortWaitSync();
		clickelement(or.login_btn);
		System.out.println("Login Successfull with user ID::"+prop.getProperty("metroloadID"));
		String homeTitle=or.login_title.getText();
		System.out.println("Home page title is: "+homeTitle);
	}
	
	public void JSclickelement(WebElement webelemeref) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",webelemeref);
		
	}
	
	

	public void lookUp_LoadID(String TCno, int row) throws InterruptedException, IOException {
		
		int loadID=ExcelUtils.readCellVaueInteger(row);
		System.out.println("lookUp LoadID:"+loadID);
		JSclickelement(or.searhID_btn);
		JSclickelement(or.loadID_txtbox);
		or.loadID_txtbox.sendKeys(String.valueOf(loadID));
		shortWaitSync();
		clickelement(or.searchByID_btn);
		impwait();
		String exp_loaddetails="Load Unavailable";
		String act_loaddetails=or.unavail_loadmsg.getText();
		if(exp_loaddetails.equals(act_loaddetails)) {
			
			clickelement(or.unavail_loadmsg_loadBoard_btn);
			
		}
		
		else {
			
		}
	}
	
	
	
	public String currentDateTime() {
		
		DateFormat dateformat= new SimpleDateFormat("DD");
		Date date= new Date();
		String currentDate=dateformat.format(date);
		System.out.println("currentDateTime=="+currentDate);
		return currentDate;
	}
	
		

	
}
