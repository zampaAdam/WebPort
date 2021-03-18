package com.goDeskless.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TicketFlow{
	
	public static String visitStatus = null;
	public static String ticketSubject="";
	public static String requestor="";
	public static String ticketPriority="";
	public static String assignedAgent="";
	public static String searchLoc="";
	public static String description= "";
	Scanner sc = new Scanner(System.in);
	
	@Test(priority = 1)
	public void CreateTicketsAssignAgent() throws SQLException {
		
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver.exe");

	    	WebDriver driver = new ChromeDriver();
	        driver.get("https://petalqa.godeskless.com/#/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//	        log.debug("---------Create Ticket---------");
//	        test = rep.startTest("CreateTicketsAssignAgent");
	        try {
	            	            
	        WebElement UserName = driver.findElement(By.xpath(("//input[@name='email']")));
	        UserName.sendKeys("dhanashree.mane@petal.com");
//	        log.debug("User Name is entered");

	        WebElement Password = driver.findElement(By.xpath(("//input[@name='password']")));
	        Password.sendKeys("welcome123");
//	        log.debug("Password is entered");

	        WebElement SignIn = driver.findElement(By.xpath(("//button[@type='submit']")));
	        SignIn.click();
//	        log.debug("SignIn button is clicked");
	        }catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        try {

	            Thread.sleep(5000);
	            WebElement ticketsTab = driver.findElement(By.xpath("//span[text()='Tickets']"));
	            ticketsTab.click();
	            driver.findElement(By.xpath("//button[@ng-click='openTicketModel()']")).click();
	            WebElement Subject = driver.findElement(By.xpath("//input[@ng-model='createTicketData.subject']"));
	            Subject.sendKeys("AC cooling not working");
	            
	            WebElement ticketRequestor = driver.findElement(By.xpath("//input[@name='requester']"));
	            ticketRequestor.sendKeys("yopmail.com");
	            Thread.sleep(3000);
	            WebElement selectRequestor= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/ul[1]/li[1]"));
	            selectRequestor.click();
	            
	            driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='priorityData']//button[contains(text(),'Select Priority')]")).click();
	            WebElement priority = driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='priorityData']//input[@ng-change='searchChanged()']"));
	            priority.sendKeys("Medium");
	            driver.findElement(By.xpath("//div[@class='acol']//label//span[@ng-class='{disabled:itemIsDisabled( item )}'][contains(text(),'Medium')]")).click();
	            
	            driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='assignedAgentData']//button[contains(text(),'Select Agent')]")).click();
	            WebElement agent = driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='assignedAgentData']//input[@ng-change='searchChanged()']"));
	            agent.sendKeys("dhanashree.mane@petal.com");      
	            driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='assignedAgentData']//div[@class='acol']//label//span[@ng-class='{disabled:itemIsDisabled( item )}']")).click();
	            
	            driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='locationData']//button[contains(text(),'Select Location')]")).click();
	            WebElement location = driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='locationData']//input[@ng-change='searchChanged()']"));
	            location.sendKeys("pune");
	            driver.findElement(By.xpath("//form[@name='add_ticket']//div[@input-model='locationData']//span[@ng-class='{disabled:itemIsDisabled( item )}']")).click();
	  
	            WebElement ticketDescription= driver.findElement(By.xpath("//form[@name='add_ticket']//textarea[@ng-model='createTicketData.description']"));
	            ticketDescription.sendKeys("test me");
	            
	            Thread.sleep(5000);
	            driver.findElement(By.xpath("//form[@name='add_ticket']//button[@ng-click='createTicket()'][contains(text(),'Save')]")).click();
	       	            
	            Thread.sleep(8000);
//	            String actualMsg = driver.findElement(By.xpath(("//div[contains(text(),'Ticket Created Successfully.')]"))).getText();
//	            String expectedMsg = "Ticket Created Successfully.";
//	            org.testng.Assert.assertEquals(actualMsg, expectedMsg);
	            driver.findElement(By.xpath(("//div[@id='addNewTicketPopup']//button[@class='close']"))).click();
	            Thread.sleep(8000);
	            driver.findElement(By.xpath(("(//button[@ng-click=\"scheduleVisit(ticket,'schedule_visit')\"])[1]"))).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath(("//div[@input-model='allAssignedAgentData']//span//button[contains(text(),'Select Field Engineer')]"))).click();
	            WebElement searchFR = driver.findElement(By.xpath(("//div[@input-model='allAssignedAgentData']//input[@placeholder='Type here to search...']")));
	            searchFR.sendKeys("Dhanashree Fr");
	            driver.findElement(By.xpath(("//div[@input-model='allAssignedAgentData']//div[@class='acol']//label//span[@ng-class='{disabled:itemIsDisabled( item )}']"))).click();
	            driver.findElement(By.xpath(("//button[contains(text(),'Submit')]"))).click();
	            Thread.sleep(5000);
//	            String actualMsg1 = driver.findElement(By.xpath(("//div[contains(text(),'Visit Created Successfully.')]"))).getText();
//	            String expectedMsg1 = "Visit Created Successfully.";
//	            org.testng.Assert.assertEquals(actualMsg1, expectedMsg1);
			
	            driver.close();
	            driver.quit();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			log.debug("Failed to create Tickets page");
//			test.log(LogStatus.FAIL,e);
			
		}
	}
	
}
			   
