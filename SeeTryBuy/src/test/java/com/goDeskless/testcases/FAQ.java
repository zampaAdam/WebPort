package com.goDeskless.testcases;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class FAQ extends TestBase {
	
	@Test(priority = 1)
	public void FAQ_Navigation() throws SQLException {
		
		log.debug("---------Navigate to FAQ page testcase 1 ---------");
		test = rep.startTest("FAQ_Navigation");

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
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"faq";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to FAQ successfully.");
			test.log(LogStatus.PASS,"Navigated to FAQ successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte FAQ page");
		test.log(LogStatus.FAIL,e);
		}
	}
}