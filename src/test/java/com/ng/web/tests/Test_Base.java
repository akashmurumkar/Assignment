package com.ng.web.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cg.utils.SeleniumUtil;

public class Test_Base {

	SeleniumUtil selenium;

	@BeforeClass
	public void setup() {
		selenium = SeleniumUtil.getInstance();
	}

	@AfterClass
	public void tearDown() {
		if (selenium.driver != null)
			selenium.driver.quit();
	}
}
