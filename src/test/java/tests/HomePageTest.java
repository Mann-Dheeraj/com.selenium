package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import com.selenium.base.BaseCl;
import properties.ExpectedResultFromPropertyFile;

public class HomePageTest extends BaseCl {

	@BeforeClass

	public void loginWithEmailAndPassword() {
		LoginPage loginpage = new LoginPage(driver);
		String email = System.getenv("sauceLabsEmail");
		String password = System.getenv("sauceLabsPassword");


		loginpage.visitLoginPage();
		loginpage.loginWithEmailAndPassword(email, password);

	}
	
	@Test 
	public void verifyHomePageTitle() throws InterruptedException {

	    if (!driver.getTitle().equalsIgnoreCase("Swag Labs")) {
	        driver.get("https://www.saucedemo.com/inventory.html");
	    }
		String expectedPageTitle = (ExpectedResultFromPropertyFile.get("login.page.title"));
		Assert.assertEquals(driver.getTitle(), expectedPageTitle);
	}

	@Test
	public void addItemWithMaxPriceToCart() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		    if (!driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) {
		        driver.get("https://www.saucedemo.com/inventory.html");
		    }
		homepage.addItemWithMaxPriceToCart();
	}

}
