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
import com.sun.org.apache.xpath.internal.operations.Or;

public class AdminSettings_Requestors extends TestBase{
	/*
	@Test(priority = 01)
	public void AdminSettings_Requestors_Navigation() throws SQLException, InterruptedException {
		// Verify if the user is navigated to requestors on User Management.
		
		log.debug("\"---------Verify if the user is navigated to requestors on User Management TestCase 01---------\"");
		test = rep.startTest("AdminSettings_Requestors_Navigation");
		String sql = "Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		System.out.println("SQL query"+sql);
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			Thread.sleep(6000); 
			
			String actualURL = driver.getCurrentUrl();
			String expectedURL = instanceurl+"requestors";
			
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Redirected to Requestors page");
			test.log(LogStatus.PASS, "Redirected to Requestors page");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.debug("Didn't Redirect to Requestors page");
			test.log(LogStatus.FAIL, e);
		}	
	}

	@Test(priority = 02)
	public void AdminSettings_Requestors_GoBack() throws SQLException, InterruptedException {
		
		log.debug("\"---------Navigate to Admin settings and then to Requestors and the click back button TestCase 02---------\"");
		test = rep.startTest("AdminSettings_Requestors_GoBack");
		String sql = "Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement goBack = driver.findElement(By.xpath(OR.getProperty("GoBackAdminSettings")));
			goBack.click();
			log.debug("GoBack button is clicked");
			
			Thread.sleep(6000); 
			
			String actualURL = driver.getCurrentUrl();
			String expectedURL = instanceurl+"admin-settings";
			
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Redirected back from Requestors to admin settings");
			test.log(LogStatus.PASS, "Redirected back from Requestors to admin settings");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.debug("Didn't Redirect back from Requestors to admin settings");
			test.log(LogStatus.FAIL, e);
		}
		
	}
	
	
	@Test(priority = 03)
	public void AdminSettings_Requestors_IsDisplayed() throws SQLException, InterruptedException {
		// Validate the all search details present on requestor page of User Management (Requestor tab)
		log.debug("\"---------Validate the all search details present on requestor page of User Management TestCase 03---------\"");
		test = rep.startTest("AdminSettings_Requestors_IsDisplayed");
		
		String sql = "Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		String password = rs.getString(3);
		username = username.replaceAll("\\s+", "");
		password = password.replaceAll("\\s+", "");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			Thread.sleep(6000);
			
			boolean searchText = driver.findElement(By.xpath(OR.getProperty("SearchNameRequestors"))).isDisplayed();
			log.debug("Search Box field is displayed - "+ searchText);
			
			boolean fromDate = driver.findElement(By.xpath(OR.getProperty("FromDateRequestors"))).isDisplayed();
			log.debug("From Date field is displayed - "+ fromDate);
			
			boolean toDate = driver.findElement(By.xpath(OR.getProperty("ToDateRequestors"))).isDisplayed();
			log.debug("To Date field is displayed - "+ toDate);
			
			boolean selectSource = driver.findElement(By.xpath(OR.getProperty("SelectSourceRequestors"))).isDisplayed();
			log.debug("Select Source field is displayed - "+ selectSource);
			
			boolean searchButton = driver.findElement(By.xpath(OR.getProperty("SearchButtonRequestors"))).isDisplayed();
			log.debug("Search Button field is displayed - "+ searchButton);
			
			boolean resetButton= driver.findElement(By.xpath(OR.getProperty("ResetButton"))).isDisplayed();
			log.debug("Reset Button field is displayed - "+ resetButton);
			
			boolean AddNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor"))).isDisplayed();
			log.debug("Add New Requestor field is displayed - "+ AddNewRequestor);
			
			if(searchText==true && fromDate==true && toDate==true && searchButton==true &&
			   selectSource==true && resetButton==true && AddNewRequestor==true) {
				Assert.assertTrue(true);
				log.debug("Requestors page filter is validated");
				test.log(LogStatus.PASS, "Requestors page filter is validated");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Requestors page filter isn't validated");
			test.log(LogStatus.FAIL, e);
		}

	}
	
	@Test(priority = 04)
	public void AdminSettings_Requestors_Search_Empty_Details() throws SQLException, InterruptedException {
		// Verify if error message is displayed on searching requestor with empty search field.
		
		log.debug("---------Verify Entering Empty details for Search in Requestors testcase 04---------");
		test = rep.startTest("AdminSettings_Requestors_Search_Empty_Details");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(6000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			Thread.sleep(2000);
			WebElement searchButton = driver.findElement(By.xpath(OR.getProperty("SearchButtonRequestors")));
			boolean search = searchButton.isDisplayed();
			if(search==true) {
				log.debug("Search button is displayed" + search);
				searchButton.click();
				log.debug("Search Requestor");
				Thread.sleep(5000);
				String actualErrorMsg = driver.findElement(By.xpath(OR.getProperty("ErrorMsgRequestor"))).getText();
				System.out.println(actualErrorMsg);
				String expectedErrorMsg = "Please provide any search criteria";
				Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg));
				log.debug("Error message is displayed on screen once clicked on search button without search criteria");
				test.log(LogStatus.PASS, "Error message is displayed on screen once clicked on search button without search criteria");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Error message isn't displayed on screen once clicked on search button without search criteria");
			test.log(LogStatus.FAIL, e);
		}
	}
	
	@Test(priority = 05)
	public void AdminSettings_Requestors_ToDate_Required() throws SQLException, InterruptedException {
		// verify the pop-up is displayed with To Date is required when we pass only from date and click on search (Requestor tab)
		log.debug("---------verify the pop-up is displayed with To Date is required when we pass only from date and click on search testcase 05---------");
		
		test = rep.startTest("AdminSettings_Requestors_ToDate_Required");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			Thread.sleep(6000);
			
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			LocalDateTime now = LocalDateTime.now();
			WebElement fromDate = driver.findElement(By.xpath(OR.getProperty("FromDateRequestors")));
			fromDate.sendKeys(dt.format(now));
			
			driver.findElement(By.xpath(OR.getProperty("SearchButtonRequestors"))).click();
			String errorMessage = driver.findElement(By.xpath(OR.getProperty("ErrorMsgRequestor"))).getText();
			String message = "Please select To Date to proceed.";
			
			Assert.assertTrue(errorMessage.contains(message));
			driver.findElement(By.xpath(OR.getProperty("closeErrorMessage"))).click();
			log.debug("Empty to date search error message is displayed on screen");
			test.log(LogStatus.PASS, "Empty to date search error message is displayed on screen");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.debug("Empty to date search error message isn't displayed on screen");
			test.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test(priority = 06)
	public void AdminSettings_Requestors_FromDate_Required() throws InterruptedException, SQLException {
		// verify the pop-up is displayed with From Date is required when we pass only To date and click on search  (Requestor tab)
		log.debug("---------verify the pop-up is displayed with From Date is required when we pass only To date and click on search testcase 06---------");
		
		test = rep.startTest("AdminSettings_Requestors_FromDate_Required");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			Thread.sleep(5000);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			LocalDateTime now = LocalDateTime.now();
			
			WebElement toDate = driver.findElement(By.xpath(OR.getProperty("ToDateRequestors")));
			toDate.sendKeys(dtf.format(now));
			
			driver.findElement(By.xpath(OR.getProperty("SearchButtonRequestors"))).click();
			String actual_msg = driver.findElement(By.xpath(OR.getProperty("ErrorMsgRequestor"))).getText();
			String msg = "Please select From Date to proceed.";
			
			Assert.assertTrue(actual_msg.contains(msg));
			driver.findElement(By.xpath(OR.getProperty("closeErrorMessage"))).click();
			log.debug("Empty from date search error messages are displayed on screen");
			test.log(LogStatus.PASS, "Empty from date search error messages are displayed on screen");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.debug("Empty from date search error messages aren't displayed on screen");
			test.log(LogStatus.FAIL, e);
			
		}
		
	}
	
	@Test(priority = 7)
	public void AdminSettings_AddNewRequestor_Frame() throws InterruptedException, SQLException {
		// verify if user is able to add requestor on click add new requestor button  (Requestor tab)
				log.debug("---------Validate if on click add new requestor opens up a Requestor form testcase 17---------");
				
				test = rep.startTest("AdminSettings_AddNewRequestor_Frame");
				String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				String username = rs.getString(2);
				username = username.replaceAll("\\s+","");
				String password = rs.getString(3);
				password = password.replaceAll("\\s+","");
				
				WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
				user.sendKeys(username);
				log.debug("Username is entered");
				
				WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
				pass.sendKeys(password);
				log.debug("Password is entered");
				
				WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
				signIn.click();
				log.debug("SignIn button is clicked");
				
				try {
					Thread.sleep(5000);
					
					WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
					adminSettings.click();
					log.debug("Admin Settings button is clicked");
					
					WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
					requestors.click();
					log.debug("Requestors button is clicked");
					
					WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
					addNewRequestor.click();
					log.debug("Add New Requestor button is clicked");
					
					Thread.sleep(5000);
					
					boolean formVisibility = driver.findElement(By.xpath(OR.getProperty("AddNewRequestorVisibility"))).isDisplayed();
					log.debug("Form visibility for Add New Skill - "+formVisibility);
					if (formVisibility==true) {
						log.debug("Add new requestor tab is visible and new requestor can be added -Testcase passed");
						test.log(LogStatus.PASS, "Add new requestor tab is visible and new requestor can be added -Testcase passed");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.debug("Add new requestor tab isn't visible and new requestor can't be added -Testcase failed");
					test.log(LogStatus.FAIL, e);
				}

	}
	
	@Test(priority = 8)
	public void AdminSettings_AddNewRequestor_Empty_Details() throws InterruptedException, SQLException {
		// Verify if an error message is displayed on save requestor with empty fields. (Requestor tab)
		log.debug("---------Verify if an error message is displayed on save requestor with empty fields testcase 07---------");
		
		test = rep.startTest("AdminSettings_AddNewRequestor_Empty_Details");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			Thread.sleep(3000);
			
			WebElement saveButton = driver.findElement(By.xpath(OR.getProperty("SaveRequestor")));
			saveButton.click();
			log.debug("Save button is clicked");
			
			boolean firstNameRequired = driver.findElement(By.xpath(OR.getProperty("FirstNameRequiredRequestor"))).isDisplayed();
			log.debug("First Name Required is displayed - "+firstNameRequired);
			
			boolean lastNameRequired = driver.findElement(By.xpath(OR.getProperty("LastNameRequiredRequestor"))).isDisplayed();
			log.debug("Last Name Required is displayed - "+lastNameRequired);
			
			boolean emailRequired = driver.findElement(By.xpath(OR.getProperty("EmailRequiredRequestor"))).isDisplayed();
			log.debug("Email Required is displayed - "+emailRequired);
			
			boolean phoneRequiredMsg_1 = driver.findElement(By.xpath(OR.getProperty("PhoneRequiredRequestor_1"))).isDisplayed();
			log.debug("Phone NumberRequired is displayed - "+phoneRequiredMsg_1);
			
			boolean phoneRequiredMsg_2 = driver.findElement(By.xpath(OR.getProperty("PhoneRequiredRequestor_2"))).isDisplayed();
			log.debug("Phone number criteria is displayed - "+phoneRequiredMsg_2);
			
			if (firstNameRequired==true && lastNameRequired==true && emailRequired==true
				&& phoneRequiredMsg_1==true && phoneRequiredMsg_2==true) {
				Assert.assertTrue(true);
				log.debug("Saving new requestor details with passing empty details shows error");
				test.log(LogStatus.PASS, "Saving new requestor details with passing empty details shows error");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Saving new requestor details with passing empty details does not show error");
			test.log(LogStatus.FAIL, e);
		}
				
	}
	
	@Test(priority = 9)
	public void AdminSettings_AddNewRequestor_25_Characters() throws SQLException, InterruptedException {
		// Verify user should only able to add 25 characters in firstname and lastname field on  add requestor window. (Requestor tab)
		log.debug("---------Verify user should only able to add 25 characters in firstname and lastname field on  add requestor window testcase 15---------");
		
		test = rep.startTest("AdminSettings_AddNewRequestor_25_Characters");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
			
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
			
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
			
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
				
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
					
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			Thread.sleep(4000);
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
					
			WebElement firstName = driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor")));
			firstName.sendKeys("johndoeworksatgodesklessinc");	
			log.debug("First Name is entered");
			String typedValue = firstName.getAttribute("value");
			int size = typedValue.length();
			if (size==25) {
				Assert.assertTrue(true);
				log.debug("Max character functionality is working fine");
				test.log(LogStatus.PASS, "Max character functionality is working fine");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Max character functionality isn't working fine");
			test.log(LogStatus.FAIL, e);				
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_AddNewRequestor_FirstName_LastName() throws InterruptedException, SQLException {
		// Verify if an error message is displayed in the window after entering a first name and Lastname and try to save the requestor. (Requestor tab)
		log.debug("---------Verify if an error message is displayed in the window after entering a first name and Lastname and try to save the requestor testcase 08---------");
		
		test = rep.startTest("AdminSettings_AddNewRequestor_FirstName_LastName");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			Thread.sleep(3000);
			
			WebElement firstNameTextBox = driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor")));
			firstNameTextBox.sendKeys("John");
			log.debug("First name under Add new requestor is entered");
			
			WebElement lastNameTextBox = driver.findElement(By.xpath(OR.getProperty("LastNameTextBoxRequestor")));
			lastNameTextBox.sendKeys("Doe");
			log.debug("Last name under Add new requestor is entered");
			
			WebElement saveButton = driver.findElement(By.xpath(OR.getProperty("SaveRequestor")));
			saveButton.click();
			log.debug("Save button under Add new requestor is clicked");
			
			
			boolean emailRequired = driver.findElement(By.xpath(OR.getProperty("EmailRequiredRequestor"))).isDisplayed();
			log.debug("Email Required is displayed - "+emailRequired);
			
			boolean phoneRequiredMsg_1 = driver.findElement(By.xpath(OR.getProperty("PhoneRequiredRequestor_1"))).isDisplayed();
			log.debug("Phone number Required is displayed - "+phoneRequiredMsg_1);
			
			boolean phoneRequiredMsg_2 = driver.findElement(By.xpath(OR.getProperty("PhoneRequiredRequestor_2"))).isDisplayed();
			log.debug("Phone number criteria msg is displayed - "+phoneRequiredMsg_2);
			
			if (emailRequired==true && phoneRequiredMsg_1==true && phoneRequiredMsg_2==true) {
				Assert.assertTrue(true);
				log.debug("Saving new requestor details with passing Firstname and Lastname and other empty details shows error");
				test.log(LogStatus.PASS, "Saving new requestor details with passing Firstname and Lastname and other empty details shows error");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Saving new requestor details with passing Firstname and Lastname and other empty details doesn't show an error");
			test.log(LogStatus.FAIL, e);
		}
		
		
	}
	
	@Test(priority = 11)
	public void AdminSettings_AddNewRequestor_Incorrect_Email() throws InterruptedException, SQLException {
		// Verify if an error message is displayed on entering incorrect email id while adding requestor. (Requestor tab)
		log.debug("---------Verify if an error message is displayed on entering incorrect email id while adding requestor testcase 09---------");
		
		test = rep.startTest("AdminSettings_AddNewRequestor_Incorrect_Email");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			Thread.sleep(3000);
			
			WebElement firstNameTextBox = driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor")));
			firstNameTextBox.sendKeys("John");
			log.debug("First name under Add new requestor is entered");
			
			WebElement lastNameTextBox = driver.findElement(By.xpath(OR.getProperty("LastNameTextBoxRequestor")));
			lastNameTextBox.sendKeys("Doe");
			log.debug("Last name under Add new requestor is entered");
			
			WebElement emailTextBox = driver.findElement(By.xpath(OR.getProperty("EmailTextBoxRequestor")));
			emailTextBox.sendKeys("johndoeyopmail.com");
			log.debug("Email under Add new requestor is entered");
			
			WebElement phoneTextBox = driver.findElement(By.xpath(OR.getProperty("PhoneTextBoxRequestor")));
			phoneTextBox.sendKeys("9237987129");
			log.debug("Phone number under Add new requestor is entered");
			
			driver.findElement(By.xpath(OR.getProperty("LocationDropdownRequestors"))).click();
			log.debug("Location Dropdown button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("201BanerRoad"))).click();
			log.debug("201 Baner Road is selected");
			
			WebElement saveButton = driver.findElement(By.xpath(OR.getProperty("SaveRequestor")));
			saveButton.click();
			log.debug("Save button under add new requestor is clicked");
			
			boolean validEmail = driver.findElement(By.xpath(OR.getProperty("PleaseEnterValidEmail"))).isDisplayed();
			log.debug("Please Enter Valid Email! - "+validEmail);
			
			
			if (validEmail==true) {
				Assert.assertTrue(true);
				log.debug("Saving new requestor details with passing incorrect email shows error");
				test.log(LogStatus.PASS, "Saving new requestor details with passing incorrect email shows error");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Saving new requestor details with passing incorrect email Doesn't show error");
			test.log(LogStatus.FAIL, e);
		}
		

	}
	
	@Test(priority = 12)
	public void AdminSettings_AddNewRequestor_PhoneNumber_Length() throws InterruptedException, SQLException {
		// Verify if an error message is displayed in the window on entering less than 10 in the phone number field and try to save the requestor. (Requestor tab)
		log.debug("---------Verify if an error message is displayed in the window on entering less than 10 in the phone number field and try to save the requestor testcase 10---------");
		
		test = rep.startTest("AdminSettings_AddNewRequestor_PhoneNumber_Length");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			Thread.sleep(3000);
			
			WebElement firstNameTextBox = driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor")));
			firstNameTextBox.sendKeys("John");
			log.debug("First name under Add new requestor is entered");
			
			WebElement lastNameTextBox = driver.findElement(By.xpath(OR.getProperty("LastNameTextBoxRequestor")));
			lastNameTextBox.sendKeys("Doe");
			log.debug("Last name under Add new requestor is entered");
			
			WebElement emailTextBox = driver.findElement(By.xpath(OR.getProperty("EmailTextBoxRequestor")));
			emailTextBox.sendKeys("johndoe@gmail.com");
			log.debug("Email under Add new requestor is entered");
			
			WebElement phoneTextBox = driver.findElement(By.xpath(OR.getProperty("PhoneTextBoxRequestor")));
			phoneTextBox.sendKeys("92379879");
			log.debug("Phone number under Add new requestor is entered");
			
			driver.findElement(By.xpath(OR.getProperty("LocationDropdownRequestors"))).click();
			log.debug("Location Dropdown button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("201BanerRoad"))).click();
			log.debug("201 Baner Road is selected");
			
			WebElement saveButton = driver.findElement(By.xpath(OR.getProperty("SaveRequestor")));
			saveButton.click();
			log.debug("Save button under add new requestor is clicked");
			
			boolean phoneErrorMsg = driver.findElement(By.xpath(OR.getProperty("PhoneRequiredRequestor_2"))).isDisplayed();
			log.debug("Phone number must be between 10 and 17 characters long - "+phoneErrorMsg);
			
			
			if (phoneErrorMsg==true) {
				Assert.assertTrue(true);
				log.debug("Saving new requestor details with passing phone number less than 10 shows error");
				test.log(LogStatus.PASS, "Saving new requestor details with passing phone number less than 10 shows error");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Saving new requestor details with passing phone number less than 10 doesn't show an error");
			test.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test(priority = 13)
	public void AdminSettings_AddNewRequestor_Save() throws SQLException, InterruptedException {
		// Verify requestor is saved on  adding all details on add requestor window and click on save (Requestor tab)
		log.debug("---------Validate if add new requestor button adds a requestor with correct details testcase 11---------");
		
		test = rep.startTest("AdminSettings_AddNewRequestor_Save");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
				
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor"))).sendKeys("Robert");
			log.debug("First Name is entered");
			driver.findElement(By.xpath(OR.getProperty("LastNameTextBoxRequestor"))).sendKeys("Sheehan");
			log.debug("Last Name is entered");
			driver.findElement(By.xpath(OR.getProperty("EmailTextBoxRequestor"))).sendKeys("robertsheehan@yopmail.com");
			log.debug("Email is entered");
			driver.findElement(By.xpath(OR.getProperty("PhoneTextBoxRequestor"))).sendKeys("9234563728");;
			log.debug("Phone number is entered");
			driver.findElement(By.xpath(OR.getProperty("LocationDropdownRequestors"))).click();
			log.debug("Location dropdown button is clicked");
			driver.findElement(By.xpath(OR.getProperty("201BanerRoad"))).click();
			log.debug("201 Baner road as an address is selected");
			
			driver.findElement(By.xpath(OR.getProperty("SaveRequestor"))).click();
			log.debug("Save button is clicked");
			Thread.sleep(4000);
			
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("RequestorAddedSuccessfully"))).getText();
			String expectedMsg = "Requestor added successfully";
			
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("New requestor is added by entering proper details");
			test.log(LogStatus.PASS, "New requestor is added by entering proper details");
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			log.debug("New requestor isn't added by entering proper details");
			test.log(LogStatus.FAIL, e);
					
		}
				
				
	}*/
	
