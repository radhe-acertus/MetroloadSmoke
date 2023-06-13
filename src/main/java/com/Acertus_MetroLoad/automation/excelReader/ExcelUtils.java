/* Name: ExcelUtils 
 * Description: This script is to read the data's from TestData and Config file
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
  */
package com.Acertus_MetroLoad.automation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String testCellValue;
	public static String testDataSheetPath;
	public static String testConfigSheetPath;
	public static String userNameCellValue;
	public static String passwordCellValue;
	public static String urlCellValue;
	public static String browserCellValue;
	public Integer rowValue;

	// ******READING CLASS WITH FLAG STATUS "Y"*****
	public static List<String> excelReadTestCase() throws IOException {

		String path = System.getProperty("user.dir");
		testDataSheetPath = (path
				+ "//src//main//java//com//Acertus_MetroLoad//automation//data//MTRL_Testdata.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("TOC");
		int numberOfRows = tocSheet.getPhysicalNumberOfRows();
		for (int i = 1; i < numberOfRows; i++) {

			Row datarow = tocSheet.getRow(i);
			Cell flagstatuscell = datarow.getCell(2);
			String flagstatuscellValuestr = flagstatuscell.getStringCellValue();

			if (flagstatuscellValuestr.equalsIgnoreCase("Y")) {
				Cell descriptionCell = datarow.getCell(1);
				String descriptionCellValuestr = descriptionCell.getStringCellValue();

				if (descriptionCellValuestr.equalsIgnoreCase("Sanity")) {
					Sheet sanitySheet = wb.getSheet("Sanity");
					int sanityNumberOfRows = sanitySheet.getPhysicalNumberOfRows();
					String packageCellValue = sanitySheet.getRow(0).getCell(2).getStringCellValue();
					for (int j = 1; j < sanityNumberOfRows; j++) {
						Row sanitySheetrow = sanitySheet.getRow(j);
						Cell sanityflagstatuscell = sanitySheetrow.getCell(2);
						String sanityflagstatuscellValuestr = sanityflagstatuscell.getStringCellValue();
						if (sanityflagstatuscellValuestr.equalsIgnoreCase("Y")) {
							Cell sanityTestNameCell = sanitySheetrow.getCell(1);
							String classCellValue = sanityTestNameCell.getStringCellValue();
							testCellValue = packageCellValue + classCellValue;

						}
					}

				}

				else if (descriptionCellValuestr.equalsIgnoreCase("Regression")) {
					Sheet regressionSheet = wb.getSheet("Regression");
					int regressionNumberOfRows = regressionSheet.getPhysicalNumberOfRows();

					String packageCellValue = regressionSheet.getRow(0).getCell(2).getStringCellValue();
					for (int k = 2; k < regressionNumberOfRows; k++) {
						Row regressionSheetrow = regressionSheet.getRow(k);
						Cell regressionflagstatuscell = regressionSheetrow.getCell(2);
						String regressionflagstatuscellValuestr = regressionflagstatuscell.getStringCellValue();
						if (regressionflagstatuscellValuestr.equalsIgnoreCase("Y")) {
							Cell regressionTestNameCell = regressionSheetrow.getCell(1);
							String classCellValue = regressionTestNameCell.getStringCellValue();
							testCellValue = packageCellValue + classCellValue;

						}

					}
				}

			}

			list.add(testCellValue);

		}

		return list;

	}
	
	
		// *******READING ROW VALUES ********
	public int excelReadTestCaseRowNo(String ExpectedTCid) throws IOException {

		String path = System.getProperty("user.dir");
		testDataSheetPath = (path
				+ "//src//main//java//com//Acertus_MetroLoad//automation//data//MTRL_Testdata.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("TOC");
		int numberOfRows = tocSheet.getPhysicalNumberOfRows();
		System.out.println("numberOfRows::"+numberOfRows);
		for (int i = 1; i < numberOfRows; i++) {

			Row datarow = tocSheet.getRow(i);
			System.out.println("datarow::"+datarow);
			Cell flagstatuscell = datarow.getCell(2);
			System.out.println("flagstatuscell::"+flagstatuscell);
			String flagstatuscellValuestr = flagstatuscell.getStringCellValue();
			System.out.println("flagstatuscellValuestr:"+flagstatuscellValuestr);

			if (flagstatuscellValuestr.equalsIgnoreCase("Y")) {
				Cell descriptionCell = datarow.getCell(1);
				String descriptionCellValuestr = descriptionCell.getStringCellValue();
				System.out.println("descriptionCellValuestr::"+descriptionCellValuestr);
				if (descriptionCellValuestr.equalsIgnoreCase("Sanity")) {
					Sheet sanitySheet = wb.getSheet("Sanity");
					int sanityNumberOfRows = sanitySheet.getPhysicalNumberOfRows();
					System.out.println("sanityNumberOfRows::"+sanityNumberOfRows);
					String packageCellValue = sanitySheet.getRow(0).getCell(2).getStringCellValue();
					System.out.println("packageCellValue::"+packageCellValue);
					for (int j = 1; j < sanityNumberOfRows; j++) {
						Row sanitySheetrow = sanitySheet.getRow(j);
						Cell sanityflagstatuscell = sanitySheetrow.getCell(2);
						System.out.println("sanityflagstatuscell::"+sanityflagstatuscell);
						String sanityflagstatuscellValuestr = sanityflagstatuscell.getStringCellValue();
						System.out.println("sanityflagstatuscellValuestr::"+sanityflagstatuscellValuestr);
						String sanityTestcaseId = sanitySheetrow.getCell(1).getStringCellValue();
						System.out.println("sanityTestcaseId::"+sanityTestcaseId);
						if (sanityflagstatuscellValuestr.equalsIgnoreCase("Y") && sanityTestcaseId.equalsIgnoreCase(ExpectedTCid)) {
							rowValue = j;
							System.out.println("rowValue::"+rowValue);

						}
					}

				}

				

			}

			
			
		}

		return rowValue;

	}

	// ********READING BROWSER VALUE**********
	public static String excelreadBrowser() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
					+ "//src//main//java//com//Acertus_MetroLoad//automation//config//Config.xlsx");
		System.out.println(testConfigSheetPath);
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(4);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 1) {
			browserCellValue = datacell.getStringCellValue();
		} else {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			browserCellValue = Integer.toString(numericCellValueint);
		}

		return browserCellValue;
	}

	// *********************************READING URL
	// VALUE***************************************************
	public static String excelreadURL() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "//src//main//java//com//Acertus_MetroLoad//automation//config//Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(1);
		System.out.println("Row value"+datarow);
		Cell datacell = datarow.getCell(2);
		System.out.println("Cell Value"+datacell);
		int cellType = datacell.getCellType();
		System.out.println("Cell Type value"+cellType);

		if (cellType == 1) {
			urlCellValue = datacell.getStringCellValue();
		} else {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			urlCellValue = Integer.toString(numericCellValueint);
		}

		return urlCellValue;
	}

	public static int readCellVaueInteger(int rowNum) throws IOException {
		
		String path = System.getProperty("user.dir");
		testDataSheetPath = (path
				+ "//src//main//java//com//Acertus_MetroLoad//automation//data//MTRL_Testdata.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		int cellValue=(int)tocSheet.getRow(rowNum).getCell(3).getNumericCellValue();
		System.out.println("StringcellValue::"+cellValue);
		return cellValue;
		
	}
	
	
	public static String readCellVaueString(int rowNum) throws IOException {
		
		String path = System.getProperty("user.dir");
		testDataSheetPath = (path
				+ "//src//main//java//com//Acertus_MetroLoad//automation//data//MTRL_Testdata.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		String cellValue=tocSheet.getRow(rowNum).getCell(3).getStringCellValue();
		System.out.println("StringcellValue::"+cellValue);
		return cellValue;
		
	}
	public static String excelreadURL1(String env) throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "//src//main//java//com//Acertus_MetroLoad//automation//config//Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		if(env.equals("Stage3"))
		{	
			
				Row datarow = credsheet.getRow(5);
				System.out.println("Row value"+datarow);
				Cell datacell = datarow.getCell(2);
				System.out.println("Cell Value"+datacell);
				int cellType = datacell.getCellType();
				System.out.println("Cell Type value"+cellType);
		
				if (cellType == 1) {
					urlCellValue = datacell.getStringCellValue();
				} else {
					double numericCellValue = datacell.getNumericCellValue();
					int numericCellValueint = (int) numericCellValue;
					urlCellValue = Integer.toString(numericCellValueint);
				}
		
				//return urlCellValue;
		
		}
		else if(env.equals("Stage2"))
		{	
			
			Row datarow = credsheet.getRow(6);
			System.out.println("Row value"+datarow);
			Cell datacell = datarow.getCell(2);
			System.out.println("Cell Value"+datacell);
			int cellType = datacell.getCellType();
			System.out.println("Cell Type value"+cellType);
	
			if (cellType == 1) {
				urlCellValue = datacell.getStringCellValue();
			} else {
				double numericCellValue = datacell.getNumericCellValue();
				int numericCellValueint = (int) numericCellValue;
				urlCellValue = Integer.toString(numericCellValueint);
			}
	
			//return urlCellValue;
	
		}
		
		
		else if(env.equals("Staging"))
		{	
			
			Row datarow = credsheet.getRow(8);
			System.out.println("Row value"+datarow);
			Cell datacell = datarow.getCell(2);
			System.out.println("Cell Value"+datacell);
			int cellType = datacell.getCellType();
			System.out.println("Cell Type value"+cellType);
	
			if (cellType == 1) {
				urlCellValue = datacell.getStringCellValue();
			} else {
				double numericCellValue = datacell.getNumericCellValue();
				int numericCellValueint = (int) numericCellValue;
				urlCellValue = Integer.toString(numericCellValueint);
			}
	
			//return urlCellValue;
	
		}
		
		else if(env.equals("Prod"))
		{	
			
			Row datarow = credsheet.getRow(7);
			System.out.println("Row value"+datarow);
			Cell datacell = datarow.getCell(2);
			System.out.println("Cell Value"+datacell);
			int cellType = datacell.getCellType();
			System.out.println("Cell Type value"+cellType);
	
			if (cellType == 1) {
				urlCellValue = datacell.getStringCellValue();
			} else {
				double numericCellValue = datacell.getNumericCellValue();
				int numericCellValueint = (int) numericCellValue;
				urlCellValue = Integer.toString(numericCellValueint);
			}
	
			//return urlCellValue;
	
		}
		
		return urlCellValue;
		
	}
	
	
	
	// ********READING USERNAME VALUE********
	public static String excelreadUserName() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "//src//main//java//com//Acertus_MetroLoad//automation//config//Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(2);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 1) {
			userNameCellValue = datacell.getStringCellValue();
		} else {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			userNameCellValue = Integer.toString(numericCellValueint);
		}

		return userNameCellValue;
	}

//*********************************READING PASSWORD VALUE***************************************************

	public static String excelreadPassword() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "//src//main//java//com//Acertus_MetroLoad//automation//config//Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(3);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 0) {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			passwordCellValue = Integer.toString(numericCellValueint);
		} else if (cellType == 1) {
			passwordCellValue = datacell.getStringCellValue();
		} else {
			System.out.println("Formula: " + datacell.getCellFormula());
			int cachedFormulaResultType = datacell.getCachedFormulaResultType();
			if (cachedFormulaResultType == 1) {
				passwordCellValue = datacell.getStringCellValue();
			} else {
				double numericCellValue = datacell.getNumericCellValue();
				int numericCellValueint = (int) numericCellValue;
				passwordCellValue = Integer.toString(numericCellValueint);
			}
		}

		return passwordCellValue;

	}
}
