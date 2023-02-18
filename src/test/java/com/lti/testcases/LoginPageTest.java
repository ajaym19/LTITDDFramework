package com.lti.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.lti.base.LTIBase;
import com.lti.pages.DashboardPage;
import com.lti.pages.LoginPage;

public class LoginPageTest {

	LoginPage lp;
	DashboardPage dp;

	@BeforeTest
	public void reportConfiguration() {
		LTIBase.configureExtentReport();
	}

	@BeforeMethod
	public void browserSetup() {
		lp = new LoginPage();
		lp.initialization();
	}

	@Test
	public void validateTitleTest() {
		ExtentTest test = lp.extent.createTest("Validating Title Test Case");
		String expTitle = "OrangeHRM";
		String actTitle = lp.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		test.log(Status.PASS, "Marking TC as Passed");
	}

	@Test
	public void validateLoginTest() {
		ExtentTest test = lp.extent.createTest("Validating Title Test Case");
		dp = lp.login();
		Assert.assertTrue(dp.dashboardLabelPresent());
		test.log(Status.PASS, "Marking TC as Passed");
	}

	@AfterMethod
	public void closeSetup() {
		lp.tearDown();
	}

	@AfterTest
	public void publishReport() {
		LTIBase.generateReport();
	}
}
