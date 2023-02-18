package com.lti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lti.base.LTIBase;

public class LoginPage extends LTIBase {

	@FindBy(name = "username")
	WebElement txtUsername;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public DashboardPage login() {
		txtUsername.sendKeys(prop.getProperty("username"));
		txtPassword.sendKeys(prop.getProperty("password"));
		btnLogin.click();
		return new DashboardPage();

	}

}
