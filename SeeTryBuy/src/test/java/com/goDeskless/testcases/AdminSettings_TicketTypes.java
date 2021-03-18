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


public class AdminSettings_TicketTypes extends TestBase{
	
	@Test(priority = 01)
	public void AdminSettings_TicketTypes_Navigation() throws SQLException, InterruptedException {
		// Verify if user is navigated to Ticket Types tab on Admin Settings.(Skills Tab)
		log.debug("--------- Verify if user is navigated to Ticket Types tab on Admin Settings. testcase 01---------");
		
		test = rep.startTest("AdminSettings_TicketTypes_Navigation");
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
			
			WebElement  ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			Thread.sleep(5000);
			
			String currentURL = driver.getCurrentUrl();
			String expectedURL = instanceurl+"ticket_types";
			
			Assert.assertEquals(currentURL, expectedURL);
			log.debug("Successfully Navigated to Ticket Types tab from AdminSettings");
			test.log(LogStatus.PASS, "Successfully Navigated to Ticket Types tab from AdminSettings");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't navigate to Ticket Types tab from AdminSettings");
			test.log(LogStatus.FAIL, e);
		}
		
	}

	/*
	@Test(priority = 02)
	public void AdminSettings_TicketTypes_IsDisplayed() throws SQLException, InterruptedException {
		// Verify if search field and add new Ticket Type button are present (Ticket Types tab)
		log.debug("--------- Verify if search field and add new Ticket Type button are present testcase 02---------");
		
		test = rep.startTest("AdminSettings_TicketTypes_IsDisplayed");
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
			
			WebElement ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			Thread.sleep(4000);
			
			boolean searchTicketType = driver.findElement(By.xpath(OR.getProperty("SearchTicketType"))).isDisplayed();
			log.debug("Search field is displayed - "+searchTicketType);
			
			boolean addNewTicketType = driver.findElement(By.xpath(OR.getProperty("AddNewTicketType"))).isDisplayed();
			log.debug("Add New Ticket Type Button is displayed - "+addNewTicketType);
			
			if (searchTicketType==true && addNewTicketType==true) {
				Assert.assertTrue(true);
				log.debug("Web elements search field and Add New Ticket Type are displayed");
				test.log(LogStatus.PASS, "Web elements search field and Add New Ticket are displayed");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Web elements search field and Add New Ticket type are not displayed");
			test.log(LogStatus.FAIL, e);
		}
								
	}
	
	
	@Test(priority = 03)
	public void AdminSettings_TicketTypes_AddNewTicketType_Navigation() throws SQLException, InterruptedException {
		// Verify if add new Ticket Type window is opened  on click add new Ticket Type (Skills tab)
		log.debug("--------- Verify if add new Ticket Type window is opened  on click add new Ticket Type testcase 03---------");
		
		test = rep.startTest("AdminSettings_TicketTypes_AddNewTicketType_Navigation");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			skills.click();
			log.debug("Ticket Types button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewTicketType"))).click();
			log.debug("Add New Ticket Type button is clicked");
			
			boolean formVisibility = driver.findElement(By.xpath(OR.getProperty("AddNewTicketTypeVisibility"))).isDisplayed();
			log.debug("Form visibility for Add New TicketType - "+formVisibility);
			
			if (formVisibility==true) {
				Assert.assertTrue(true);
				log.debug("Successfully Navigated to Add New Ticket Type tab on Skills tab");
				test.log(LogStatus.PASS, "Successfully Navigated to Add New Ticket Type tab on Skills tab");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't Navigate to Add New Ticket Type on Skills tab");
			test.log(LogStatus.FAIL, e);
		}
				
		
	}
	
	@Test(priority = 04)
	public void AdminSettings_TicketTypes_Add_New_TicketType() throws SQLException, InterruptedException {
		// Verify if add new Ticket Type saves new TicketType. (Ticket Type tab)
		log.debug("--------- Verify if add new Ticket Type saves new TicketType testcase 04---------");
		
		test = rep.startTest("AdminSettings_TicketTypes_Add_New_TicketType");
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
			
			WebElement ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewTicketType"))).click();
			log.debug("Add New Ticket Type button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("TicketTypeName"))).sendKeys("Maintenance");
			log.debug("Ticket Type Name is entered");
			
			driver.findElement(By.xpath(OR.getProperty("TicketTypeDescription"))).sendKeys("maintenance of mechanical machines and repairs");
			log.debug("Ticket Type Description is entered");
			
			driver.findElement(By.xpath(OR.getProperty("TicketResolutionTime"))).sendKeys("220");
			log.debug("Ticket Resolution Time is entered");
			
			driver.findElement(By.xpath(OR.getProperty("SaveTicketType"))).click();
			log.debug("Save button is clicked");
				
			String successMsg = driver.findElement(By.xpath(OR.getProperty("TicketTypeAddedSuccessfully"))).getText();
				
			String expectedMsg = "Ticket Type added successfully";
					
			Assert.assertTrue(successMsg.contains(expectedMsg));
			log.debug("New Ticket Type has been added successfully");
			test.log(LogStatus.PASS, "New Ticket Type has been added successfully");
		}catch (InterruptedException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to add New Ticket Type on TicketType tab");
			test.log(LogStatus.FAIL, e);
		}
				
				
	}
	
	@Test(priority = 05)
	public void AdminSettings_TicketTypes_AddNewTicketType_50_characters() throws InterruptedException, SQLException {
		// Verify if Ticket Type name allows only 50 characters and not more. (Ticket Types tab)
		log.debug("--------- Verify if Ticket Type name allows only 50 characters and not more 05---------");
		
		test = rep.startTest("AdminSettings_TicketTypes_AddNewTicketType_50_characters");
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
			
			
			WebElement ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewTicketType"))).click();
			log.debug("Add New Ticket Type button is clicked");
			
			WebElement ticketTypeName = driver.findElement(By.xpath(OR.getProperty("TicketTypeName")));
			ticketTypeName.sendKeys("PlumbingPlumbingPlumbingPlumbingPlumbingPlumbingPlumbingPlumbing");
			log.debug("Ticket Type Name is entered");
			
			String enteredName = ticketTypeName.getAttribute("value");
			int nameSize = enteredName.length();
			if (nameSize==50) {
				Assert.assertTrue(true);
				log.debug("Testcase Passed, only 50 characters for Ticket Type Name are allowed");
				test.log(LogStatus.PASS, "Testcase Passed, only 50 characters for Ticket Type Name are allowed");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed - Only 50 characters for Ticket Type Name are not allowed might allow more");
			test.log(LogStatus.FAIL, e);
		}
	
	}
	
	@Test(priority = 06)
	public void AdminSettings_TicketTypes_AddNewTicketType_with_Empty_Details() throws SQLException, InterruptedException {
		// Verify if an error message is displayed on save Ticket Types with empty fields. (Ticket Types tab)
		log.debug("---------Verify if an error message is displayed on save Ticket Types with empty fields testcase 06---------");
		
		test = rep.startTest("AdminSettings_TicketTypes_AddNewTicketType_with_Empty_Details");
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
			
			WebElement ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewTicketType"))).click();
			log.debug("Add New Ticket Type button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("SaveTicketType"))).click();
			log.debug("Save button is clicked");
				
			boolean ticketTypeNameRequired = driver.findElement(By.xpath(OR.getProperty("TicketTypeNameIsRequired"))).isDisplayed();
			log.debug("Ticket Type Name Required for Add New Ticket Type is displayed- "+ticketTypeNameRequired);
			
			boolean ticketResolutionTimeRequired = driver.findElement(By.xpath(OR.getProperty("TicketResolutionTimeIsRequired"))).isDisplayed();
			log.debug("Ticket Resolution Time Required for Add New Ticket Type is displayed- "+ticketResolutionTimeRequired);
			
			if (ticketTypeNameRequired==true && ticketResolutionTimeRequired==true) {
				Assert.assertTrue(true);		
				log.debug("Error message is shown when try to save new Ticket Type without entering details");
				test.log(LogStatus.PASS, "Error message is shown when try to save new Ticket Type without entering details");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Error message isn't shown when try to save new Ticket Type without entering details might be able to save ticket type");
			test.log(LogStatus.FAIL, e);
		}
		

	}
	
	@Test(priority = 11)
    public void AdminSettings_Search_TicketTypes() throws SQLException {
        // Verify Ticket Type is searched on entering Ticket Type name in search text box. (Ticket Types tab)
        log.debug("---------Verify Ticket Type is searched on entering Ticket Type name in search text box testcase 11 ---------");
        test = rep.startTest("AdminSettings_Search_TicketTypes");

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
            Thread.sleep(1000);
            WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
            adminSettings.click();
            log.debug("Admin Settings button is clicked"); 
            
            Thread.sleep(4000);
            WebElement ticketTypes = driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
            ticketTypes.click();
            log.debug("Ticket Types button is clicked"); 
            
            Thread.sleep(3000);
            
            WebElement searchSkill = driver.findElement(By.xpath(OR.getProperty("SearchTicketType")));
            searchSkill.sendKeys("Installation");
            
            boolean TicketTypeName = driver.findElement(By.xpath("//td[contains(text(),'Installation')]")).isDisplayed();
            log.debug("Ticket Type after search is displayed - "+ TicketTypeName);
            
            Assert.assertTrue(TicketTypeName);
            log.debug("Ticket Type searched successfully.");
            test.log(LogStatus.PASS,"Ticket Type searched successfully.");
            
        }
        catch (Exception e) {
        // TODO: handle exception
        log.info("Failed to search Ticket Type details");
        test.log(LogStatus.FAIL,e);
        }
    }
    
	@Test(priority = 9)
	public void AdminSettings_TicketTypes_Update_Window() throws InterruptedException, SQLException {
		// Verify if update window is opened on clicking the update icon. (Ticket Types tab)
		log.debug("---------Verify if update window is opened on clicking the update icon testcase 09---------");
			
		test = rep.startTest("AdminSettings_TicketTypes_Update_Window");
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
			
			WebElement ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("UpdateIconTicketTypes_First"))).click();
			log.debug("Update Icon is clicked");
			
			boolean updateTicketTypePopup = driver.findElement(By.xpath(OR.getProperty("UpdateTicketTypeVisibility"))).isDisplayed();
			log.debug("Update Ticket Type Popup is displayed -"+updateTicketTypePopup);
			
			if (updateTicketTypePopup==true) {
				Assert.assertTrue(true);
				log.debug("Update window is opened when clicked on update icon");
				test.log(LogStatus.PASS, "Update window is opened when clicked on update icon");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't open the Update window when clicked on update icon");
			test.log(LogStatus.FAIL, e);
		}

		
	}*/
	
	/*
	@Test(priority = 8)
	public void AdminSettings_TicketTypes_Update_TicketType() throws InterruptedException, SQLException {
		// Verify if a TicketType is updated on clicking update button. (Ticket Types tab)
		log.debug("---------Verify if a TicketType is updated on clicking update button testcase 08---------");
			
		test = rep.startTest("AdminSettings_TicketTypes_Update_TicketType");
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
			
			WebElement  ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("TicketTypes button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("UpdateIconTicketTypes_First"))).click();
			log.debug("Update Icon is clicked");
			boolean  ticketTypeName= driver.findElement(By.xpath("//td[contains(text(),'Maintenance')]")).isDisplayed();
			if(ticketTypeName == true) {
				driver.findElement(By.xpath(OR.getProperty("TicketTypeName"))).sendKeys("Maintainance");
				log.debug("Ticket Type Name is re-entered");
					
				driver.findElement(By.xpath(OR.getProperty("UpdateButtonSkill"))).click();
				log.debug("Update button is clicked");
				
				String updateMSG = driver.findElement(By.xpath(OR.getProperty("TicketTypeUpdatedSuccessfully"))).getText();
				
				String expectedMSG = "Ticket Type updated successfully";
				
				Assert.assertTrue(updateMSG.contains(expectedMSG));
				log.debug("Success message is shown when try to update a Ticket Type and updated sucessfully");
				test.log(LogStatus.PASS, "Success message is shown when try to update a Ticket Type and updated sucessfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to update when clicked on update a Ticket Type");
			test.log(LogStatus.FAIL, e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_TicketTypes_Delete_Window() throws InterruptedException, SQLException {
		// Verify if delete window is opened on clicking the delete icon. (Ticket Types tab)
		log.debug("---------Verify if delete window is opened on clicking the delete icon testcase 10---------");
			
		test = rep.startTest("AdminSettings_TicketTypes_Delete_Window");
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
			
			WebElement  ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("Ticket Types button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("DeleteIconTicketTypes_First"))).click();
			log.debug("Delete Icon is clicked");
			boolean  ticketTypeName= driver.findElement(By.xpath("//td[contains(text(),'Maintenance')]")).isDisplayed();
			if(ticketTypeName == true) {
				boolean deleteTicketTypePopup = driver.findElement(By.xpath(OR.getProperty("DeleteTicketTypeVisibility"))).isDisplayed();
				log.debug("Delete Ticket Types popup is displayed -"+deleteTicketTypePopup);
				
				if (deleteTicketTypePopup==true) {
					Assert.assertTrue(true);
					log.debug("Delete window is opened when clicked on delete icon");
					test.log(LogStatus.PASS, "Delete window is opened when clicked on delete icon");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't open the Delete window when clicked on delete icon");
			test.log(LogStatus.FAIL, e);
		}

	}
	
	@Test(priority = 07)
	public void AdminSettings_TicketTypes_Delete_TicketType() throws InterruptedException, SQLException {
		// Verify if a Ticket Type is deleted on clicking delete button. (Ticket Types tab)
		log.debug("---------Verify if a Ticket Type is deleted on clicking delete button testcase 07---------");
			
		test = rep.startTest("AdminSettings_TicketTypes_Delete_TicketType");
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
			
			WebElement ticketTypes= driver.findElement(By.xpath(OR.getProperty("TicketTypes")));
			ticketTypes.click();
			log.debug("TicketTypes button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("DeleteIconTicketTypes_First"))).click();
			log.debug("Delete Icon is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("DeleteButtonTicketTypes"))).click();
			log.debug("Delete button is clicked");
			
			String deleteMSG = driver.findElement(By.xpath(OR.getProperty("TicketTypeDeletedSuccessfully"))).getText();
			
			String expectedMSG = "Ticket type deleted successfully";
			
			Assert.assertTrue(deleteMSG.contains(expectedMSG));
			log.debug("Success message is shown when try to delete a Ticket type and deleted successfully");
			test.log(LogStatus.PASS, "Success message is shown when try to delete a Ticket type deleted successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to delete when clicked on delete a Ticket type");
			test.log(LogStatus.FAIL, e);
		}
			
				
	}*/
	
}
