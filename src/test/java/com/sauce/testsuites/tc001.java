package com.sauce.testsuites;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.BaseTest;

public class tc001 extends BaseTest	{
	@BeforeMethod
	public void setup() throws IOException{
		System.out.println("before method");
		init();
	}
	@Test
	public void tc01() {
		System.out.println("Actual Test");
		
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("After Method");
	}
}
