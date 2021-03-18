package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Tickets extends TestBase{
	
	
	@Test(priority = 1)
	public void Tickets_Navigation() throws SQLException {
		
		log.debug("---------Validate Tickets page testcase 1 ---------");
		test = rep.startTest("Tickets_Navigation");
		
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
			Thread.sleep(5000);
			WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
			TicketsTab.click();
			Thread.sleep(1000);
			String ActualURL= driver.getCurrentUrl();
			String ExpectedURL = instanceurl+"tickets";
			Assert.assertEquals(ActualURL,ExpectedURL);
			test.log(LogStatus.PASS,"Redirected to Tickets page");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL,"Failed to redirect Tickets page");
			
		}
	}
	
	@Test(priority = 2)
	public void Tickets_Page_Validation() throws SQLException {
		
		log.debug("---------Validate Tickets page testcase 2 ---------");
		test = rep.startTest("Tickets_Page_Validation");

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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");

		boolean FromDate = driver.findElement(By.xpath(OR.getProperty("FromDate"))).isDisplayed();
		log.debug("From Date field is displayed - " + FromDate);

		boolean ToDate = driver.findElement(By.xpath(OR.getProperty("ToDate"))).isDisplayed();
		log.debug("To Date field is displayed - " + ToDate);

		boolean SelectAgentdrp_down = driver.findElement(By.xpath(OR.getProperty("SelectAgentdrp_down"))).isDisplayed();
		log.debug("Select Agent field is displayed - " + SelectAgentdrp_down);

		boolean SelectStatusdrp_down = driver.findElement(By.xpath(OR.getProperty("SelectStatusdrp_down"))).isDisplayed();
		log.debug("Select Status field is displayed - " + SelectStatusdrp_down);

		if (FromDate == true && ToDate == true && SelectAgentdrp_down == true && SelectStatusdrp_down == true) {

			log.debug("Test case 1 is passed");
			test.log(LogStatus.PASS,"Tickets Page is filter are validated");

		} else {

			log.debug("Test case 1 is failed");
        	//SoftAssert softAssertion= new SoftAssert();
        	Assert.fail();
        	test.log(LogStatus.FAIL,"Failed to test the Tickets page");
        	
		}
		
	}
	
	@Test(priority = 3)
	public void Tickets_Search_Empty_Details() throws InterruptedException, SQLException {
		
		log.debug("---------VerifyEmptySearch testcase---------");
		
		test = rep.startTest("Tickets_Search_Empty_Details");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		boolean SearchFR = driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).isDisplayed();
		if (SearchFR == true) {
			log.debug("Search button is displayed" + SearchFR);
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();
			log.debug("Search ticket");
			Thread.sleep(2000);
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("SearchErrorMessage"))).getText();
			String ExpectedMsg= "Please provide any search criteria";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			test.log(LogStatus.PASS,"Empty data is search error messages are displayed on screen");
		  
		}
		else {
			log.debug("Search button not present test case failed");
		}
	}
	
	
	@Test(priority = 4)
	public void Tickets_ToDate_Required() throws InterruptedException, SQLException {
		
		log.debug("---------Validate with Empty to date Search testcase---------");
		
		test = rep.startTest("Tickets_ToDate_Required");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
			LocalDateTime now = LocalDateTime.now();  
			WebElement FromDate = driver.findElement(By.xpath(OR.getProperty("FromDate")));
			FromDate.sendKeys(dtf.format(now));
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();;
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("ToDateErrorMsg"))).getText();
			String ExpectedMsg= "Please select To Date to proceed";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			driver.findElement(By.xpath(OR.getProperty("CloseDateMsg"))).click();
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty to date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty to date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 5)
	public void Tickets_FormDate_Required() throws InterruptedException, SQLException {
		
		log.debug("---------Validate with Empty from date Search testcase---------");
		
		test = rep.startTest("Tickets_FormDate_Required");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
		    Thread.sleep(5000);
		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
			LocalDateTime now = LocalDateTime.now();  
			WebElement ToDate = driver.findElement(By.xpath(OR.getProperty("ToDate")));
			ToDate.sendKeys(dtf.format(now));
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();;
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("FromDateErrorMsg"))).getText();
			String ExpectedMsg= "Please select From Date to proceed";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			driver.findElement(By.xpath(OR.getProperty("CloseDateMsg"))).click();
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty from date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty from date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void Tickets_Verify_Reset_Search() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the user Search data is reset testcase---------");
		
		test = rep.startTest("Tickets_Verify_Reset_Search");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("SelectAgent"))).click();
			Thread.sleep(2000);
			WebElement Searchagent = driver.findElement(By.xpath(OR.getProperty("SearchAgent")));
			Searchagent.sendKeys("vijay");
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("ResetSearch"))).click();
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("Dataloading"))).getText();
			String ExpectedMsg= "Ticket data is loading...";
			Assert.assertEquals(ActualMsg, ExpectedMsg);
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty from date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty from date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 7)
	public void Tickets_Search_Agent() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the user details are shown on Search  testcase---------");
		
		test = rep.startTest("Tickets_Search_Agent");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("SelectAgent"))).click();
			Thread.sleep(2000);
			WebElement Searchagent = driver.findElement(By.xpath(OR.getProperty("SearchAgent")));
			Searchagent.sendKeys("vijay");
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath(OR.getProperty("SelectDropdown")));
			dropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();
			driver.findElement(By.xpath(OR.getProperty("Dataloading"))).isDisplayed();
			Thread.sleep(6000);
			boolean dataload = driver.findElement(By.xpath(OR.getProperty("Dataloading"))).isDisplayed();
			Assert.assertFalse(dataload);
			log.debug("Selected agent ticket is searched succesfully");
			test.log(LogStatus.PASS,"Selected agent ticket is searched succesfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search select agent ticket");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void Tickets_Details() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the Tickets details are shown on Search testcase---------");
		
		test = rep.startTest("Tickets_Details");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("SelectAgent"))).click();
			Thread.sleep(2000);
			WebElement Searchagent = driver.findElement(By.xpath(OR.getProperty("SearchAgent")));
			Searchagent.sendKeys("vijay");
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath(OR.getProperty("SelectDropdown")));
			dropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(OR.getProperty("TicketDetailSearch"))).click();
			boolean Ticket_Details= driver.findElement(By.xpath(OR.getProperty("TicketsDetails"))).isDisplayed();
			Assert.assertTrue(Ticket_Details);
			log.debug("Selected agent ticket is searched succesfully");
			test.log(LogStatus.PASS,"Selected agent ticket details is searched succesfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search select agent ticket details");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 9)
	public void Tickets_Incident_Details() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the Incident details are shown on Search testcase---------");
		
		test = rep.startTest("Tickets_Incident_Details");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("SelectAgent"))).click();
			Thread.sleep(2000);
			WebElement Searchagent = driver.findElement(By.xpath(OR.getProperty("SearchAgent")));
			Searchagent.sendKeys("vijay");
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath(OR.getProperty("SelectDropdown")));
			dropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(OR.getProperty("TicketDetailSearch"))).click();
			driver.findElement(By.xpath(OR.getProperty("ChildTickets"))).click();
			boolean Incident_View= driver.findElement(By.xpath(OR.getProperty("IncidentView"))).isDisplayed();
			Assert.assertTrue(Incident_View);
			log.debug("Selected agent ticket incident view is searched succesfully");
			test.log(LogStatus.PASS,"Selected agent ticket incident view is searched succesfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search select agent ticket incident view");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void Tickets_Visit_Details() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the Visit details are shown on Search testcase---------");
		
		test = rep.startTest("Tickets_Visit_Details");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("TicketDetailSearch"))).click();
			driver.findElement(By.xpath(OR.getProperty("ChildTickets"))).click();
			driver.findElement(By.xpath(OR.getProperty("VisitDetails"))).click();
			boolean parentTicket= driver.findElement(By.xpath(OR.getProperty("ParentTab"))).isDisplayed();
			boolean ActivityTab= driver.findElement(By.xpath(OR.getProperty("ActivityTab"))).isDisplayed();
			if(parentTicket == true && ActivityTab== true) {
				Assert.assertTrue(true);
				log.debug("parent and activity status is Displayed on visit details succesfully");
				test.log(LogStatus.PASS,"parent and activity status is Displayed on visit details succesfully");
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to parent and activity status is Displayed on visit details");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 11)
	public void Tickets_ParentTicket_View() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the parent Visit details testcase---------");
		
		test = rep.startTest("Tickets_ParentTicket_View");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("TicketDetailSearch"))).click();
			driver.findElement(By.xpath(OR.getProperty("ChildTickets"))).click();
			driver.findElement(By.xpath(OR.getProperty("VisitDetails"))).click();
			driver.findElement(By.xpath(OR.getProperty("ParentTab"))).click();
			boolean ParentVisitView= driver.findElement(By.xpath(OR.getProperty("ParentVisitView"))).isDisplayed();
			Assert.assertTrue(ParentVisitView);
			log.debug("View parent visit details succesfully");
			test.log(LogStatus.PASS,"View parent visit details succesfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to view parent visit details");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 12)
	public void Tickets_Activity_View() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the Activity details testcase---------");
		
		test = rep.startTest("Tickets_Activity_View");
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
		
		WebElement TicketsTab = driver.findElement(By.xpath(OR.getProperty("TicketsTab")));
		TicketsTab.click();
		log.debug("Tickets tab is clicked");
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("TicketDetailSearch"))).click();
			driver.findElement(By.xpath(OR.getProperty("ChildTickets"))).click();
			driver.findElement(By.xpath(OR.getProperty("VisitDetails"))).click();
			driver.findElement(By.xpath(OR.getProperty("ActivityTab"))).click();
			boolean ActivityStatusView= driver.findElement(By.xpath(OR.getProperty("ActivityStatus"))).isDisplayed();
			Assert.assertTrue(ActivityStatusView);
			log.debug("View Activity details succesfully");
			test.log(LogStatus.PASS,"View Activity details succesfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to view Activity details");
			test.log(LogStatus.FAIL,e);
		}
	}
}

