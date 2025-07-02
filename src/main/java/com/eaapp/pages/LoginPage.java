package com.eaapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By txt_username = By.id("UserName");
	private By txt_password = By.id("Password");
	private By btn_login=By.id("loginIn");
	
	public HomePage performLogin(String username, String Password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(Password);
		driver.findElement(btn_login).click();
		return new HomePage(driver);
	}
	
	
	
}
