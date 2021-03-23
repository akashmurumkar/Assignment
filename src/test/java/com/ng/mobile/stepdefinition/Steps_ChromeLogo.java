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
import io.cucumber.java.en.When;

public class Steps_ChromeLogo {

	AppiumDriver<MobileElement> driver;

	@Given("user is on homepage")
	public void user_is_on_homepage() throws InterruptedException, MalformedURLException {
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

		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}

	@When("user verifies the title")
	public void user_verifies_the_title() {
		MobileElement button = driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
		button.click();

		MobileElement header = driver.findElement(By.id("io.selendroid.testapp:id/tableHeader"));
		Assert.assertEquals(header.getText(), "Web View Interaction");
	}

	@When("verify text header")
	public void verify_text_header() {
		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.widget.TextView";
		MobileElement headerText = driver.findElement(By.xpath(xpath));
		Assert.assertEquals(headerText.getText(), "Hello, can you please tell me your name?");
	}

	@Then("enters name as {string}")
	public void enters_name_as(String string) {
		MobileElement name = driver.findElement(By.id("name_input"));
		name.sendKeys("Akash");
	}

}
