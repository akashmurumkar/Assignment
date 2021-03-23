package com.ng.mobile.stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Steps_ApplicationScreen {
	
	AppiumDriver<MobileElement> driver;
	
	@Given("user launches application")
	public void user_launches_application() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "POCO F1");
		cap.setCapability("udid", "28a0da77");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application started");
		
		MobileElement continueButton = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		continueButton.click();

		Thread.sleep(2000);

		MobileElement okButton = driver.findElement(By.id("android:id/button1"));
		okButton.click();

		Thread.sleep(2000);
	}

	@Then("user verifies title")
	public void user_verifies_title() {
		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}

	@Then("user verifies elements on application")
	public void user_verifies_elements_on_application() {
		MobileElement ENButton = driver.findElement(By.id("io.selendroid.testapp:id/buttonTest"));
		Assert.assertEquals(ENButton.isDisplayed(), true);
	}

}
