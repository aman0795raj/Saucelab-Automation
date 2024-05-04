package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Base;

public class Saucelabs extends Base{
	public WebDriver Driver;
	
	@Test(
			priority=0
			)
	public void moveToLoginPage() { 
		Driver = driver;
	}
	
}
