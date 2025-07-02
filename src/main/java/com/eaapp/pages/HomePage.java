package com.eaapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	//locators for login
	//locators for employee list 
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By clk_login = By.id("loginLink");
	
	private By clk_EmplyoeList = By.xpath("//*[text()='Employee List']");
	
	public LoginPage clickLogin() {
		driver.findElement(clk_login).click();
		return new LoginPage(driver);
	}
	
	public EmployeeListPage clickEmployeeList() {
		driver.findElement(clk_EmplyoeList).click();
		return new EmployeeListPage(driver);
		
	}
	
}
