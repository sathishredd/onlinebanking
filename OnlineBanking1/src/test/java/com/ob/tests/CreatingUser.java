package com.ob.tests;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ob.basetest.baseTest;
import com.ob.pages.AdminHomePage;
import com.ob.pages.AdminLoginPage;
import com.ob.pages.ManageAccountPage;
import com.ob.pages.NewAccountPage;
import com.ob.pages.UserDeposits;
import com.ob.pages.UserLoginPage;
import com.ob.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
 class CreatingUser extends baseTest{
	 Logger log;
	    
	
	 @Test
	public void  CreatingUser() throws IOException, InterruptedException{
		
	
		try {

			log= (Logger) LogManager.getLogger(CreatingUser.class);
			
			
		String userName;
		String password;
		String adminUrl;
		
		String accNo = String.valueOf(Utilities.getaccountnum());
		String fname = "sathish";
		String midName = "reddy";
		String lname = "surasani";
		String emailId = "onlinetestinghelp1@gmail.com";
		String passwrd = "Online@123";
		int pinNum = 123345;
		int begBalance = 12344556;
		
	
		
		adminUrl = Utilities.getProperty("AdminUrl");
		userName = Utilities.getProperty("AdminUserName");
		password = Utilities.getProperty("AdminPassword");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get(adminUrl);
		
		AdminLoginPage a1=new AdminLoginPage(driver);
		a1.LogIn(userName, password);
		
		AdminHomePage ah=new AdminHomePage(driver);
		ah.VerifyAdminLogin();
		
		ah.ClickOnAccountManagement();
		
		NewAccountPage nc=new NewAccountPage(driver);
		
		nc.clickOnNewAccount();
		nc.createNewAccount( accNo, fname, midName, lname, emailId, passwrd, pinNum, begBalance);
		
		ManageAccountPage ma = new ManageAccountPage(driver);
		ma.enterAccountNo(accNo);
		
		ma.verifyAccountNo(password);
		
		Thread.sleep(8000);
	
		
		driver.get(Utilities.getProperty("UserUrl"));
		UserLoginPage us=new UserLoginPage(driver);
	
		us.UserLogin(emailId, passwrd);//
		us.DepositLogin();
		test.log(LogStatus.PASS,"New User Creation is done successfully");
		

			
		}catch(Exception e) {
			test.log(LogStatus.FAIL,"New User not   done successfully");
			log.info("New User is not successful");

			e.printStackTrace();
	
		
		
		
		
	
		 
		
		
		
		}	
		
		
		
	}

}
