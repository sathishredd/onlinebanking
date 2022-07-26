package com.ob.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ob.basetest.baseTest;
import com.ob.pages.AdminHomePage;
import com.ob.pages.AdminLoginPage;
import com.ob.pages.DepositPage;
import com.ob.pages.ManageAccountPage;
import com.ob.pages.NewAccountPage;
import com.ob.pages.UserHomePage;
import com.ob.pages.UserLoginPage;
import com.ob.utilities.Utilities;
@Test
public class deposits extends baseTest {
	String 	adminurl;
	String 	username;
	String 	password;
	String fname = "Venkat";
	String lname = "Krishna reddy";
	String middleName = "VK";
	String emailId  = "onlinetestinghelp@gmail.com";
	String password1 = "Online@123";
	int pinNumber = 1234;
	int begBalance = 10000;
	String accNo = String.valueOf(Utilities.getaccountnum());
	String depositAmt = "10000";
	String balance="";
		
	
	@Test
	public void admindeposit1() throws IOException, InterruptedException {
		
		adminurl = Utilities.getProperty("AdminUrl");
		username =Utilities.getProperty("AdminUserName");
		password =Utilities.getProperty("AdminPassword");
		
		
		driver.get(adminurl);
		
		AdminLoginPage AD=new AdminLoginPage(driver);
		AD.LogIn(username, password);
		
		 AdminHomePage AH=new  AdminHomePage(driver);
		 AH.VerifyAdminLogin();
		 AH.ClickOnAccountManagement();
		 
		 NewAccountPage NA=new NewAccountPage(driver);
		 NA.clickOnNewAccount();
		 NA.createNewAccount(accNo, fname, lname, fname, emailId, password, pinNumber, begBalance);
		 
		 
		 
		 ManageAccountPage ma = new ManageAccountPage(driver);
			ma.enterAccountNo(accNo);
			Thread.sleep(3000);
			ma.verifyAccountNo(accNo);
			
			
			AH.clickOnTransaction();
			
			//Click on Deposit
			DepositPage dp = new DepositPage(driver);
			dp.clickOnDepositLink();
			dp.depositAmt(accNo, depositAmt);
			
			
			driver.get(Utilities.getProperty("UserUrl"));
			UserLoginPage US=new UserLoginPage(driver);
			US.UserLogin(emailId, password);
			
			
			UserHomePage uhp = new UserHomePage(driver);
			uhp.verifyAccountNumber(accNo);
			
			//Verify Deposited amount in user login
			uhp.verifyBalance(balance);
			


		 
		
	}

	
	
	
	
	
	

}
