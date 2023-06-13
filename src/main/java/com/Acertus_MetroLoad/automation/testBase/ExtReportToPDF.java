/* Name: ExtReportToPDF Script 
 * Description: This script is used to convert Extent report to Pdf
 * Developed By: Radhe Singh
 * Automation Architect: Radhe Singh
 */
package com.Acertus_MetroLoad.automation.testBase;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.apache.commons.io.FileUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ExtReportToPDF {
	
	String userDir=System.getProperty("user.dir");
	String htmlReportPath=userDir+"\\Reports\\AutomationTestReport.html";
	String pdfReportPath=userDir+"\\Reports\\AutomationTestReport.pdf";
	
	public void convertTopdf() {
			try {
//				//Created PDF document
//				Document doc=new Document();
//				PdfWriter pwriter= PdfWriter.getInstance(doc, new FileOutputStream(pdfReportPath));
//				doc.open();
//				//Read HTML Report
//				InputStream inStream= new FileInputStream(htmlReportPath);
//				//Converted to PDF
//				XMLWorkerHelper.getInstance().parseXHtml(pwriter, doc, inStream);
//				doc.close();
//				System.out.println("PDF report generated Successfully");
				
				
	            // Create an ITextRenderer instance
	            ITextRenderer renderer = new ITextRenderer();
	            // Read the HTML report file
	            String htmlContent = FileUtils.readFileToString(new File(htmlReportPath), "UTF-8");
	            // Parse and render the HTML to PDF
	            renderer.setDocumentFromString(htmlContent);
	            renderer.layout();
	            // Create the output stream for the PDF file
	            FileOutputStream outputStream = new FileOutputStream(pdfReportPath);
	            // Generate the PDF file
	            renderer.createPDF(outputStream);           // Close the output stream
	            outputStream.close();
				
	            System.out.println("PDF report generated successfully.");
				
			}
			catch(Exception e) 
			{
				
				System.out.println("Failed to generate PDF report"+e.getMessage().toString());
			}
			
	}
}
