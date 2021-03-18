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


public class AdminSettings_Skills extends TestBase{
	
	@Test(priority = 1)
	public void AdminSettings_Skills_Navigation() throws SQLException, InterruptedException {
		// Verify if user is navigated to Skills tab on Admin Settings.(Skills Tab)
		log.debug("--------- Verify if user is navigated to Skills tab on Admin Settings. testcase 01---------");
		
		test = rep.startTest("AdminSettings_Skills_Navigation");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(5000);
			
			String currentURL = driver.getCurrentUrl();
			String expectedURL = instanceurl+"skills";
			
			Assert.assertEquals(currentURL, expectedURL);
			log.debug("Successfully Navigated to Skills tab from AdminSettings");
			test.log(LogStatus.PASS, "Successfully Navigated to Skills tab from AdminSettings");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't navigate to Skills tab from AdminSettings");
			test.log(LogStatus.FAIL, e);
		}
		
	}

	/*
	@Test(priority = 2)
	public void AdminSettings_Skills_IsDisplayed() throws SQLException, InterruptedException {
		// Verify if search fields and add new skill button are present (Skills tab)
		log.debug("--------- Verify if search fields and add new skill button are present testcase 02---------");
		
		test = rep.startTest("AdminSettings_Skills_IsDisplayed");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(4000);
			
			boolean searchField = driver.findElement(By.xpath(OR.getProperty("SearchSkill"))).isDisplayed();
			log.debug("Search field is displayed - "+searchField);
			
			boolean addNewSkillButton = driver.findElement(By.xpath(OR.getProperty("AddNewSkill"))).isDisplayed();
			log.debug("Add New Skill Button is displayed - "+addNewSkillButton);
			
			if (searchField==true && addNewSkillButton==true) {
				Assert.assertTrue(true);
				log.debug("Web elements search field and Add New Skill are displayed");
				test.log(LogStatus.PASS, "Web elements search field and Add New Skill are displayed");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Web elements search field and Add New Skill are not displayed");
			test.log(LogStatus.FAIL, e);
		}
								
	}
	
	
	@Test(priority = 3)
	public void AdminSettings_AddNewSkills_Navigation() throws SQLException, InterruptedException {
		// Verify if add new skill window is opened  on click add new skill (Skills tab)
		log.debug("--------- Verify if add new skill window is opened  on click add new skill testcase 03---------");
		
		test = rep.startTest("AdminSettings_Skills_AddNewSkills_Navigation");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewSkill"))).click();
			log.debug("Add New Skill button is clicked");
			
			boolean formVisibility = driver.findElement(By.xpath(OR.getProperty("AddNewSkillVisibility"))).isDisplayed();
			log.debug("Form visibility for Add New Skill - "+formVisibility);
			
			if (formVisibility==true) {
				Assert.assertTrue(true);
				log.debug("Successfully Navigated to Add New Skill tab on Skills tab");
				test.log(LogStatus.PASS, "Successfully Navigated to Add New Skill tab on Skills tab");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't Navigate to Add New Skill on Skills tab");
			test.log(LogStatus.FAIL, e);
		}
				
		
	}
	
	@Test(priority = 4)
	public void AdminSettings_Add_New_Skill() throws SQLException, InterruptedException {
		// Verify if add new skill saves new skill. (Skills tab)
		log.debug("--------- Verify if add new skill saves new skill testcase 04---------");
		
		test = rep.startTest("AdminSettings_Add_New_Skill");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewSkill"))).click();
			log.debug("Add New Skill button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("SkillName"))).sendKeys("Carpenter");
			log.debug("Skill name is entered");
			
			driver.findElement(By.xpath(OR.getProperty("SkillDescription"))).sendKeys("Construction and repairs of building frameworks ");
			log.debug("Skill description is entered");
			
			driver.findElement(By.xpath(OR.getProperty("SaveSkill"))).click();
			log.debug("Save button is clicked");
				
			String successMsg = driver.findElement(By.xpath(OR.getProperty("SkillAddedSuccesfully"))).getText();
				
			String expectedMsg = "Skill added successfully";
					
			Assert.assertTrue(successMsg.contains(expectedMsg));
			log.debug("New Skill has been added successfully");
			test.log(LogStatus.PASS, "New Skill has been added successfully");
		}catch (InterruptedException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to add New Skill on skills tab");
			test.log(LogStatus.FAIL, e);
		}
	}
	

	@Test(priority = 5)
	public void AdminSettings_AddNewSkill_SameDetails() throws SQLException, InterruptedException {
		// Verify if add new skill saves new skill. (Skills tab)
		log.debug("--------- Verify if add new skill saves new skill testcase 04---------");
		
		test = rep.startTest("AdminSettings_AddNewSkill_SameDetails");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewSkill"))).click();
			log.debug("Add New Skill button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("SkillName"))).sendKeys("Carpenter");
			log.debug("Skill name is entered");
			
			driver.findElement(By.xpath(OR.getProperty("SkillDescription"))).sendKeys("Construction and repairs of building frameworks ");
			log.debug("Skill description is entered");
			
			driver.findElement(By.xpath(OR.getProperty("SaveSkill"))).click();
			log.debug("Save button is clicked");
				
			String successMsg = driver.findElement(By.xpath(OR.getProperty("AddSameSkill"))).getText();
				
			String expectedMsg = "Skill with this name already present";
					
			Assert.assertTrue(successMsg.contains(expectedMsg));
			log.debug("Same name Skill message is displayed");
			test.log(LogStatus.PASS, "Same name Skill message is displayed");
		}catch (InterruptedException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to add New Skill on skills tab");
			test.log(LogStatus.FAIL, e);
		}
				
				
	}
	
	@Test(priority = 6)
	public void AdminSettings_AddNewSkill_50_characters() throws InterruptedException, SQLException {
		// Verify if Skill name allows only 50 characters and not more. (Skills tab)
		log.debug("--------- Verify if Skill name allows only 50 characters and not more 05---------");
		
		test = rep.startTest("AdminSettings_AddNewSkill_50_characters");
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
			
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewSkill"))).click();
			log.debug("Add New Skill button is clicked");
			
			WebElement skillName = driver.findElement(By.xpath(OR.getProperty("SkillName")));
			skillName.sendKeys("CarpenterCarpenterCarpenterCarpenterCarpenterCarpenter");
			log.debug("Skill name is entered");
			
			String enteredName = skillName.getAttribute("value");
			int nameSize = enteredName.length();
			if (nameSize==50) {
				Assert.assertTrue(true);
				log.debug("Testcase Passed, only 50 characters for Skill name are allowed");
				test.log(LogStatus.PASS, "Testcase Passed, only 50 characters for Skill name are allowed");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed - Only 50 characters are not allowed, Could allow more");
			test.log(LogStatus.FAIL, e);
		}
		

		
	}
	
	@Test(priority = 7)
	public void AdminSettings_Skills_AddNewSkill_with_Empty_Details() throws SQLException, InterruptedException {
		// Verify if an error message is displayed on save skills with empty fields. (Skills tab)
		log.debug("---------Verify if an error message is displayed on save skills with empty fields testcase 06---------");
		
		test = rep.startTest("AdminSettings_Skills_AddNewSkill_with_Empty_Details");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("AddNewSkill"))).click();
			log.debug("Add New Skill button is clicked");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(OR.getProperty("SaveSkill"))).click();
			log.debug("Save button is clicked");
				
			boolean skillNameRequired = driver.findElement(By.xpath(OR.getProperty("SkillNameIsRequired"))).isDisplayed();
			log.debug("Skill Name Required for Add New Skill is displayed- "+skillNameRequired);
			
			if (skillNameRequired==true) {
				Assert.assertTrue(true);		
				log.debug("Error message is shown when try to save new skill without entering details");
				test.log(LogStatus.PASS, "Error message is shown when try to save new skill without entering details");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Error message isn't shown when try to save new skill without entering details might save a skill");
			test.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test(priority = 8)
    public void AdminSettings_Search_Skill() throws SQLException {
        // Verify skill is searched on entering skill name in search text box. (Skill tab)
        log.debug("---------Verify skill is searched on entering skill name in search text box testcase 11 ---------");
        test = rep.startTest("AdminSettings_Search_Skill");

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
            WebElement skills = driver.findElement(By.xpath(OR.getProperty("Skills")));
            skills.click();
            log.debug("Skills button is clicked"); 
            
            Thread.sleep(3000);
            
            WebElement searchSkill = driver.findElement(By.xpath(OR.getProperty("SearchSkill")));
            searchSkill.sendKeys("Electrical");
            
            boolean skillName = driver.findElement(By.xpath("//td[contains(text(),'Electrical')]")).isDisplayed();
            log.debug("skill after search is displayed - "+ skillName);
            
            Assert.assertTrue(skillName);
            log.debug("Skill searched successfully.");
            test.log(LogStatus.PASS,"Skill searched successfully.");
            
        }
        catch (Exception e) {
        // TODO: handle exception
        log.info("Failed to search Skill details");
        test.log(LogStatus.FAIL,e);
        }
    }
	@Test(priority = 9)
	public void AdminSettings_Skills_Update_Window() throws InterruptedException, SQLException {
		// Verify if update window is opened on clicking the update icon. (Skills tab)
		log.debug("---------Verify if update window is opened on clicking the update icon testcase 09---------");
			
		test = rep.startTest("AdminSettings_Skills_Update_Window");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("UpdateIconSkills_First"))).click();
			log.debug("Update Icon is clicked");
			
			boolean updateSkillPopup = driver.findElement(By.xpath(OR.getProperty("UpdateSkillVisibility"))).isDisplayed();
			log.debug("Update skill popup is displayed -"+updateSkillPopup);
			
			if (updateSkillPopup==true) {
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

		
	}
	
	@Test(priority = 10)
	public void AdminSettings_Skills_Update_Skill() throws InterruptedException, SQLException {
		// Verify if a Skill is updated on clicking update button. (Skills tab)
		log.debug("---------Verify if a Skill is updated on clicking update button testcase 08---------");
			
		test = rep.startTest("AdminSettings_Skills_Update_Skill");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			boolean  skillName= driver.findElement(By.xpath("//td[contains(text(),'carpentry')]")).isDisplayed();
			if(skillName == true) {
				driver.findElement(By.xpath(OR.getProperty("UpdateIconSkills_First"))).click();
				WebElement updateSkillName= driver.findElement(By.xpath(OR.getProperty("UpdateSkillName")));
				updateSkillName.clear();
				updateSkillName.sendKeys("Carpentary");
				log.debug("Skill name is re-entered");
				Thread.sleep(5000);
				driver.findElement(By.xpath(OR.getProperty("UpdateButtonSkill"))).click();
				log.debug("Update button is clicked");
				Thread.sleep(2000);
				String updateMSG = driver.findElement(By.xpath(OR.getProperty("SkillUpdatedSuccessfully"))).getText();
				String expectedMSG = "Skill updated successfully";
				Assert.assertTrue(updateMSG.contains(expectedMSG));
				log.debug("Success message is shown when try to update a skill updated successfully");
				test.log(LogStatus.PASS, "Success message is shown when try to update a skill updated successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to update when clicked on update a skill");
			test.log(LogStatus.FAIL, e);
		}
	}
	
	@Test(priority = 11)
	public void AdminSettings_Skills_Delete_Window() throws InterruptedException, SQLException {
		// Verify if delete window is opened on clicking the delete icon. (Skills tab)
		log.debug("---------Verify if delete window is opened on clicking the delete icon testcase 10---------");
			
		test = rep.startTest("AdminSettings_Skills_Delete_Window");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("DeleteIconSkills_First"))).click();
			log.debug("Delete Icon is clicked");
			
			boolean deleteSkillPopup = driver.findElement(By.xpath(OR.getProperty("DeleteSkillVisibility"))).isDisplayed();
			log.debug("Delete skill popup is displayed -"+deleteSkillPopup);
			
			if (deleteSkillPopup==true) {
				Assert.assertTrue(true);
				log.debug("Delete window is opened when clicked on delete icon");
				test.log(LogStatus.PASS, "Delete window is opened when clicked on delete icon");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Couldn't open the Delete window when clicked on delete icon");
			test.log(LogStatus.FAIL, e);
		}

	}
	
	@Test(priority = 12)
	public void AdminSettings_Skills_Delete_Skill() throws InterruptedException, SQLException {
		// Verify if a Skill is deleted on clicking delete button. (Skills tab)
		log.debug("---------Verify if a Skill is deleted on clicking delete button testcase 07---------");
			
		test = rep.startTest("AdminSettings_Skills_Delete_Skill");
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
			
			WebElement  skills= driver.findElement(By.xpath(OR.getProperty("Skills")));
			skills.click();
			log.debug("Skills button is clicked");
			
			driver.findElement(By.xpath(OR.getProperty("DeleteIconSkills_First"))).click();
			log.debug("Delete Icon is clicked");
			boolean  skillName= driver.findElement(By.xpath("//td[contains(text(),'carpentry')]")).isDisplayed();
			if(skillName == true) {
				driver.findElement(By.xpath(OR.getProperty("DeleteButtonSkill"))).click();
				log.debug("Delete button is clicked");
				String deleteMSG = driver.findElement(By.xpath(OR.getProperty("SkillDeletedSuccessfully"))).getText();
				String expectedMSG = "Skill deleted successfully";
				Assert.assertTrue(deleteMSG.contains(expectedMSG));
				log.debug("Success message is shown when try to delete a skill Deleted successfully");
				test.log(LogStatus.PASS, "Success message is shown when try to delete a skill Deleted successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to delete when clicked on delete a skill");
			test.log(LogStatus.FAIL, e);
		}
			
				
	}*/
	
}
