package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
public class AdminSettings_Asset extends TestBase {
	
	@Test(priority = 1)
	public void AdminSettings_Asset_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Asset page testcase 1 ---------");
		test = rep.startTest("AdminSettings_Asset_Navigation");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"assets";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to Asset tab successfully.");
			test.log(LogStatus.PASS,"Navigated to Assets tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte assets page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void AdminSettings_Assets_Validation() throws SQLException {
		
		log.debug("---------Navigate to Assets page testcase 2 ---------");
		test = rep.startTest("AdminSettings_Assets_Validation");

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
			WebElement assets = driver.findElement(By.xpath(OR.getProperty("Assets")));
			assets.click();
			Thread.sleep(3000);
			boolean searchAsset= driver.findElement(By.xpath(OR.getProperty("SearchRole"))).isDisplayed();
			Assert.assertTrue(searchAsset);
			log.debug("validated Assets page successfully.");
			test.log(LogStatus.PASS,"Validated to  Assets page successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to validate Assets page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 3)
	public void AdminSettings_Add_New_Assets() throws SQLException {
		
		log.debug("---------Add new Assets  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_Assets(");

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
			WebElement assets = driver.findElement(By.xpath(OR.getProperty("Assets")));
			assets.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).click();
			boolean addNewAsset= driver.findElement(By.xpath(OR.getProperty("AddAssetValidation"))).isDisplayed();
			System.out.println("8888888888888"+driver.findElement(By.xpath(OR.getProperty("AddAssetValidation"))));
			Assert.assertTrue(addNewAsset);
			log.debug("Add new asset window opened successfully.");
			test.log(LogStatus.PASS,"Add new asset window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new asset window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 4)
	public void AdminSettings_AssetName_AssetDescription_Size() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 4 ---------");
		test = rep.startTest("AdminSettings_AssetName_AssetDescription_Size");

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
			WebElement assets = driver.findElement(By.xpath(OR.getProperty("Assets")));
			assets.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).click();
			WebElement addAssetName= driver.findElement(By.xpath(OR.getProperty("AddAssetName")));
			addAssetName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement addAssetDescription= driver.findElement(By.xpath(OR.getProperty("AddAssetDescription ")));
			addAssetDescription.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			String typedValue1 = addAssetName.getAttribute("value");
			String typedValue2 = addAssetDescription.getAttribute("value");

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
	public void AdminSettings_Add_New_Asset_Details() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 5 ---------");
		test = rep.startTest("AdminSettings_Add_New_Asset_Details");

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
			WebElement assets = driver.findElement(By.xpath(OR.getProperty("Assets")));
			assets.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).click();
			WebElement addAssetName= driver.findElement(By.xpath(OR.getProperty("AddAssetName")));
			addAssetName.sendKeys("Samsung Mobiles");
			WebElement addAssetDescription= driver.findElement(By.xpath(OR.getProperty("AddAssetDescription")));
			addAssetDescription.sendKeys("Nicedevtestdev asset testing");
			
			driver.findElement(By.xpath(OR.getProperty("AssetLocationDrp"))).click();
			WebElement assetLocation= driver.findElement(By.xpath(OR.getProperty("AssetLocationSearchDrp")));
			assetLocation.sendKeys("5 Baner Road");
			driver.findElement(By.xpath(OR.getProperty("SelectAssetLocation"))).click();
			
			driver.findElement(By.xpath(OR.getProperty("AssetTypeDrp"))).click();
			WebElement assetType= driver.findElement(By.xpath(OR.getProperty("AssetTypeSearchDrp")));
			assetType.sendKeys("test asset type");
			driver.findElement(By.xpath(OR.getProperty("SelectAssetType"))).click();
			
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("SaveAssetMsg"))).getText();
			String expectedMsg = "Asset added successfully";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Asset added successfully.");
			test.log(LogStatus.PASS,"Asset added successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to add new asset details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void AdminSettings_SaveEmpty_Asset() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 6 ---------");
		test = rep.startTest("AdminSettings_SaveEmpty_Asset");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("AssetNameRequired"))).getText();
			String expectedMsg = "Asset name is required.";

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
	public void AdminSettings_Reset_Asset_Details() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 7 ---------");
		test = rep.startTest("AdminSettings_Reset_Asset_Details");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).click();
			WebElement addAssetName= driver.findElement(By.xpath(OR.getProperty("AddAssetName")));
			addAssetName.sendKeys("QA Tester");
			driver.findElement(By.xpath(OR.getProperty("ResetAsset"))).click();
			String typedValue1 = driver.findElement(By.xpath(OR.getProperty("AddAssetName"))).getAttribute("value");
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
	public void AdminSettings_Cancle_Add_New_Asset() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Cancle_Add_New_Asset");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("CancelAsset"))).click();
			boolean addNewAsset= driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).isDisplayed();
			Assert.assertTrue(addNewAsset);
			log.debug("Cancle  button functionality is working fine.");
			test.log(LogStatus.PASS,"Cancle button functionality is working fine.");
		
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to cancle the asset details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 9)
	public void AdminSettings_Search_Asset() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Search_Asset");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			WebElement searchAsset = driver.findElement(By.xpath(OR.getProperty("SearchRole")));
			searchAsset.sendKeys("Samsung Mobiles");
			boolean assetName = driver.findElement(By.xpath("//td[contains(text(),'Samsung Mobiles')]")).isDisplayed();
			Assert.assertTrue(assetName);
			log.debug("Asset searched successfully.");
			test.log(LogStatus.PASS,"Asset searched successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to search Asset details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_Upadte_Asset() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 9 ---------");
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
			WebElement assets = driver.findElement(By.xpath(OR.getProperty("Assets")));
			assets.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteAssetButton"))).click();
			Thread.sleep(1000);
			boolean assetName = driver.findElement(By.xpath(OR.getProperty("UpdateAssetValidation"))).isDisplayed();
			Assert.assertTrue(assetName);
			log.debug("update asset functionality is working fine.");
			test.log(LogStatus.PASS,"update asset functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the asset details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 11)
	public void AdminSettings_Upadte_Asset_Detials() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 10 ---------");
		test = rep.startTest("AdminSettings_Upadte_Asset_Detials");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteAssetButton"))).click();
			WebElement assetName= driver.findElement(By.xpath(OR.getProperty("UpdateAssetName")));
			assetName.clear();
			assetName.sendKeys("Samsung Automation Tester");
			driver.findElement(By.xpath(OR.getProperty("UpdateAssetDetails"))).click();
			String actualMsg= driver.findElement(By.xpath(OR.getProperty("UpdateAssetMsg"))).getText();
			String expectedMsg= "Asset updated successfully";	
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("update asset details functionality is working fine.");
			test.log(LogStatus.PASS,"update asset details functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the asset details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 12)
	public void AdminSettings_Delete_Asset() throws SQLException {
		
		log.debug("---------Add new asset  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Delete_Asset");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Assets")));
			asset.click();
			Thread.sleep(3000);
			boolean assetName = driver.findElement(By.xpath("//td[contains(text(),'Samsung Automation Tester')]")).isDisplayed();
			if(assetName == true) {
				driver.findElement(By.xpath(OR.getProperty("DeleteAssetButton"))).click();
				driver.findElement(By.xpath(OR.getProperty("ConfirmDeleteAsset"))).click();
				boolean addNewAsset= driver.findElement(By.xpath(OR.getProperty("AddNewAssetButton"))).isDisplayed();
				Assert.assertTrue(addNewAsset);
				log.debug("Delete asset functionality is working fine.");
				test.log(LogStatus.PASS,"Delete asset functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to delete the asset details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	
}

