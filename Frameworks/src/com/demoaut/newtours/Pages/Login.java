package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(name="userName")
	private WebElement uname;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		//initialise all the elements of this class on the driver
		
	}
	public void appLogin(String username,String password ) {
		uname.clear();
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
		
	}
}
