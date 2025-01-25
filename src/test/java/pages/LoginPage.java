package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	@FindBy(id="user-name") private WebElement emailField;
	@FindBy(id="password") private WebElement passwordField;
	@FindBy(id="login-button") private WebElement loginButton;
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void visitLoginPage() {
		driver.get("https://saucedemo.com");
	}
	
	public void loginWithEmailAndPassword(String email, String password) {
		this.emailField.sendKeys(email);
		this.passwordField.sendKeys(password);
		this.loginButton.click();
	}

}
