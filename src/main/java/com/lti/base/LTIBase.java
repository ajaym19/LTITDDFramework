package com.lti.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LTIBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;

	public void initialization() {
		readPropertyFile();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	public void tearDown() {
		driver.quit();
	}

	public void readPropertyFile() {
		String propFilePath = "./src/main/resources/config/config.properties";
		FileInputStream fis;
		prop = new Properties();

		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void configureExtentReport() {
		String reportPath = "./ExtentReports";
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter(reportPath);
		extent.attachReporter(reporter);
	}
	
	public static void generateReport() {
		extent.flush();
	}
}
