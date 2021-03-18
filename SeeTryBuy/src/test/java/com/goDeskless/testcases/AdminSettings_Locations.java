package com.goDeskless.testcases;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jaxen.function.ContainsFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
public class AdminSettings_Locations extends TestBase {
	
	@Test(priority = 1)
	public void AdminSettings_Location_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Location page testcase 1 ---------");
		test = rep.startTest("AdminSettings_Location_Navigation");

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
			WebElement asset = driver.findElement(By.xpath(OR.getProperty("Locations")));
			asset.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"locations";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to Location tab successfully.");
			test.log(LogStatus.PASS,"Navigated to Location tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte assets page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void AdminSettings_Location_Validation() throws SQLException {
		
		log.debug("---------Navigate to Location page testcase 2 ---------");
		test = rep.startTest("AdminSettings_Location_Validation");

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
			WebElement Location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			Location.click();
			Thread.sleep(3000);
			boolean searchLocation= driver.findElement(By.xpath(OR.getProperty("SearchRole"))).isDisplayed();
			Assert.assertTrue(searchLocation);
			log.debug("validated Location page successfully.");
			test.log(LogStatus.PASS,"Validated to  Location page successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to validate Location page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 3)
	public void AdminSettings_Add_New_Location() throws SQLException {
		
		log.debug("---------Add new Location  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_Location(");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			Thread.sleep(1000);
			boolean addNewLocation= driver.findElement(By.xpath(OR.getProperty("AddLocationValidation"))).isDisplayed();
			Assert.assertTrue(addNewLocation);
			log.debug("Add new location window opened successfully.");
			test.log(LogStatus.PASS,"Add new location window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new location window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 4)
	public void AdminSettings_Add_New_Location_GoogleMap() throws SQLException {
		
		log.debug("---------Add new Location  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_Location_GoogleMap");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SelectGoogleMap"))).click();
			
			boolean googleMap= driver.findElement(By.xpath(OR.getProperty("GoogleMapVaildation"))).isDisplayed();
			Assert.assertTrue(googleMap);
			log.debug("Add new location through google map window opened successfully.");
			test.log(LogStatus.PASS,"Add new location through google map window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new location google map window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 5)
	public void AdminSettings_Add_GoogleMap_Location_Cancel() throws SQLException {
		
		log.debug("---------Add new Location  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_GoogleMap_Location_Cancel");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SelectGoogleMap"))).click();
			driver.findElement(By.xpath(OR.getProperty("CancelGoogelLocation"))).click();
			boolean googleMap= driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).isDisplayed();
			Assert.assertTrue(googleMap);
			log.debug("Add new location through google map window opened successfully.");
			test.log(LogStatus.PASS,"Add new location through google map window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new location google map window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void AdminSettings_Add_GoogleMap_Location() throws SQLException {
		
		log.debug("---------Add new Location  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_GoogleMap_Location");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SelectGoogleMap"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("GoogleMapVaildation"))).sendKeys("Pune");
			driver.findElement(By.xpath(OR.getProperty("GoogleMapVaildation"))).click();
			WebDriverWait wait = new WebDriverWait(driver,120); // wait 120 seconds until element is visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Autocomplete2")));
			driver.findElement(By.xpath(OR.getProperty("SubmitGoogelLocation"))).click();

			String actualMsg= driver.findElement(By.xpath(OR.getProperty("SaveLocationMsg"))).getText();
			String expectedMsg="Location added successfully";
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Add new location through google map window opened successfully.");
			test.log(LogStatus.PASS,"Add new location through google map window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new location google map window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 7)
	public void AdminSettings_Add_New_ManualLocation() throws SQLException {
		
		log.debug("---------Add new Location  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_Location_ManualLocation");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SelectAddLocation"))).click();
			
			boolean addNewLocation= driver.findElement(By.xpath("//button[contains(text(),'Save')]")).isDisplayed();
			Assert.assertTrue(addNewLocation);
			log.debug("Add new location window opened successfully.");
			test.log(LogStatus.PASS,"Add new location window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new location window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AdminSettings_LocationName_Size() throws SQLException {
		
		log.debug("---------Add new Asset  testcase 4 ---------");
		test = rep.startTest("AdminSettings_LocationName_Size");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			WebElement addLocationName= driver.findElement(By.xpath(OR.getProperty("AddLocationName")));
			addLocationName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			String typedValue1 = addLocationName.getAttribute("value");

			// Get the length of typed value
			int assetNameSize = typedValue1.length();
			// Assert with expected
			if (assetNameSize == 50) {
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
	
	@Test(priority = 9)
	public void AdminSettings_Add_New_Location_Details() throws SQLException {
		
		log.debug("---------Add new Location  testcase 5 ---------");
		test = rep.startTest("AdminSettings_Add_New_Location_Details");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			WebElement addLocationName= driver.findElement(By.xpath(OR.getProperty("AddLocationName")));
			addLocationName.sendKeys("Uruli Devachi");
			WebElement addAddressLine1= driver.findElement(By.xpath(OR.getProperty("AddAddressLine1")));
			addAddressLine1.sendKeys("Sr.no 18, Adarsh Nagar");
			WebElement addAddressLine2= driver.findElement(By.xpath(OR.getProperty("AddAddressLine2")));
			addAddressLine2.sendKeys("Near JPS school");
			WebElement addCity= driver.findElement(By.xpath(OR.getProperty("City")));
			addCity.sendKeys("Pune");
			WebElement addState= driver.findElement(By.xpath(OR.getProperty("State")));
			addState.sendKeys("Maharashtra");
			WebElement addCountry= driver.findElement(By.xpath(OR.getProperty("Country")));
			addCountry.sendKeys("India");
			WebElement addZipcode= driver.findElement(By.xpath(OR.getProperty("Zipcode")));
			addZipcode.sendKeys("410268");
			
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("SaveLocationMsg"))).getText();
			String expectedMsg = "Location added successfully";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Location added successfully.");
			test.log(LogStatus.PASS,"Location added successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to add new location details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_SaveEmpty_Location() throws SQLException {
		
		log.debug("---------Add new Location  testcase 6 ---------");
		test = rep.startTest("AdminSettings_SaveEmpty_Location");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("LocationNameRequired"))).getText();
			String expectedMsg = "Location name is required.";

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
	
	@Test(priority = 11)
	public void AdminSettings_Reset_Location_Details() throws SQLException {
		
		log.debug("---------Add new Location  testcase 7 ---------");
		test = rep.startTest("AdminSettings_Reset_Location_Details");

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
			WebElement Location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			Location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			WebElement addLocationName= driver.findElement(By.xpath(OR.getProperty("AddLocationName")));
			addLocationName.sendKeys("QA Tester");
			driver.findElement(By.xpath(OR.getProperty("ResetButton"))).click();
			String typedValue1 = driver.findElement(By.xpath(OR.getProperty("AddLocationName"))).getAttribute("value");
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
	
	@Test(priority = 12)
	public void AdminSettings_Cancle_Add_New_Location() throws SQLException {
		
		log.debug("---------Add new Location testcase 8 ---------");
		test = rep.startTest("AdminSettings_Cancle_Add_New_Location");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("CancelLocation"))).click();
			boolean addNewLocation= driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).isDisplayed();
			Assert.assertTrue(addNewLocation);
			log.debug("Cancle  button functionality is working fine.");
			test.log(LogStatus.PASS,"Cancle button functionality is working fine.");
		
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to cancle the location details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 13)
	public void AdminSettings_Search_Location() throws SQLException {
		
		log.debug("---------Add new Location  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Search_Location");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			WebElement searchLocation = driver.findElement(By.xpath(OR.getProperty("SearchRole")));
			searchLocation.sendKeys("Uruli Devachi");
			boolean locationName = driver.findElement(By.xpath("//td[contains(text(),'Uruli Devachi')]")).isDisplayed();
			Assert.assertTrue(locationName);
			log.debug("Location searched successfully.");
			test.log(LogStatus.PASS,"Location searched successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to search location details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 14)
	public void AdminSettings_Upadte_Location() throws SQLException {
		
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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteLocationButton"))).click();
			Thread.sleep(1000);
			boolean LocationName = driver.findElement(By.xpath(OR.getProperty("UpdateLocationValidation"))).isDisplayed();
			Assert.assertTrue(LocationName);
			log.debug("update location functionality is working fine.");
			test.log(LogStatus.PASS,"update location functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the location details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 15)
	public void AdminSettings_Upadte_Location_Detials() throws SQLException {
		
		log.debug("---------Add new Location  testcase 10 ---------");
		test = rep.startTest("AdminSettings_Upadte_Location_Detials");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteLocationButton"))).click();
			WebElement LocationName= driver.findElement(By.xpath(OR.getProperty("UpdateLocationName")));
			LocationName.clear();
			LocationName.sendKeys("Uruli Devachi Automation Tester");
			driver.findElement(By.xpath(OR.getProperty("UpdateLocationDetails"))).click();
			String actualMsg= driver.findElement(By.xpath(OR.getProperty("UpdateLocationMsg"))).getText();
			String expectedMsg= "Location updated successfully";	
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("update location details functionality is working fine.");
			test.log(LogStatus.PASS,"update location details functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the location details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 16)
	public void AdminSettings_Delete_Location() throws SQLException {
		
		log.debug("---------Add new Location  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Delete_Location");

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
			WebElement location = driver.findElement(By.xpath(OR.getProperty("Locations")));
			location.click();
			Thread.sleep(3000);
			boolean assetTypeName = driver.findElement(By.xpath("//td[contains(text(),'Uruli Devachi Automation Tester')]")).isDisplayed();
			if(assetTypeName == true) {
				driver.findElement(By.xpath(OR.getProperty("DeleteLocationButton"))).click();
				driver.findElement(By.xpath(OR.getProperty("ConfirmDeleteLocation"))).click();
				boolean addNewLocation= driver.findElement(By.xpath(OR.getProperty("AddNewLocationButton"))).isDisplayed();
				Assert.assertTrue(addNewLocation);
				log.debug("Delete location functionality is working fine.");
				test.log(LogStatus.PASS,"Delete location functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to delete the location details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	
}
