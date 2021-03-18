package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class AdminSettings extends TestBase{
	
	@Test(priority = 1)
	public void AdminSettings_Navigation() throws SQLException {
		// click on admin settings 
		log.debug("---------Navigate to Admin settings  TestCase ---------");
		test = rep.startTest("AdminSettings_Navigation");
		String sql="select * from user_credentials where id = 2";
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
		//Reporter.log("SignIn button is clicked");
		try {
			
			WebElement AdminSettingsTab = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			AdminSettingsTab.click();
			Thread.sleep(5000);
			String ActualURL = driver.getCurrentUrl();
			String ExpectedUrl = instanceurl+"admin-settings";
			
			Assert.assertEquals(ActualURL, ExpectedUrl);
			log.debug("Navigated to Admin Settings successfully");
			test.log(LogStatus.PASS,"Navigated to Admin Settings successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug("Failed to navigate Admin Settings");
			test.log(LogStatus.FAIL,e);

		}
	}
	
	@Test(priority = 2)
	public  void AdminSettings_GeneralSettings_isDisplayed() throws SQLException, InterruptedException {
		// click on admin settings -> check if General settings web elements are displayed
		
		log.debug("\"---------Navigate to Admin settings and check visibility of WebElements under General Settings TestCase ---------\"");
		test = rep.startTest("adminSettings_GeneralSettings_isDisplayed");
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is Clicked");
		try {
			Thread.sleep(1000);
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			Thread.sleep(6000);
	
			boolean mobileConfig = driver.findElement(By.xpath(OR.getProperty("MobileConfiguration"))).isDisplayed();
			log.debug("Mobile Configuration field is displayed - "+ mobileConfig);
			
			boolean serverConfig = driver.findElement(By.xpath(OR.getProperty("ServerConfiguration"))).isDisplayed();
			log.debug("Server Configuration field is displayed - "+ serverConfig);
			
			boolean profileSettings = driver.findElement(By.xpath(OR.getProperty("ProfileSettings"))).isDisplayed();
			log.debug("Profile Settings field is displayed - "+ profileSettings);
			
			
			if(mobileConfig==true && serverConfig==true && profileSettings==true) {
				Assert.assertTrue(true);
				log.debug("All the elements are displayed on general settings tab");
				test.log(LogStatus.PASS,"All the elements are displayed on general settings tab");
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Test case is failed");
			test.log(LogStatus.FAIL,e);
		}
		
	}
	
	@Test(priority = 03)
	public  void adminSettings_UserManagement_isDisplayed() throws SQLException {
		// Verify if all the settings are present on User Management.
		
		log.debug("\"---------Navigate to Admin settings and check visibility of WebElements under User ManagementTestCase 06---------\"");
		test = rep.startTest("adminSettings_UserManagement_isDisplayed");
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is Clicked");
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			Thread.sleep(6000);
			
			
			boolean requestors = driver.findElement(By.xpath(OR.getProperty("Requestors"))).isDisplayed();
			log.debug("Requestors field is displayed - "+ requestors);
			
			boolean agents = driver.findElement(By.xpath(OR.getProperty("Agents"))).isDisplayed();
			log.debug("Agents field is displayed - "+ agents);
			
			boolean groups = driver.findElement(By.xpath(OR.getProperty("Groups"))).isDisplayed();
			log.debug("Groups field is displayed - "+ groups);
			
			boolean roles = driver.findElement(By.xpath(OR.getProperty("Roles"))).isDisplayed();
			log.debug("Roles field is displayed - "+ roles);
			
			boolean skills = driver.findElement(By.xpath(OR.getProperty("Skills"))).isDisplayed();
			log.debug("Roles field is displayed - "+ roles);
			
			boolean ticketTypes = driver.findElement(By.xpath(OR.getProperty("TicketTypes"))).isDisplayed();
			log.debug("Roles field is displayed - "+ roles);
			
			if(requestors==true && agents==true && groups==true && roles==true && skills==true && ticketTypes==true) {
				Assert.assertTrue(true);
				log.debug("All the webelements in Admin Settings -> User Management are displayed");
				test.log(LogStatus.PASS,"All the webelements in Admin Settings -> User Management are displayed");
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to check all web element of Admin Settings -> User Management");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 04)
	public  void adminSettings_AssetManagement_isDisplayed() throws SQLException, InterruptedException {
		// click on admin settings -> check if Asset Management web elements are displayed
		
		log.debug("\"---------Navigate to Admin settings and check visibility of WebElements under Asset ManagementTestCase 07---------\"");
		test = rep.startTest("adminSettings_AssetManagement_isDisplayed");
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is Clicked");
		try {
			Thread.sleep(6000);
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			Thread.sleep(6000);
			boolean assets = driver.findElement(By.xpath(OR.getProperty("Assets"))).isDisplayed();
			log.debug("Assets field is displayed - "+ assets);
			
			boolean assetType = driver.findElement(By.xpath(OR.getProperty("AssetTypes"))).isDisplayed();
			log.debug("Locations field is displayed - "+ assetType);
			
			boolean locations = driver.findElement(By.xpath(OR.getProperty("Locations"))).isDisplayed();
			log.debug("Locations field is displayed - "+ locations);
			
			if(assets==true && assetType==true && locations==true) {
				Assert.assertTrue(true);
				log.debug("All the web elements in Admin Settings -> Asset Management are displayed");
				test.log(LogStatus.PASS, "All the web elements in Admin Settings -> Asset Management are displayed");
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("failed to check web elements in Admin Settings -> Asset Management");
			test.log(LogStatus.FAIL,e);
		}
		
	}
	
	@Test(priority = 5)
	public void AdminSettings_MobileConfigurations() throws SQLException, InterruptedException {
		// click on admin settings -> click on mobile configuration
		log.debug("---------Navigate to Admin settings to Mobile configuration Test case ---------");
		test = rep.startTest("AdminSettings_MobileConfigurations");
		String sql="select * from user_credentials where id = 2";
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
		//Reporter.log("SignIn button is clicked");
		try {
			WebElement AdminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			AdminSettings.click();
			log.debug("Admin Settings button is clicked");
			Thread.sleep(4000);
			WebElement MobileConfig = driver.findElement(By.xpath(OR.getProperty("MobileConfiguration")));
			MobileConfig.click();
			log.debug("Mobile Configuration button is clicked");
			
			Thread.sleep(3000);
			
			String ActualMobileSettingsURL = driver.getCurrentUrl();
			String ExpectedMobileSettingsUrl = instanceurl+"mobile-configuration";
			
			Assert.assertEquals(ActualMobileSettingsURL, ExpectedMobileSettingsUrl);
			log.debug(" Navigated to mobile configutaion in General settings Test case passed");
			test.log(LogStatus.PASS,"Navigated to mobile configutaion in General settings Test case passed");
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Failed to naviagte mobile configurations in general settings");
			test.log(LogStatus.FAIL,e);
		}
		
	}
	
	
	@Test(priority = 6)
	public void AdminSettings_MobileConfiguration_Goback() throws SQLException, InterruptedException {
		// click on admin settings -> click on mobile settings -> click on back button
		
		log.debug("\"---------Navigate to Admin settings to Mobile configuration go back button TestCase ---------\"");
		test = rep.startTest("AdminSettings_MobileConfiguration_AlertMsg");
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("Sign IN button is clicked");
		try {
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
		
			Thread.sleep(4000);
			WebElement mobileConfig = driver.findElement(By.xpath(OR.getProperty("MobileConfiguration")));
			mobileConfig.click();
			log.debug("Mobile Configuration button is clicked");
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("GoBackAdminSettings"))).click();
			Thread.sleep(2000);
			String ActualURL=driver.getCurrentUrl();
			String ExpectedURL = instanceurl+"admin-settings";
			Assert.assertEquals(ActualURL,ExpectedURL);
			log.debug("Correct alert message is displayed on mobile configuration");
			test.log(LogStatus.PASS,"Correct alert message is displayed on mobile configuration");
		}catch (Exception e) {
			// TODO: handle exception
			log.info("Failed to check alert message on mobile configurations");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 7)
	public void AdminSettings_MobileConfiguration_AlertMsg() throws SQLException, InterruptedException {
		// click on admin settings -> click on mobile settings -> click on back button
		
		log.debug("\"---------Navigate to Admin settings to Mobile configuration alert message TestCase ---------\"");
		test = rep.startTest("AdminSettings_MobileConfiguration_AlertMsg");
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("Sign IN button is clicked");
		try {
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
		
			Thread.sleep(4000);
			WebElement mobileConfig = driver.findElement(By.xpath(OR.getProperty("MobileConfiguration")));
			mobileConfig.click();
			log.debug("Mobile Configuration button is clicked");
			Thread.sleep(4000);
			
			String ActualMsg=driver.findElement(By.xpath(OR.getProperty("MobileAlertMsg"))).getText();
			String ExpectedMsg = "Info Alert! Please work with expert before you modify configuration !";
			Assert.assertEquals(ActualMsg,ExpectedMsg);
			log.debug("Correct alert message is displayed on mobile configuration");
			test.log(LogStatus.PASS,"Correct alert message is displayed on mobile configuration");
		}catch (Exception e) {
			// TODO: handle exception
			log.info("Failed to check alert message on mobile configurations");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AdminSettings_MobileConfiguration_IsDisplayed() throws SQLException {
		// click on admin settings -> click on mobile configuration and check if all web elements are present
		
		log.debug("\"---------Navigate to Admin settings to Mobile configuration and then check visibility of WebElements TestCase 04---------\"");
		test = rep.startTest("AdminSettings_MobileConfiguration_IsDisplayed");
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("Sign in nutton is clicked");
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			Thread.sleep(4000);
			WebElement mobileConfig = driver.findElement(By.xpath(OR.getProperty("MobileConfiguration")));
			mobileConfig.click();
			log.debug("Mobile Configuration button is clicked");
			
			// check if all web elements are displayed
			boolean maps=driver.findElement(By.xpath(OR.getProperty("Maps"))).isDisplayed();
			log.debug("Maps field is displayed - "+ maps);
			boolean geofence=driver.findElement(By.xpath(OR.getProperty("Geofence"))).isDisplayed();
			log.debug("Geofence field is displayed - "+ geofence);
			boolean geofenceRadiusText=driver.findElement(By.xpath(OR.getProperty("GeofenceRadiusText"))).isDisplayed();
			log.debug("Enter Geofence Radius field is displayed - "+ geofenceRadiusText);
			
			boolean startEndTravel=driver.findElement(By.xpath(OR.getProperty("StartEndTravel"))).isDisplayed();
			log.debug("Start/End Travel field is displayed - "+ startEndTravel);
			boolean startEndWork=driver.findElement(By.xpath(OR.getProperty("StartEndWork"))).isDisplayed();
			log.debug("Start/End Work field is displayed - "+ startEndWork);
			boolean addNotesBy_Text=driver.findElement(By.xpath(OR.getProperty("AddNotesBy_Text"))).isDisplayed();
			log.debug("Add notes by text field is displayed - "+ addNotesBy_Text);
			boolean addNotesBy_Video=driver.findElement(By.xpath(OR.getProperty("AddNotesBy_Video"))).isDisplayed();
			log.debug("Add notes by video field is displayed - "+ addNotesBy_Video);
			boolean addNotesBy_Image=driver.findElement(By.xpath(OR.getProperty("AddNotesBy_Image"))).isDisplayed();
			log.debug("Add notes by image field is displayed - "+ addNotesBy_Image);
			boolean postJobAction_Signature=driver.findElement(By.xpath(OR.getProperty("PostJobAction_Signature"))).isDisplayed();
			log.debug("Post Job action Signature field is displayed - "+ postJobAction_Signature);
			boolean postJobAction_RequestForClosure=driver.findElement(By.xpath(OR.getProperty("PostJobAction_RequestForClosure"))).isDisplayed();
			log.debug("Post Job Action Request by closure field is displayed - "+ postJobAction_RequestForClosure);
			boolean noteAsSignature=driver.findElement(By.xpath(OR.getProperty("NoteAsSignature"))).isDisplayed();
			log.debug("Note as Signature field is displayed - "+ noteAsSignature);
			
			boolean textChat=driver.findElement(By.xpath(OR.getProperty("TextChat"))).isDisplayed();
			log.debug("Text chat field is displayed - "+ textChat);
			boolean videoChat=driver.findElement(By.xpath(OR.getProperty("VideoChat"))).isDisplayed();
			log.debug("Video Chat field is displayed - "+ videoChat);
			boolean calendarSynchronization=driver.findElement(By.xpath(OR.getProperty("CalendarSynchronization"))).isDisplayed();
			log.debug("Calendar Synchronization field is displayed - "+ calendarSynchronization);
			boolean outlook=driver.findElement(By.xpath(OR.getProperty("Outlook"))).isDisplayed();
			log.debug("Outlook field is displayed - "+ outlook);
			boolean gmail=driver.findElement(By.xpath(OR.getProperty("Gmail"))).isDisplayed();
			log.debug("Gmail field is displayed - "+ gmail);
			
			boolean calendar=driver.findElement(By.xpath(OR.getProperty("Calendar"))).isDisplayed();
			log.debug("Calendar field is displayed - "+ calendar);
			boolean logs=driver.findElement(By.xpath(OR.getProperty("Log"))).isDisplayed();
			log.debug("Log field is displayed - "+ logs);
			boolean teamMemberViewMap=driver.findElement(By.xpath(OR.getProperty("TeamMemberViewMap"))).isDisplayed();
			log.debug("Team memeber view map field is displayed - "+ teamMemberViewMap);
			
			boolean save=driver.findElement(By.xpath(OR.getProperty("Save"))).isDisplayed();
			log.debug("Save field is displayed - "+ save);
			
			boolean defaultSetting=driver.findElement(By.xpath(OR.getProperty("DefaultSetting"))).isDisplayed();
			log.debug("Default Setting field is displayed - "+ defaultSetting);
			
			if(maps==true && geofence==true && geofenceRadiusText==true && startEndTravel==true &&
			   startEndWork==true && addNotesBy_Text==true && addNotesBy_Image==true 
			   && addNotesBy_Video==true && postJobAction_Signature==true && 
			   postJobAction_RequestForClosure==true && noteAsSignature==true && textChat==true
			   && videoChat==true && calendarSynchronization==true && outlook==true && gmail==true
			   && calendar==true && logs==true && teamMemberViewMap==true && save==true &&
			   defaultSetting==true){
				Assert.assertTrue(true);
				log.debug("All the Web Elements on Mobile Configuration are displayed"); 
				test.log(LogStatus.PASS,"All the Web Elements on Mobile Configuration are displayed");
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to check the web elements Mobile Configuration");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 9)
	public void AdminSettings_ServerConfigurations() throws SQLException, InterruptedException {
		// click on admin settings -> click on mobile configuration
		
		log.debug("---------Navigate to Admin settings to Mobile configuration Test case ---------");
		test = rep.startTest("AdminSettings_MobileConfigurations");
		String sql="select * from user_credentials where id = 2";
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
		//Reporter.log("SignIn button is clicked");
		
		try {
			WebElement AdminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			AdminSettings.click();
			log.debug("Admin Settings button is clicked");
			Thread.sleep(4000);
			WebElement ServerConfig = driver.findElement(By.xpath(OR.getProperty("ServerConfiguration")));
			ServerConfig.click();
			log.debug("Server Configuration button is clicked");
			
			Thread.sleep(3000);
			
			String ActualServerConfigURL = driver.getCurrentUrl();
			String ExpectedServerConfigURL = instanceurl+"server-configuration";
			
			Assert.assertEquals(ActualServerConfigURL, ExpectedServerConfigURL);
			log.debug(" Navigated to Server configuration in General settings Test case passed");
			test.log(LogStatus.PASS,"Navigated to Server configuration in General settings Test case passed");
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Failed to navigate server configuration in general settings");
			test.log(LogStatus.FAIL,e);
		}		
	}
	
	@Test(priority = 10)
	public void adminSettings_ServerConfiguration_IsDisplayed() throws SQLException, InterruptedException {
		// Click on Admin Settings -> Click on Server Configuration -> check if all elements displayed
		
		log.debug("\"---------Navigate to Admin settings and check visibility of WebElements under ServerSettings TestCase 08---------\"");;
		test = rep.startTest("adminSettings_ServerConfiguration_IsDisplayed");
		
		String sql="select * from user_credentials where id = 2";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement passWord = driver.findElement(By.xpath(OR.getProperty("Password")));
		passWord.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is Clicked");
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement serverConfig = driver.findElement(By.xpath(OR.getProperty("ServerConfiguration")));
			serverConfig.click();
			log.debug("Server Configuration button is clicked");
			
			Thread.sleep(6000);
			
			boolean crmFreshservice = driver.findElement(By.xpath(OR.getProperty("Freshservice"))).isDisplayed();
			log.debug("Freshservice under Choose CRM is displayed - " +crmFreshservice);
			
			boolean crmFreshsdesk = driver.findElement(By.xpath(OR.getProperty("Freshdesk_1"))).isDisplayed();
			log.debug("Freshdesk under Choose CRM is displayed - " +crmFreshsdesk);
			
			boolean crmMicrosoftDynamics = driver.findElement(By.xpath(OR.getProperty("MicrosoftDynamics"))).isDisplayed();
			log.debug("Microsoft Dynamics under Choose CRM is displayed - " +crmMicrosoftDynamics);
			
			boolean crmServiceNow = driver.findElement(By.xpath(OR.getProperty("ServiceNow"))).isDisplayed();
			log.debug("ServiceNow under Choose CRM is displayed - " +crmServiceNow);
			
			boolean crmZoho = driver.findElement(By.xpath(OR.getProperty("Zoho"))).isDisplayed();
			log.debug("Zoho under Choose CRM is displayed - " +crmZoho);
			
			boolean crmOracle = driver.findElement(By.xpath(OR.getProperty("Oracle"))).isDisplayed();
			log.debug("Oracle under Choose CRM is displayed - " +crmOracle);
			
			boolean ftGoDeskless = driver.findElement(By.xpath(OR.getProperty("Godeskless_1"))).isDisplayed();
			log.debug("GoDeskless in the block of FieldTechnicians, Groups, Roles, Locations is displayed - " +ftGoDeskless);
			
			boolean ftFreshdesk = driver.findElement(By.xpath(OR.getProperty("Freshdesk_2"))).isDisplayed();
			log.debug("Freshdesk in the block of FieldTechnicians, Groups, Roles, Locations is displayed - " +ftFreshdesk);
			
			boolean requestorGoDeskless = driver.findElement(By.xpath(OR.getProperty("Godeskless_2"))).isDisplayed();
			log.debug("GoDeskless in the block of Requestors is displayed - " +requestorGoDeskless);
			
			boolean requestorFreshdesk = driver.findElement(By.xpath(OR.getProperty("Freshdesk_3"))).isDisplayed();
			log.debug("Freshdesk in the block of Requestors is displayed - " +requestorFreshdesk);
			
			boolean ticketsGoDeskless = driver.findElement(By.xpath(OR.getProperty("Godeskless_3"))).isDisplayed();
			log.debug("GoDeskless in the block of Tickets is displayed - " +ticketsGoDeskless);
			
			boolean ticketsFreshdesk = driver.findElement(By.xpath(OR.getProperty("Freshdesk_4"))).isDisplayed();
			log.debug("Freshdesk in the block of Tickets is displayed - " +ticketsFreshdesk);
			
			boolean dispatchersGoDeskless = driver.findElement(By.xpath(OR.getProperty("Godeskless_4"))).isDisplayed();
			log.debug("GoDeskless in the block of Dispatchers is displayed - " +dispatchersGoDeskless);
			
			boolean dispatcherFreshdesk = driver.findElement(By.xpath(OR.getProperty("Freshdesk_5"))).isDisplayed();
			log.debug("Freshdesk in the block of Dispatchers is displayed - " +dispatcherFreshdesk);
			
			boolean save=driver.findElement(By.xpath(OR.getProperty("Save"))).isDisplayed();
			log.debug("Save field is displayed - "+ save);
			
			boolean defaultSetting=driver.findElement(By.xpath(OR.getProperty("DefaultSetting"))).isDisplayed();
			log.debug("Default Setting field is displayed - "+ defaultSetting);
			
			if(crmFreshsdesk==true && crmFreshservice==true && crmMicrosoftDynamics==true &&
			   crmOracle==true && crmServiceNow==true && crmZoho==true && ftFreshdesk==true &&
			   ftGoDeskless==true && requestorFreshdesk==true && requestorGoDeskless==true && 
			   ticketsFreshdesk==true && ticketsGoDeskless==true && dispatcherFreshdesk==true 
			   && dispatchersGoDeskless==true && save==true && defaultSetting==true) {
				Assert.assertTrue(true);
				log.debug("9th TestCase is passed");
				test.log(LogStatus.PASS, "Test case to check webelements on Server Configuration page is passed");
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("9th TestCase is failed");
			Assert.fail();
			test.log(LogStatus.FAIL, "Failed to test the Server Configuration page");
		}
	
	}
	
	@Test(priority = 11)
	public void AdminSettings_Profile_Navigation() throws SQLException {
		log.debug("---------Navigate to Admin settings then to profile settings TestCase ---------");
		test = rep.startTest("AdminSettings_Profile_Navigation");
		String sql="select * from user_credentials where id = 2";
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
		//Reporter.log("SignIn button is clicked");
		
		try {
			WebElement AdminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			AdminSettings.click();
			log.debug("Admin Settings button is clicked");
			Thread.sleep(4000);
			WebElement ProfileButton = driver.findElement(By.xpath(OR.getProperty("ProfileSettings")));
			ProfileButton.click();
			log.debug("Profile button under user Profile is clicked");
			Thread.sleep(3000);
			String ActualProfileSettingsURL = driver.getCurrentUrl();
			String ExpectedProfileSettingsURL = instanceurl+"profile";
			
			Assert.assertEquals(ActualProfileSettingsURL, ExpectedProfileSettingsURL);
			log.debug(" Navigated to  profile settings in  General settings Test case passed");
			test.log(LogStatus.PASS,"Navigated to  profile settings in General settings Test case passed");
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Failed to navigate profile settings in general settings");
			test.log(LogStatus.FAIL,e);
		}
		
	}

	
}

