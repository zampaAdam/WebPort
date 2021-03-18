package com.goDeskless.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.goDeskless.base.TestBase;

public class TestCases extends TestBase {

	
	
	
	@Test(enabled=false)
	public void Login_Dashboard_19() {
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys("tom.green@yopmail.com");
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys("welcome123");
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		//Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//span[text()='Tickets']")).click();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expectedPageHeader = "Tickets";
		String actualPageHeader   = driver.findElement(By.xpath("//h5[text()='Tickets']")).getText();
		
 		Assert.assertEquals(actualPageHeader, expectedPageHeader);
		
 		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		boolean FromDatedrp_down=driver.findElement(By.xpath("//input[@name='from_date']")).isDisplayed();
		log.debug("From Date field is displayed - "+ FromDatedrp_down);
		
		
		boolean ToDatedrp_down=driver.findElement(By.xpath("//input[@name='to_date']")).isDisplayed();
		log.debug("To Date field is displayed - "+ ToDatedrp_down);
		
		
		boolean SelectAgentdrp_down=driver.findElement(By.xpath("//button[text()='Select Agent']")).isDisplayed();
		log.debug("Select Agent field is displayed - "+ SelectAgentdrp_down);
		
		boolean SelectStatusdrp_down=driver.findElement(By.xpath("//button[text()='Select Status']")).isDisplayed();
		log.debug("Select Status field is displayed - "+ SelectStatusdrp_down);
		
		if (FromDatedrp_down==false && ToDatedrp_down==true && SelectAgentdrp_down==true && SelectStatusdrp_down==true)
        {
               // click on the search button
            log.debug("Test case is passed");  
			
        }else {
	
        	log.debug("Test case is failed");
        	SoftAssert softAssertion= new SoftAssert();
        	softAssertion.assertAll();
		}
			
	}

	
	@Test(enabled=false)
	 public void softAssert(){
	 SoftAssert softAssertion= new SoftAssert();
	 softAssertion.assertTrue(false);
	 softAssertion.assertAll();
	
	}
	
	@Test
	public void Login_Dashboard_20() {
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys("tom.green@yopmail.com");
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys("welcome123");
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		//Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement AdminSettings = driver.findElement(By.xpath("//span[text()='Admin Settings']"));
		AdminSettings.click();
		
		WebElement UserProfile = driver.findElement(By.xpath("//a[@id='userDropdown']"));
		UserProfile.click();
		
		WebElement ProfileButton = driver.findElement(By.xpath("//a[@ng-click='goToProfile()']"));
		ProfileButton.click();
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//WebElement EditProfile = driver.findElement(By.xpath("//a[@ng-click='editProfile()']"));
		boolean EditProfile=driver.findElement(By.xpath("//a[@ng-click='editProfile()']")).isDisplayed();
		log.debug("Edit Profile field is displayed - "+ EditProfile);
		
		boolean ChangePassword=driver.findElement(By.xpath("//a[@class='chngpw'][@ng-click='changePassword()']")).isDisplayed();
		log.debug("Change Password field is displayed - "+ ChangePassword);
		
		if (EditProfile==true && ChangePassword==true )
        {
               // click on the search button
            log.debug("20th Test case is passed");  
			
        }else {
	
        	log.debug("20th Test case is failed");
        	//SoftAssert softAssertion= new SoftAssert();
        	Assert.fail();
        	
		}
		
		
	}
	
	
	
	
}
