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
	
	@Test
	public void loginwithEmailAndPass() {
		String expectedURLAfterLoggingIn = "https://www.saucedemo.com/inventory.html";
		LoginPage lp = new LoginPage(driver);
		lp.visitLoginPage();
		lp.loginWithEmailAndPassword("standard_user", "secret_sauce");
		Assert.assertEquals(driver.getCurrentUrl(), expectedURLAfterLoggingIn);
	}

}