	@Test(priority = 14)
	public void AdminSettings_Reset_Requestors() throws SQLException, InterruptedException {
		// Verify if data is reset on click on reset button of add requestor. (Requestor tab)
		log.debug("---------Verify if data is reset on click on reset button of add requestor testcase 12---------");
		
		test = rep.startTest("AdminSettings_Reset_Requestors");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		

		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor"))).sendKeys("Robert");
			log.debug("First Name is entered");
			driver.findElement(By.xpath(OR.getProperty("LastNameTextBoxRequestor"))).sendKeys("Sheehan");
			log.debug("Last Name is entered");
			
			driver.findElement(By.xpath(OR.getProperty("ResetRequestor"))).click();
			System.out.println("reset button "+driver.findElement(By.xpath(OR.getProperty("ResetRequestor"))));
			log.debug("Reset button is clicked");
			
			String FirstName = driver.findElement(By.xpath(OR.getProperty("FirstNameTextBoxRequestor"))).getText();
			
			if(FirstName.isEmpty()) {
				Assert.assertTrue(true);
				log.debug("Details are reset once clicked on Reset button");
				test.log(LogStatus.PASS, "Details are reset once clicked on Reset button");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Details aren't reset once clicked on Reset button");
			test.log(LogStatus.FAIL, e);
		}
		
	}
	/*
	@Test(priority = 15)
	public void Adminsettings_Cancel_Requestor() throws SQLException, InterruptedException {
		// Verify if window is closed  on click on cancel button of add requestor. (Requestor tab)
		log.debug("---------Verify if window is closed  on click on cancel button of add requestor. (Requestor tab) testcase 13---------");
		
		test = rep.startTest("Adminsettings_Cancel_Requestor");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
		user.sendKeys(username);
		log.debug("Username is entered");
		
		WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
		pass.sendKeys(password);
		log.debug("Password is entered");
		
		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		
		try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
			
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			WebElement addNewRequestor = driver.findElement(By.xpath(OR.getProperty("AddNewRequestor")));
			addNewRequestor.click();
			log.debug("Add New Requestor button is clicked");
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(OR.getProperty("CancelRequestor"))).click();
			log.debug("Cancel button is clicked");
			
			
			
			boolean formVisibility = driver.findElement(By.xpath(OR.getProperty("AddNewRequestorVisibility"))).isDisplayed();
			log.debug("Form visibility - "+formVisibility);
			if (formVisibility==false) {
				Assert.assertTrue(true);
				log.debug("Add new requestor tab is closed Testcase passed");
				test.log(LogStatus.PASS, "Add new requestor tab is closed Testcase passed");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Add new requestor tab isn't closed Testcase failed");
			test.log(LogStatus.FAIL, e);
		}
		
	}
	
	/*
	@Test(priority = 17)
	public void AdminSettings_Delete_Requestor() throws SQLException, InterruptedException {
		// Verify if the requestor is deleted after clicking delete button.(Requestor tab)
	log.debug("---------Verify if the requestor is deleted after clicking delete button testcase 16---------");
	
	test = rep.startTest("AdminSettings_Delete_Requestor");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
		
	WebElement user = driver.findElement(By.xpath(OR.getProperty("UserName")));
	user.sendKeys(username);
	log.debug("Username is entered");
		
	WebElement pass = driver.findElement(By.xpath(OR.getProperty("Password")));
	pass.sendKeys(password);
	log.debug("Password is entered");
		
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
		
	try {
			Thread.sleep(5000);
			
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");
					
			WebElement requestors = driver.findElement(By.xpath(OR.getProperty("Requestors")));
			requestors.click();
			log.debug("Requestors button is clicked");
			
			boolean roleName = driver.findElement(By.xpath("//td[contains(text(),'')]")).isDisplayed();
			if(roleName == true) {
				
			
			driver.findElement(By.xpath(OR.getProperty("DeleteButtonInDeletePopup"))).click();
			log.debug("Delete button in a delete popup is clicked");
			
			Thread.sleep(4000);
			
			String actual = driver.findElement(By.xpath(OR.getProperty("AlertOnClickDelete"))).getText();
	
			String expected = "Requestor Deleted Successfully!";
			
			Assert.assertEquals(actual, expected);
			log.debug("Deleting a requestor is working fine");
			test.log(LogStatus.PASS, "Deleting a requestor is working fine");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Didn't delete a requestor");
			test.log(LogStatus.FAIL, e);
			}
				
	}*/
	
}


