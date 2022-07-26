package com.ob.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {

	@FindBy(xpath="//p[contains(text(),'Deposit')]")
	WebElement depositLink;
	
	@FindBy(name="account_number")
	WebElement accountNumber;
	
	@FindBy(name="balance")
	WebElement balance;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	public DepositPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnDepositLink() {
		depositLink.click();
	}
	
	public void depositAmt(String accountNo, String amount) throws InterruptedException {
		accountNumber.sendKeys(accountNo);
		Thread.sleep(3000);
		balance.clear();
		balance.sendKeys(amount);
		Thread.sleep(8000);
		
		submitBtn.click();
	}
}