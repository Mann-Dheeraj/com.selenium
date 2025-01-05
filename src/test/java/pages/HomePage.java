package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void addItemWithMaxPriceToCart() {
		List<WebElement> price = driver.findElements(By.className("inventory_item_price")); 
		
		float maxPrice = 0f;
		String maxPriceXpath= "";
		for(WebElement el: price) {
			float p = Float.parseFloat(el.getText().replace("$", ""));
			if(maxPrice <p) {
				maxPrice = Math.max(maxPrice, p);
				maxPriceXpath = "//div[text()='"+maxPrice+"']/following-sibling::button";
			}
			
			
		}
		
		driver.findElement(By.xpath(maxPriceXpath)).click();

	}

}
