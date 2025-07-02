package com.eaapp.suites;

import java.io.IOException;

import com.eaapp.pages.HomePage;
import com.sauce.base.BaseTest;

public class texecution extends BaseTest{
	public static void main(String[] args) throws IOException {
//		WebDriver driver = new ChromeDriver();
//		driver.navigate().to("http://eaapp.somee.com/Account/Login");
		
		init("chrome");
		
		launchBrowser(childProp.getProperty("eappUrl"));
		HomePage hp = new HomePage(driver);
		var LoginPage = hp.clickLogin();
		LoginPage.performLogin("admin", "password");
	}
}
