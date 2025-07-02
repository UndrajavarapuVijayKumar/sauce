package com.zscrap.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extetntReportsPractice {
	public static void main(String[] args) throws IOException{
		//Engine
		ExtentReports extents  = new ExtentReports();	//initializing the extentreports
		//under the extent reports under that we can create spark, emailable, extent, Avent
		//spark and Klov reporters are community versions 
		
		//reporter
		ExtentSparkReporter sparkReporter =  new ExtentSparkReporter("report.html");
		
		//attaching reports
		extents.attachReporter(sparkReporter);
		
		ExtentTest T1 = extents.createTest("Test1");
		T1.pass("This is pass!");

		ExtentTest T2 = extents.createTest("Test2");
		T2.log(Status.FAIL, "This is fails");

		ExtentTest T3 = extents.createTest("Test3");
		T3.log(Status.INFO,"this is just for information ");
		
		ExtentTest T4 = extents.createTest("Test4");
		T4.skip("skipped");
		
		extents.createTest("test5")
		.warning("warn")				//method chaining process, for readability we should represent method chaining in different lines
		.pass("pass")
		.skip("skip");
		
		extents.createTest("text base test")
		.log(Status.INFO,"<b>infor1</b>")	//TExt to bold
		.log(Status.INFO, "<i>info2</i>")	//text to italic
		.log(Status.INFO, "info3");
		
		/*
		 * We have 5 log reports, they're
		 * 
		 * ----->>> order
		 * FAIL, SKIP,WARNING, PASS,INFO ----->>>> priority in this way 
		 *if you arrange all of your log events in this order from this test, then whatever is coming from the top 
		 *then that log event will be considered as the entire log test 
		 * 
		 * we can use Log events n number of times
		 * 
		 * you the log events appropriately 
		 */
		
		
		
		
		/*
		 * Log different type of information to the extent reports
		 * 1.Text-Bold, italic
		 * 2.XML
		 * 3.JSON
		 * 4.Collection Data(List, Set and Map)
		 * 5.Highlight any message
		 * 6.Exception
		 */
		String JsonData = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\",\r\n"
				+ "    \"id\": \"604\",\r\n"
				+ "    \"createdAt\": \"2025-07-02T07:57:05.575Z\"\r\n"
				+ "}";
		extents.createTest("Json Base test")
		.log(Status.INFO, JsonData)
		.log(Status.INFO, MarkupHelper.createCodeBlock(JsonData,CodeLanguage.JSON));
		
		
		
		
				//Once you done with the reports we need tp use flush for saving the reports
				extents.flush();
				
				//this will automatically opens the extentreports in the browser 
				Desktop.getDesktop().browse(new File("report.html").toURI());
	}
}
