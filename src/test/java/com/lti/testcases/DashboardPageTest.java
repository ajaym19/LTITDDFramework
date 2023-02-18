package com.lti.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lti.pages.DashboardPage;
import com.lti.pages.LoginPage;

public class DashboardPageTest {

	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserSetup() {
		lp = new LoginPage();
		lp.initialization();
	}

	@Test
	public void validateDashboadLabelTest() {
		dp = lp.login();
		Assert.assertTrue(dp.dashboardLabelPresent());
	}

	// 6 Test cases for 6 sections
	@Test
	public void validateTimeAtWorkSectionTest() {
		dp = lp.login();
		Assert.assertTrue(dp.timeWorkSectionPresent());
	}

	@Test
	public void quickLaunchSectionTest() {

	}

	@Test
	public void buzzPostSectionTest() {

	}

	@Test
	public void myActionsSectionTest() {

	}
	
	@Test
	public void empLeaveSectionTest() {

	}
	
	@Test
	public void empDistributionSubUnitSectionTest() {

	}
	
	@Test
	public void empDistributionLocationSectionTest() {

	}

	@AfterMethod
	public void closeSetup() {
		lp.tearDown();
	}
}
