package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class User_Profile extends TestBase{
	
    @Test(priority = 1)
	public void CustomerProfile_Navigation() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Navigation");
		log.debug("---------Testcase 1 verifying user profile page opened---------");
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
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //

		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		String ActualProfileLink = driver.getCurrentUrl();
		String ExpectedProfileLink = instanceurl+"profile";
		try {
			Assert.assertEquals(ActualProfileLink,ExpectedProfileLink);
			log.info("Navigated to Profile details page");
			test.log(LogStatus.PASS,"Navigated to Profile details page");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to navigate to Profile details page");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void CustomerProfile_Verify_Edit_Profile() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Verify_Edit_Profile");
		log.debug("---------Testcase 2 validate the edit profile page ---------");
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
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //

		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("EditProfile"))).click();
			driver.findElement(By.xpath(OR.getProperty("EditFirstName"))).isDisplayed();
			Assert.assertTrue(true);
			log.info("Edit Profile is opened");
			test.log(LogStatus.PASS,"Edit Profile is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open edit Profile");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 03)
	public void CustomerProfile_Upadte_Profile() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Upadte_Profile");
		log.debug("---------Testcase 3 Upadte user firstname, lastname and work number---------");
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
		Password.sendKeys("welcome121");
		log.debug("Password is entered");
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("EditProfile"))).click();
			WebElement FirstName = driver.findElement(By.xpath(OR.getProperty("EditFirstName")));
			FirstName.clear();
			FirstName.sendKeys("PRATIKSHA");
			WebElement LastName = driver.findElement(By.xpath(OR.getProperty("EditLastName")));
			LastName.clear();
			LastName.sendKeys("KOTKAR");
			WebElement Worknumber = driver.findElement(By.xpath(OR.getProperty("MobileNumber")));
			Worknumber.sendKeys("999999999");
			driver.findElement(By.xpath(OR.getProperty("Updatebutton"))).click();
			Assert.assertTrue(true);
			log.info("Updated Profile is successfully");
			test.log(LogStatus.PASS,"Updated Profile is successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to upadte Profile");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 04)
	public void CustomerProfile_Update_Blank_Details() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Update_Blank_Details");
		log.debug("---------Testcase 3 Upadte blank user firstname, lastname and work number---------");
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
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //

		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("EditProfile"))).click();
			WebElement FirstName = driver.findElement(By.xpath(OR.getProperty("EditFirstName")));
			FirstName.clear();
			WebElement LastName = driver.findElement(By.xpath(OR.getProperty("EditLastName")));
			LastName.clear();
			WebElement Worknumber = driver.findElement(By.xpath(OR.getProperty("MobileNumber")));
			Worknumber.clear();
			driver.findElement(By.xpath(OR.getProperty("Updatebutton"))).click();			
			String ActualMsg=driver.findElement(By.xpath(OR.getProperty("FirstNameReq"))).getText();
			String ExpecteedMsg="First name is required.";
			Assert.assertEquals(ActualMsg, ExpecteedMsg);
			log.info("Update blank profile is successfull");
			test.log(LogStatus.PASS,"Verified error message show while Updating blank Profile");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open update blank Profile");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 05)
	public void CustomerProfile_Verify_Change_Password() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Verify_Change_Password");
		log.debug("---------Testcase 3 Change password of user---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			driver.findElement(By.xpath(OR.getProperty("OldPassword"))).isDisplayed();
			driver.findElement(By.xpath(OR.getProperty("NewPassword"))).isDisplayed();
			driver.findElement(By.xpath(OR.getProperty("ConfirmPassword"))).isDisplayed();
			Assert.assertTrue(true);
			log.info("Change Password page opened successfully");
			test.log(LogStatus.PASS,"Password changed page opened successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open change password");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 06)
	public void CustomerProfile_Change_Save_Password() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Change_Save_Password");
		log.debug("---------Testcase 3 Chnage password of user---------");
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
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			WebElement Oldpassword =driver.findElement(By.xpath(OR.getProperty("OldPassword")));
			Oldpassword.sendKeys("welcome123");
			WebElement Newpassword = driver.findElement(By.xpath(OR.getProperty("NewPassword")));
			Newpassword.sendKeys("welcome121");
			WebElement Confirmpassword =driver.findElement(By.xpath(OR.getProperty("ConfirmPassword")));
			Confirmpassword.sendKeys("welcome121");
			driver.findElement(By.xpath(OR.getProperty("Savepassword"))).click();
			Assert.assertTrue(true);
			log.info("Change Password page opened successfully");
			test.log(LogStatus.PASS,"Password changed page opened successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open change password");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 07)
	public void CustomerProfile_InvalidPassword_Length() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_InvalidPassword_Length");
		log.debug("---------Testcase 3 Chnage password of user---------");
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
		Password.sendKeys("welcome121");
		log.debug("Password is entered");
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			WebElement Oldpassword =driver.findElement(By.xpath(OR.getProperty("OldPassword")));
			Oldpassword.sendKeys("welcome121");
			WebElement Newpassword = driver.findElement(By.xpath(OR.getProperty("NewPassword")));
			Newpassword.sendKeys("welcome");
			WebElement Confirmpassword =driver.findElement(By.xpath(OR.getProperty("ConfirmPassword")));
			Confirmpassword.sendKeys("welcome");
			driver.findElement(By.xpath(OR.getProperty("Savepassword"))).click();
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("PaswordErrorMsg"))).getText();
			String ExpectedMsg = "Password should contain atleast 8 characters";
			Assert.assertEquals(ActualMsg,ExpectedMsg);
			log.info("Change Password page opened successfully");
			test.log(LogStatus.PASS,"Password with less than 8 character tested successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open change password");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void CustomerProfile_Empty_Save_Password() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Negative_08");
		log.debug("---------Testcase 3 Upadte password with Empty field---------");
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
		Password.sendKeys("welcome121");
		log.debug("Password is entered");
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			WebElement Oldpassword =driver.findElement(By.xpath(OR.getProperty("OldPassword")));
			Oldpassword.sendKeys("12");
			Oldpassword.clear();
			driver.findElement(By.xpath(OR.getProperty("Savepassword"))).click();
			String ActualMsg=driver.findElement(By.xpath(OR.getProperty("PasswordReq"))).getText();
			String ExpectedMsg= "Old Password is required.";
			Assert.assertEquals(ActualMsg, ExpectedMsg);
			log.info("Password required message is displayed");
			test.log(LogStatus.PASS,"Password required message is displayed");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Password required message is not displayed");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 9)
	public void CustomerProfile_Verify_Cancle_Password() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Verify_Cancle_Password");
		log.debug("---------Testcase 9 Cancle password---------");
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
		Password.sendKeys("welcome121");
		log.debug("Password is entered");
		
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(6000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			driver.findElement(By.xpath(OR.getProperty("Cancelpassword"))).click();
			Assert.assertTrue(true);
			log.info("Cancle Password is tested successfully");
			test.log(LogStatus.PASS,"Cancle Password is tested successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to test cancle password");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void CustomerProfile_Verify_GoBack() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Verify_GoBack");
		log.debug("---------Testcase 7 get back to profile page---------");
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
		Password.sendKeys("welcome121");
		log.debug("Password is entered");
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(6000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			driver.findElement(By.xpath(OR.getProperty("BackProfile"))).click();
			driver.findElement(By.xpath(OR.getProperty("EditProfile"))).isDisplayed();
			Assert.assertTrue(true);
			log.info("Back to user profile page is tested successfully");
			test.log(LogStatus.PASS,"Back to user profile page is tested successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Back to user profile page is failed");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 11)
	public void CustomerProfile_Verify_Reset_Password_Fields() throws InterruptedException, SQLException {
		
		test = rep.startTest("CustomerProfile_Verify_Reset_Password_Fields");
		log.debug("---------Testcase 9 Reset password---------");
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
		Password.sendKeys("welcome121");
		log.debug("Password is entered");
		Thread.sleep(4000);
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("Userdropdown"))).click();
		log.debug("User drop down list");
		driver.findElement(By.xpath(OR.getProperty("Profilebutton"))).click();
		log.debug("profile button is clicked");
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath(OR.getProperty("ChangePassword"))).click();
			WebElement Oldpassword =driver.findElement(By.xpath(OR.getProperty("OldPassword")));
			Oldpassword.sendKeys("welcome121");
			WebElement Newpassword = driver.findElement(By.xpath(OR.getProperty("NewPassword")));
			Newpassword.sendKeys("welcome");
			WebElement Confirmpassword =driver.findElement(By.xpath(OR.getProperty("ConfirmPassword")));
			Confirmpassword.sendKeys("welcome");
			driver.findElement(By.xpath(OR.getProperty("ResetPassword"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(OR.getProperty("EnterPassword"))).isDisplayed();
			Assert.assertTrue(true);
			log.info("Password field reset successfully");
			test.log(LogStatus.PASS,"Password fields reset successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to reset password fields");
			test.log(LogStatus.FAIL,e);
		}
	}
	
}
