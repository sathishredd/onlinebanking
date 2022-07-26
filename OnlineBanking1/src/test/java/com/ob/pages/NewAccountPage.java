package com.ob.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ob.basetest.baseTest;
import com.ob.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class NewAccountPage   extends baseTest {
	
	
	
	@FindBy(xpath ="//input[@name='account_number']")
	WebElement AccountNumber;
	

	@FindBy(xpath ="//input[@name='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath ="//input[@name='middlename']")
	WebElement Middlename;
	

	@FindBy(xpath ="//input[@name='lastname']")
	WebElement LastName;
	

	@FindBy(xpath ="//input[@name='email']")
	WebElement EMail;
	
	@FindBy(xpath="//input[@name='generated_password']")
	WebElement password;
	
	@FindBy(xpath ="//input[@name='pin']")
	WebElement pin;
	
	@FindBy(xpath ="//input[@name='balance']")
	WebElement BeggingBalance;
	
	@FindBy(xpath ="//button[text()='Save'][@form='account-form']")
	WebElement Save;
	
	@FindBy(xpath = "//p[contains(text(),'New Account')]")
	WebElement newAccount;
	
	
	public NewAccountPage(WebDriver driver){
		PageFactory.initElements( driver, this);
		
		
		
	}
	public void clickOnNewAccount() {
		newAccount.click();
	}
		
		public void createNewAccount(String accNo, String fname,String lname,String midName,String emailId,String passwrd,int pinNum,int begBalance) throws InterruptedException {
			
			try {
			AccountNumber.sendKeys(accNo);
			FirstName.sendKeys(fname);
			LastName.sendKeys(lname);
			Middlename.sendKeys(midName);
			EMail.sendKeys(emailId);
			password.sendKeys(passwrd);
			pin.sendKeys(String.valueOf(pinNum));
		    BeggingBalance.sendKeys(String.valueOf(begBalance));
		    Thread.sleep(8000);
			Save.click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "Account number is created successfully");
			}catch(Exception e) {
				test.log(LogStatus.FAIL, "Account Number is not created");
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}		
	

}
