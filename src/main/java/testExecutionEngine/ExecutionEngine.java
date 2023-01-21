package testExecutionEngine;

import base.WebDriverImpl;
import org.testng.annotations.*;
import utils.CommonUtils;


public class ExecutionEngine {

	public static WebDriverImpl driverImpl = new WebDriverImpl();
	
	/**
	  * Method To load properties file and create report for the reporter
	  */
	@BeforeSuite(alwaysRun = true)
	public void beforeSuiteResource(){
		driverImpl.prop = new CommonUtils().readFromPropertiesFile("config");

	}

	
	/**
	  * Method to initialize and set WebDriver
	  */
	@BeforeClass(alwaysRun = true)
	public void beforeMethodResource(){
		driverImpl.initializeDriver();
		driverImpl.setWebDriverWait();
		driverImpl.setHomeWindow();
	}

	/**
	  * Method to Close browser after method
	  */
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driverImpl.closeBrowser();
	}

	/**
	  * Method flush and close reporter
	  */
	@AfterSuite(alwaysRun = true)
	public void flushReport(){
		//ExtentReport.report.flush();
	}



}