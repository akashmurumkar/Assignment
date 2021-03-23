package com.ng.mobile.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/Selendroid.feature"
		, tags = "@Scenario6"
		, glue = "com.ng.mobile.stepdefinition"
		, plugin = {"pretty", "html:results/MobileTest_Results_Scenario6.html"}
		, monochrome = true
		)

@Test
public class Runner_Toast extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Testing Started");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Testing Ended");
	}
	
}