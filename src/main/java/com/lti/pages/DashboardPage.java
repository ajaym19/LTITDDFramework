package com.lti.pages;

import org.openqa.selenium.By;

import com.lti.base.LTIBase;

public class DashboardPage extends LTIBase {

	public boolean dashboardLabelPresent() {
		return driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	}
	
	public boolean timeWorkSectionPresent() {
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	}
}
