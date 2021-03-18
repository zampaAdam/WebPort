package com.goDeskless.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import com.goDeskless.base.TestBase;

public class Login_Positive_Testcase extends TestBase {
	
	
	@Test(priority = 1)
	public void SignIn_Valid_Credentials() throws SQLException, InterruptedException {
		test = rep.startTest("SignIn_Valid_Credentials");
		log.debug("---------Check Correct credentials sign-in testcase---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		Thread.sleep(10000);
		String actualURL = driver.getCurrentUrl();
	    String expectedURL = instanceurl+"dashboard";
	    try {
	    	Assert.assertEquals(actualURL, expectedURL);
		    test.log(LogStatus.PASS, "Sign-in successfully");
	    }catch (Exception e) {
			// TODO: handle exception
	    	test.log(LogStatus.FAIL,e);
		}
	    
	}
	
	@Test(priority = 2)
	public void SignIn_Verify_Forgot_Password() throws SQLException {
		
		test = rep.startTest("SignIn_Forgot_Password");

		log.debug("---------Check Forgot password button testcase---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);

		log.debug("User Name is entered");
		WebElement ForgotPassword = driver.findElement(By.xpath(OR.getProperty("ForgotPassword")));
		ForgotPassword.click();
		log.debug("Forgot Password button  is clicked");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String actual_message = driver.findElement(By.xpath("//p[text()='Please enter your email Id']")).getText();

		String expected_message = "Please enter your email Id";
		log.debug("Forgot Password child window is opened.");
		
		try {
			Assert.assertEquals(actual_message,expected_message);
			log.info("Correct message displyed on forgot password child window");
			test.log(LogStatus.PASS, "Correct message displayed on forgot password child window");
			
		}catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 3)
	public void SignIn_ForgotPassword_Verification() throws SQLException {

		test = rep.startTest("SignIn_ForgotPassword_Verification");

		log.debug("---------Check forgot password verification testcase---------");

		WebElement ForgotPassword = driver.findElement(By.xpath(OR.getProperty("ForgotPassword")));
		ForgotPassword.click();
		log.debug("Forgot Password button  is clicked");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		WebElement EmailId = driver.findElement(By.xpath(OR.getProperty("EnterMailID")));
		EmailId.sendKeys(username);
		log.debug("Email ID is entered");
		
		WebElement Submit = driver.findElement(By.xpath(OR.getProperty("Submit")));
		Submit.click();
		log.debug("Submit button is clicked");

		String Actualmessage = driver.findElement(By.xpath(OR.getProperty("ResetPasswordLink"))).getText();
		String Expectedmessage = "Reset password link sent to your registered email Id. Please check your emails.";
		try {
			Assert.assertEquals(Actualmessage,Expectedmessage);
			log.info("Correct message is displayed after submiting email for forgot password");
			test.log(LogStatus.PASS,"Correct message is displayed after submiting email for forgot password");
		}catch (Exception e) {
			log.error("InCorrect message is displayed after submiting email for forgot password");
			test.log(LogStatus.FAIL,e);
			

		}
	}
	

	@Test(priority = 4)
	
	public void SignIn_Verify_Remember_Password() throws SQLException {

		test = rep.startTest("SignIn_Verify_Remember_Password");

		log.debug("---------Check Remember Password testcase ---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);

		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement RememberPassword = driver.findElement(By.xpath(OR.getProperty("RememberPassword")));
		RememberPassword.click();
		log.debug("Remember Password checkbox is checked.");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		Reporter.log("SignIn button is clicked");

		try {
			Thread.sleep(5000);
			WebElement Logout = driver.findElement(By.xpath(OR.getProperty("Logout")));
			Logout.click();
			log.debug("Logout button is clicked");
			Assert.assertTrue(true);
			test.log(LogStatus.PASS,"Test case passed after click on check remember checkbox");
		}catch (Exception e) {
			// TODO: handle exception
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 5)
	public void SignIn_Verify_Terms_Condition() {
		
		test = rep.startTest("SignIn_Verify_Terms_Condition");

		log.debug("---------Check Terms and Condition testcase ---------");
		WebElement TermsConditions = driver.findElement(By.xpath(OR.getProperty("TermsConditions")));
		TermsConditions.click();
		log.debug("Terms & Conditions link is clicked");
		String parentWindow = driver.getWindowHandle();

		// get all the windows
		Set<String> allWindows = driver.getWindowHandles(); // No of windows=2 //
		allWindows.remove(parentWindow);
		Iterator<String> ite = allWindows.iterator();

		// So now Set contains only new tab window only,so switch to it
		driver.switchTo().window((String) ite.next());
		log.debug("User is switched to new tab");
		
		String ActualPageTitle = driver.getTitle();
		String expectedPageTitle = "Privacy Policy – goDeskless";

		SoftAssert softAssertion = new SoftAssert(); //
		log.info("softAssert Method Was Started");
		try {
		softAssertion.assertEquals(ActualPageTitle, expectedPageTitle);
		log.debug("Verifying newly opened tab page title");
		softAssertion.assertAll();
		log.debug("User is navigated to privacy policy - goDeskless ");
		test.log(LogStatus.PASS,"User is navigated to Privacy Policy - goDeskless");
		}catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL,e);
		}

	}
	
	@Test(priority = 6)
	public void SignIn_Verify_PrivacyPolicy() {
		
		test = rep.startTest("SignIn_Verify_PrivacyPolicy");

		log.debug("---------Check Privacy Policy testcase ---------");
		WebElement PrivacyPolicy = driver.findElement(By.xpath(OR.getProperty("PrivacyPolicy")));
		PrivacyPolicy.click();
		log.debug("Privacy Policy link is clicked");
		String parentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		allWindows.remove(parentWindow);

		Iterator<String> ite = allWindows.iterator();

		driver.switchTo().window((String) ite.next());
		log.debug("User is switched to new tab");

		String ActualPageTitle = driver.getTitle();
		String expectedPageTitle = "Privacy Policy – goDeskless";

		SoftAssert softAssertion = new SoftAssert(); //
		log.info("softAssert Method Was Started");
		try {
			softAssertion.assertEquals(ActualPageTitle, expectedPageTitle);
			log.debug("Verifying newly opened tab page title");
			softAssertion.assertAll();
			log.debug("User is navigated to Privacy Policy - goDeskless");
			test.log(LogStatus.PASS,"User is navigated to Privacy Policy - goDeskless");
		}catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL,e);
		}

	}

}
