package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCl {

    public WebDriver driver;

    @BeforeClass
    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU rendering
        options.addArguments("--no-sandbox"); // Required for root privileges
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        
        driver = new ChromeDriver(options); // Pass ChromeOptions to the driver
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
