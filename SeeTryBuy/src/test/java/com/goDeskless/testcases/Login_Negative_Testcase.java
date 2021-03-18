package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Login_Negative_Testcase extends TestBase  {
	
	@Test(priority = 1)
	public void SignIn_Invalid_credentials() throws SQLException {
		
		test = rep.startTest("SignIn_Invalid_credentials");
		log.debug("---------Check Incorrect username password testcase---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys("welcome12");
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");

		String actualmessage="";
		actualmessage = driver.findElement(By.id("passErrorMessage")).getText();
		String expectedmessage = "Error! Username and Password does not match..";

		try {
			Assert.assertEquals(actualmessage, expectedmessage);
			log.debug("A correct message is displayed");
			test.log(LogStatus.PASS, "A correct message is displayed");

		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Incorrect message is displayed");
			test.log(LogStatus.FAIL,e);
		}
		
	}
	
	@Test(priority = 2)
	public void SignIn_Verify_Password_Lenght() throws SQLException {
		
		test = rep.startTest("SignIn_Verify_Password_Lenght");

		log.debug("---------Check password required length message testcase---------");
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
		Password.sendKeys(password.substring(password.length() - 4));
		log.debug("Password is entered");
		
		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		
		String actualpasslength = driver.findElement(By.xpath("//p[text()='Password should contain atleast 8 characters']")).getText();
		String expectedPasslength ="Password should contain atleast 8 characters";
		try {
			Assert.assertEquals(actualpasslength, expectedPasslength);
			test.log(LogStatus.PASS,"Correct message displyed for password length");
		}catch (Exception e) {
			test.log(LogStatus.FAIL,e);
		}
		
	}
	
	@Test(priority = 3)
	public void SignIn_Verify_Unauthorized_User() throws SQLException {
		
		test = rep.startTest("SignIn_Verify_Unauthorized_User");

		log.debug("---------Check unauthorized user acces testcase---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys("vaishali@way.com");
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		String actualmessage="";
		String expectedmessage = "Error! User Does not exist..";

		try {
			actualmessage = driver.findElement(By.id("passErrorMessage")).getText();
			Assert.assertEquals(actualmessage, expectedmessage);
			log.debug("A correct message is displayed");
			test.log(LogStatus.PASS,"Correct message is displyed for unauthorized user access");
			
		}catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL,e);
			
		}
		
	}
	
	@Test(priority = 4)
	public void SignIn_Verify_Empty_Username() throws SQLException {
		
		test = rep.startTest("SignIn_Verify_Empty_Username");

		log.debug("---------Check empty username field testcase---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		String actualerrormsg = driver.findElement(By.xpath(OR.getProperty("usernameErorMsg"))).getText();
		String expectederrormsg ="Email is required.";
		try {
			Assert.assertEquals(actualerrormsg, expectederrormsg);
			test.log(LogStatus.PASS,"Correct ,message is displayed for empty username field");
		}catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 5)
	public void SignIn_Verify_Empty_Password() throws SQLException {
		
		test = rep.startTest("SignIn_Verify_Empty_Password");

		log.debug("---------Check empty password field testcase---------");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);

		log.debug("User Name is entered");
		
		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		
		String actualerrormsg = driver.findElement(By.xpath(OR.getProperty("PasswordErorMsg"))).getText();
		String expectederrormsg ="Password is required.";
		try{
			Assert.assertEquals(actualerrormsg, expectederrormsg);
			log.info("Correct message is displyed");
			test.log(LogStatus.PASS,"A correct message is displayed");
		}catch (Exception e) {
			// TODO: handle exception
			log.info("Incorrect message is displyed");
			test.log(LogStatus.FAIL,e);
			
		}
	}
	
	@Test(priority = 6)
	public void SignIn_Verify_Empty_Username_Password() throws SQLException {
		
		log.debug("---------Check Empty username and  password testcase---------");
		
		test = rep.startTest("SignIn_Verify_Empty_Username_Password");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		
		boolean  userreqmsg= driver.findElement(By.xpath(OR.getProperty("usernameErorMsg"))).isDisplayed();
		boolean  passreqmsg = driver.findElement(By.xpath(OR.getProperty("PasswordErorMsg"))).isDisplayed();
		
		try {
			Assert.assertTrue(userreqmsg);
			log.info("Correct email id required message is displyed");
			Assert.assertTrue(passreqmsg);
			log.info("Correct password required message is displyed");
			test.log(LogStatus.PASS,"Correct email id and password required message is displayed");
		}catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL,e);
		}

	}
	
	@Test(priority = 7)
	public void SignIn_InvalidEmail_Forgot_password() throws SQLException {

		test = rep.startTest("SignIn_InvalidEmail_Forgot_password");

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
		EmailId.sendKeys(username.substring(username.length() - 4));
		log.debug("Email ID is entered");
		
		String ActualMessage = driver.findElement(By.xpath(OR.getProperty("ValidEmailId"))).getText();
		String ExpectedMessage = "Please enter a valid email!";
		try {
			Assert.assertEquals(ActualMessage,ExpectedMessage);
			log.info("Expected message is displayed");
			test.log(LogStatus.PASS,"Correct message is displayed for invalid email");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect message is displayed for invalid email");
			test.log(LogStatus.PASS,e);
		}
		
	}
}
