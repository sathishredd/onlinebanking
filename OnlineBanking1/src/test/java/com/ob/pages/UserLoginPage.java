package com.ob.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ob.basetest.baseTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserLoginPage extends baseTest {
	 
	
	@FindBy(xpath ="//input[@name='email']")
     WebElement email;
	
	@FindBy(xpath ="//input[@name='password']")
    WebElement Password;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginbtn;
	
	
	@FindBy(xpath = "//p[contains(text(),'Deposit')]")
    WebElement depositlink;

	
	
	
	
	public UserLoginPage(WebDriver driver){
		PageFactory.initElements( driver, this);
}
	
	public void UserLogin (String USN,String PSW) {
		try {
		email.sendKeys(USN);
		 Password.sendKeys(PSW);
		 loginbtn.click();
		 test.log(LogStatus.PASS, "User is logged in successfully");
		 
	
	}
	catch(Exception e) {
		test.log(LogStatus.FAIL, "User is not logged in");
}
	}
		
			public void DepositLogin() {
				depositlink.click();
			}
			
		

}