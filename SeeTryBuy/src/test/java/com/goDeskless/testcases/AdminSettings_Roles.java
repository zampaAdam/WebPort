package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class AdminSettings_Roles extends TestBase {
	/*
	@Test(priority = 1)
	public void AdminSettings_Roles_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Roles page testcase 1 ---------");
		test = rep.startTest("AdminSettings_Roles_Navigation");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"roles";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to Role tab successfully.");
			test.log(LogStatus.PASS,"Navigated to Role tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte roles page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void AdminSettings_Roles_Validation() throws SQLException {
		
		log.debug("---------Navigate to Roles page testcase 2 ---------");
		test = rep.startTest("AdminSettings_Roles_Validation");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			boolean searchRole= driver.findElement(By.xpath(OR.getProperty("SearchRole"))).isDisplayed();
			Assert.assertTrue(searchRole);
			log.debug("validated Role page successfully.");
			test.log(LogStatus.PASS,"Validated to  role page successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to validate role page");
		test.log(LogStatus.FAIL,e);
		}
	}*/
	
	@Test(priority = 3)
	public void AdminSettings_Add_New_Role() throws SQLException {
		
		log.debug("---------Add new Group  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_Role(");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).click();
			boolean addNewRole= driver.findElement(By.xpath(OR.getProperty("AddRoleValidation"))).isDisplayed();
			Assert.assertTrue(addNewRole);
			log.debug("Add new role window opened successfully.");
			test.log(LogStatus.PASS,"Add new role window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new role window");
		test.log(LogStatus.FAIL,e);
		}
	}
	/*
	@Test(priority = 4)
	public void AdminSettings_RoleName_RoleDescription_Size() throws SQLException {
		
		log.debug("---------Add new Group  testcase 4 ---------");
		test = rep.startTest("AdminSettings_RoleName_RoleDescription_Size");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).click();
			WebElement addroleName= driver.findElement(By.xpath(OR.getProperty("AddRoleName")));
			addroleName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement addRoleDescription= driver.findElement(By.xpath(OR.getProperty("AddRoleDescription")));
			addRoleDescription.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			String typedValue1 = addroleName.getAttribute("value");
			String typedValue2 = addRoleDescription.getAttribute("value");

			// Get the length of typed value
			int roleNameSize = typedValue1.length();
			int roleDescriptionSize = typedValue2.length();
			// Assert with expected
			if (roleNameSize == 50 && roleDescriptionSize == 50) {
				Assert.assertTrue(true);
				log.debug("Max character functionality is working fine.");
				test.log(LogStatus.PASS,"Max character functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to check Max character functionality");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 5)
	public void AdminSettings_Add_New_Role_Details() throws SQLException {
		
		log.debug("---------Add new Group  testcase 5 ---------");
		test = rep.startTest("AdminSettings_Add_New_Role_Details");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).click();
			WebElement addRoleName= driver.findElement(By.xpath(OR.getProperty("AddRoleName")));
			addRoleName.sendKeys("QA Tester");
			WebElement addRoleDescription= driver.findElement(By.xpath(OR.getProperty("AddRoleDescription")));
			addRoleDescription.sendKeys("Nicedevtestdev testing");
			
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("SaveRoleMsg"))).getText();
			String expectedMsg = "Role added successfully";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Role added successfully.");
			test.log(LogStatus.PASS,"Role added successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to add new role details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void AdminSettings_SaveEmpty_Role() throws SQLException {
		
		log.debug("---------Add new Role  testcase 6 ---------");
		test = rep.startTest("AdminSettings_SaveEmpty_Role");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("RoleNameRequired"))).getText();
			String expectedMsg = "Role name is required.";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Correct messages are displayed on saving empty details.");
			test.log(LogStatus.PASS,"Correct messages are displayed on saving empty details.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to save empty details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 7)
	public void AdminSettings_Reset_Role_Details() throws SQLException {
		
		log.debug("---------Add new Role  testcase 7 ---------");
		test = rep.startTest("AdminSettings_Reset_Role_Details");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).click();
			WebElement addRoleName= driver.findElement(By.xpath(OR.getProperty("AddRoleName")));
			addRoleName.sendKeys("QA Tester");
			driver.findElement(By.xpath(OR.getProperty("ResetButton"))).click();
			
			String typedValue1 = driver.findElement(By.xpath(OR.getProperty("AddRoleName"))).getAttribute("value");
			if(typedValue1.isEmpty())
			{
				Assert.assertTrue(true);
				log.debug("Reset button functionality is working fine.");
				test.log(LogStatus.PASS,"Reset button functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to reset the role details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AdminSettings_Cancle_Add_New_Role() throws SQLException {
		
		log.debug("---------Add new Group  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Cancle_Add_New_Role");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("CancleRole"))).click();
			boolean addNewRole= driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).isDisplayed();
			Assert.assertTrue(addNewRole);
			log.debug("Cancle  button functionality is working fine.");
			test.log(LogStatus.PASS,"Cancle button functionality is working fine.");
		
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to cancle the role details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 9)
	public void AdminSettings_Search_Role() throws SQLException {
		
		log.debug("---------Add new Group  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Search_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			WebElement searchRole = driver.findElement(By.xpath(OR.getProperty("SearchRole")));
			searchRole.sendKeys("QA Tester");
			boolean roleName = driver.findElement(By.xpath("//td[contains(text(),'QA Tester')]")).isDisplayed();
			Assert.assertTrue(roleName);
			log.debug("Role searched successfully.");
			test.log(LogStatus.PASS,"Role searched successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to search role details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_Upadte_Role() throws SQLException {
		
		log.debug("---------Add new Role  testcase 9 ---------");
		test = rep.startTest("AdminSettings_Upadte_Role");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteRoleButton"))).click();
			Thread.sleep(1000);
			boolean roleName = driver.findElement(By.xpath(OR.getProperty("UpdateRoleValidation"))).isDisplayed();
			Assert.assertTrue(roleName);
			log.debug("update role functionality is working fine.");
			test.log(LogStatus.PASS,"update role functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the role details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 11)
	public void AdminSettings_Upadte_Role_Detials() throws SQLException {
		
		log.debug("---------Add new Role  testcase 10 ---------");
		test = rep.startTest("AdminSettings_Upadte_Role_Detials");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteRoleButton"))).click();
			WebElement roleName= driver.findElement(By.xpath(OR.getProperty("UpdateRoleName")));
			roleName.clear();
			roleName.sendKeys("QA Automation Tester");
			driver.findElement(By.xpath(OR.getProperty("UpdateRoleDetails"))).click();
			String actualMsg= driver.findElement(By.xpath(OR.getProperty("UpdateRoleMsg"))).getText();
			String expectedMsg= "Role updated successfully";	
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("update role details functionality is working fine.");
			test.log(LogStatus.PASS,"update role details functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the role details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 12)
	public void AdminSettings_Delete_Role() throws SQLException {
		
		log.debug("---------Add new role  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Delete_Role");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement roles = driver.findElement(By.xpath(OR.getProperty("Roles")));
			roles.click();
			Thread.sleep(3000);
			boolean roleName = driver.findElement(By.xpath("//td[contains(text(),'QA Automation Tester')]")).isDisplayed();
			if(roleName == true) {
				driver.findElement(By.xpath(OR.getProperty("DeleteRoleButton"))).click();
				driver.findElement(By.xpath(OR.getProperty("ConfirmDeleteRole"))).click();
				boolean addNewRole= driver.findElement(By.xpath(OR.getProperty("AddNewRoleButton"))).isDisplayed();
				Assert.assertTrue(addNewRole);
				log.debug("Delete role functionality is working fine.");
				test.log(LogStatus.PASS,"Delete role functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to delete the role details");
		test.log(LogStatus.FAIL,e);
		}
	}*/
	
	
}
