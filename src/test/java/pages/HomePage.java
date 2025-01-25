package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	private WebDriver driver;
	@FindBy (className="inventory_item_price") private List<WebElement> priceList;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addItemWithMaxPriceToCart() {
//		List<WebElement> price = driver.findElements(By.className("inventory_item_price")); 
		
		float maxPrice = 0f;
		String maxPriceXpath= "";
		for(WebElement el: this.priceList) {
			float p = Float.parseFloat(el.getText().replace("$", ""));
			if(maxPrice <p) {
				maxPrice = Math.max(maxPrice, p);
				maxPriceXpath = "//div[text()='"+maxPrice+"']/following-sibling::button";
			}
			
			
		}
		
		driver.findElement(By.xpath(maxPriceXpath)).click();

	}

}
