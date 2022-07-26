package com.ob.pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.ob.basetest.baseTest;
import com.relevantcodes.extentreports.LogStatus;

	public class ManageAccountPage  extends baseTest {

		@FindBy(xpath = "//input[@type='search']")
		WebElement search;
		
		@FindBy(xpath = "//table[@id='indi-list']")
		WebElement userTable;
		
		public ManageAccountPage(WebDriver driver) {
			PageFactory.initElements(driver, this);			
		}
		
		public void enterAccountNo(String accountNo) {
			
			try {
			search.sendKeys(String.valueOf(accountNo));
			test.log(LogStatus.PASS, "Entering account no is successful");
		
		

			
		      }catch(Exception e) {
		    	  test.log(LogStatus.FAIL, "Entering account no is not successful");
			    e.printStackTrace();
			    
		      }
			    }
		
		public void verifyAccountNo(String accountNo) {
			String accNo = userTable.getText();
			if(accNo.contentEquals(accountNo)) {
				System.out.println("Account no is added successfully");
				test.log(LogStatus.PASS, "Account Number verified successfully");
			}
			else {
				test.log(LogStatus.FAIL, "Account Number is not matched");
			}
			
		}
		
			
			
		}
		
	
	
	

	

