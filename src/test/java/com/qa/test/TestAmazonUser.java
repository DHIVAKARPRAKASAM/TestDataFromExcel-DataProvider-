package com.qa.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.ExcelImport;



public class TestAmazonUser {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon."
				+ "in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_youraccount_nav_youraccount_signout%26signIn%3D1%26useRedirectOnSuccess%3D1&prevRID=7YVN45C6HCCV0ZQVB9RA&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	
	}
	@DataProvider
	public Iterator<Object[]> DataExcel() {
		ArrayList<Object[]> lst=ExcelImport.DataFromExcel();
		return lst.iterator();
	}
	
	@Test(dataProvider="DataExcel")
	public void ExcelTest(String name,String mobile,String mail,String password) {
		
	driver.findElement(By.id("ap_customer_name")).sendKeys(name);
	driver.findElement(By.id("ap_phone_number")).sendKeys(mobile);
	driver.findElement(By.id("ap_email")).sendKeys(mail);
	driver.findElement(By.id("ap_password")).sendKeys(password);	
	driver.findElement(By.id("continue")).click();
	
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
