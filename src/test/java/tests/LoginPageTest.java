package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseCl;

import pages.LoginPage;

public class LoginPageTest extends BaseCl{
	
	@Test
	public void verifyPageTitle() {
		driver.get("https://saucedemo.com");
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

}
