package com.goDeskless.testcases;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class AdminSetting_AssetType extends TestBase {
	
	@Test(priority = 1)
	public void AdminSettings_AssetType_Navigation() throws SQLException {
		
		log.debug("---------Navigate to AssetType page testcase 1 ---------");
		test = rep.startTest("AdminSettings_AssetType_Navigation");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			asset.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"asset-type";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to AssetType tab successfully.");
			test.log(LogStatus.PASS,"Navigated to AssetType tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte assets page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void AdminSettings_AssetTypes_Validation() throws SQLException {
		
		log.debug("---------Navigate to AssetTypes page testcase 2 ---------");
		test = rep.startTest("AdminSettings_AssetTypes_Validation");

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
			WebElement assetsType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetsType.click();
			Thread.sleep(3000);
			boolean searchAssetType= driver.findElement(By.xpath(OR.getProperty("SearchRole"))).isDisplayed();
			Assert.assertTrue(searchAssetType);
			log.debug("validated AssetTypes page successfully.");
			test.log(LogStatus.PASS,"Validated to  AssetTypes page successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to validate AssetTypes page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 3)
	public void AdminSettings_Add_New_AssetType() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_AssetType(");

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
			WebElement assetsType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetsType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).click();
			boolean addNewAssetType= driver.findElement(By.xpath("//button[contains(text(),'Save')]")).isDisplayed();
			Assert.assertTrue(addNewAssetType);
			log.debug("Add new asset-type window opened successfully.");
			test.log(LogStatus.PASS,"Add new asset-type window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new asset-type window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 4)
	public void AdminSettings_AssetTypeName_AssetTypeDescription_Size() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 4 ---------");
		test = rep.startTest("AdminSettings_AssetTypeName_AssetTypeDescription_Size");

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
			WebElement assetsType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetsType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).click();
			WebElement addAssetTypeName= driver.findElement(By.xpath(OR.getProperty("AddAssetTypeName")));
			addAssetTypeName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement addAssetTypeDescription= driver.findElement(By.xpath(OR.getProperty("AddAssetTypeDescription")));
			addAssetTypeDescription.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			String typedValue1 = addAssetTypeName.getAttribute("value");
			String typedValue2 = addAssetTypeDescription.getAttribute("value");

			// Get the length of typed value
			int assetNameSize = typedValue1.length();
			int assetDescriptionSize = typedValue2.length();
			// Assert with expected
			if (assetNameSize == 50 && assetDescriptionSize == 50) {
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
	public void AdminSettings_Add_New_AssetType_Details() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 5 ---------");
		test = rep.startTest("AdminSettings_Add_New_AssetType_Details");

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
			WebElement assetsType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetsType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).click();
			WebElement addAssetTypeName= driver.findElement(By.xpath(OR.getProperty("AddAssetTypeName")));
			addAssetTypeName.sendKeys("Stabilizer");
			WebElement addAssetTypeDescription= driver.findElement(By.xpath(OR.getProperty("AddAssetTypeDescription")));
			addAssetTypeDescription.sendKeys("Stabilizer asset-type testing");
			
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("SaveAssetTypeMsg"))).getText();
			String expectedMsg = "Asset type added successfully";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("AssetType added successfully.");
			test.log(LogStatus.PASS,"AssetType added successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to add new asset-type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void AdminSettings_SaveEmpty_AssetType() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 6 ---------");
		test = rep.startTest("AdminSettings_SaveEmpty_AssetType");

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
			WebElement assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("AssetTypeNameRequired"))).getText();
			String expectedMsg = "Asset type name is required.";

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
	public void AdminSettings_Reset_AssetType_Details() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 7 ---------");
		test = rep.startTest("AdminSettings_Reset_AssetType_Details");

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
			WebElement assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).click();
			WebElement addAssetTypeName= driver.findElement(By.xpath(OR.getProperty("AddAssetTypeName")));
			addAssetTypeName.sendKeys("QA Tester");
			driver.findElement(By.xpath(OR.getProperty("ResetAssetType"))).click();
			String typedValue1 = driver.findElement(By.xpath(OR.getProperty("AddAssetTypeName"))).getAttribute("value");
			if(typedValue1.isEmpty())
			{
				Assert.assertTrue(true);
				log.debug("Reset button functionality is working fine.");
				test.log(LogStatus.PASS,"Reset button functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to reset the asset-type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AdminSettings_Cancle_Add_New_AssetType() throws SQLException {
		
		log.debug("---------Add new Asset Type testcase 8 ---------");
		test = rep.startTest("AdminSettings_Cancle_Add_New_AssetType");

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
			WebElement assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("CancelAssetType"))).click();
			boolean addNewAssetType= driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).isDisplayed();
			Assert.assertTrue(addNewAssetType);
			log.debug("Cancle  button functionality is working fine.");
			test.log(LogStatus.PASS,"Cancle button functionality is working fine.");
		
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to cancle the asset-type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 9)
	public void AdminSettings_Search_AssetType() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Search_AssetType");

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
			WebElement assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetType.click();
			Thread.sleep(3000);
			WebElement searchAssetType = driver.findElement(By.xpath(OR.getProperty("SearchRole")));
			searchAssetType.sendKeys("Stabilizer");
			boolean assetName = driver.findElement(By.xpath("//td[contains(text(),'Stabilizer')]")).isDisplayed();
			Assert.assertTrue(assetName);
			log.debug("Asset Type searched successfully.");
			test.log(LogStatus.PASS,"Asset Type searched successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to search Asset Type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_Upadte_AssetType() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 9 ---------");
		test = rep.startTest("AdminSettings_Upadte_Asset");

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
			WebElement assetsType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetsType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteAssetTypeButton"))).click();
			Thread.sleep(1000);
			boolean assetTypeName = driver.findElement(By.xpath(OR.getProperty("UpdateAssetTypeValidation"))).isDisplayed();
			Assert.assertTrue(assetTypeName);
			log.debug("update asset-type functionality is working fine.");
			test.log(LogStatus.PASS,"update asset-type functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the asset-type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 11)
	public void AdminSettings_Upadte_AssetType_Detials() throws SQLException {
		
		log.debug("---------Add new AssetType  testcase 10 ---------");
		test = rep.startTest("AdminSettings_Upadte_AssetType_Detials");

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
			WebElement assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetType.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteAssetTypeButton"))).click();
			WebElement assetTypeName= driver.findElement(By.xpath(OR.getProperty("UpdateAssetTypeName")));
			assetTypeName.clear();
			assetTypeName.sendKeys("Stabilizer Automation Tester");
			driver.findElement(By.xpath(OR.getProperty("UpdateAssetTypeDetails"))).click();
			String actualMsg= driver.findElement(By.xpath(OR.getProperty("UpdateAssetTypeMsg"))).getText();
			String expectedMsg= "Asset type updated successfully";	
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("update asset-type details functionality is working fine.");
			test.log(LogStatus.PASS,"update asset-type details functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the asset-type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 12)
	public void AdminSettings_Delete_AssetType() throws SQLException {
		
		log.debug("---------Add new asset Type  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Delete_AssetType");

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
			WebElement assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes")));
			assetType.click();
			Thread.sleep(3000);
			boolean assetTypeName = driver.findElement(By.xpath("//td[contains(text(),'Stabilizer Automation Tester')]")).isDisplayed();
			if(assetTypeName == true) {
				driver.findElement(By.xpath(OR.getProperty("DeleteAssetTypeButton"))).click();
				driver.findElement(By.xpath(OR.getProperty("ConfirmDeleteAssetType"))).click();
				boolean addNewAssetType= driver.findElement(By.xpath(OR.getProperty("AddNewAssetTypeButton"))).isDisplayed();
				Assert.assertTrue(addNewAssetType);
				log.debug("Delete asset-type functionality is working fine.");
				test.log(LogStatus.PASS,"Delete asset-type functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to delete the asset-type details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	
}