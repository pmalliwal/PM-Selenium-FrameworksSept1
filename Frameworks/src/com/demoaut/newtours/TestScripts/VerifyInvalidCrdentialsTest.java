package com.demoaut.newtours.TestScripts;

import com.demoaut.newtours.TestScripts.*;

import utils.GenericMethods;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demoaut.newtours.Pages.Login;
import com.demoaut.newtours.Pages.SignOn;

public class VerifyInvalidCrdentialsTest {

	WebDriver driver;

	@BeforeClass
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("opened the application");

	}

	@Test
	public void verifyInvalidLoginTest() throws IOException {
		Login lp = new Login(driver);
		SignOn so = new SignOn(driver);
		
		String[][] data = GenericMethods.getData("C:\\PM\\TestData.xlsx", "sheet1");
		System.out.println("Befire entering for loop");
		for(int i=0;i<data.length;i++)
		{
			lp.appLogin(data[i][0],data[i][1]);
			Boolean signOnVisible = so.verifySignOnLinkVisible();
			Assert.assertTrue(signOnVisible);
			driver.navigate().back();
		}
	}

	@AfterClass
	public void closeapplication() {
		driver.close();
	}

}
