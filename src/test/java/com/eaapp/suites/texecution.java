package com.eaapp.suites;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eaapp.pages.HomePage;

import com.sauce.base.BaseTest;

public class texecution extends BaseTest{
	@BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

   
	@Test 
	public void loginTest() throws IOException {
		init("chrome");
		
		launchBrowser(childProp.getProperty("eappUrl"));
		
		HomePage hp = new HomePage(driver);
		
		var LoginPage = hp.clickLogin();
		
		LoginPage.performLogin("admin", "password");
	}
}
