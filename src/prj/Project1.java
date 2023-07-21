package prj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*
 * Project1
 * Version information : 2023-03 (4.27.0)
 * 1 July 2023
 * Author Name : Mahesh Bhapkar
 * Copyright notice
 */
public class Project1 {
	private Properties properties;
	private String baseUrl;
	//initialization of chrome driver
	public static WebDriver driver = new ChromeDriver();
	
	@BeforeClass
	public void initiLize() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream("C:\\Users\\H379379\\Desktop\\Java\\WebMathPrj\\Property\\Config1.properties");
			properties = new Properties();
			try {
				properties.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String Trig_Cal_locate = properties.getProperty("trig.locator");
		baseUrl = properties.getProperty("baseurl");
		//Defining chrome property & path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H379379\\Desktop\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		//maximizing the window
		driver.manage().window().maximize(); 
		driver.get(baseUrl);	// opening the url 
		//clicking the trig & calculus
 		driver.findElement(By.xpath(Trig_Cal_locate)).click(); 
 		String actualUrl = properties.getProperty("actual.Url");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	

	
	@Test(priority=0)
	public void checkDropDown() {
		String topicItemLocator = properties.getProperty("topicItem.Locator");
		String dropDownSelection = properties.getProperty("dropDownSelection.Locator");
		Select drpSelect = new Select (driver.findElement(By.name(topicItemLocator)));  //click on Coins, Counting to check dropdown functionality
		driver.findElement(By.name(topicItemLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drpSelect.selectByVisibleText(dropDownSelection); 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back(); //navigating to back url
	}
	
	@Test(priority=1)
	public void checkHelpTypingMathLink() {
		String helpTypingMathLocator = properties.getProperty("helpTypingMath.Locator");
		WebElement link = driver.findElement(By.xpath(helpTypingMathLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
 		String actualUrl1 = properties.getProperty("helpTypingMath.Url");
		String expectedUrl1 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl1, expectedUrl1);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void checkHomeLink() {
		String homeLinkLocator = properties.getProperty("homeLink.Locator");
		WebElement link = driver.findElement(By.xpath(homeLinkLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(2)); //switches to new tab
 		String actualUrl2 = properties.getProperty("homeLink.Url");
		String expectedUrl2 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl2, expectedUrl2);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void checkContactUsLink() {
		String contanctUsLocator = properties.getProperty("contanctUs.Locator");
		WebElement link = driver.findElement(By.xpath(contanctUsLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(3)); //switches to new tab
 		String actualUrl3 = properties.getProperty("contanctUs.Url");
		String expectedUrl3 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl3, expectedUrl3);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=4)
	public void checkAboutWebmathLink() {
		String aboutWebMathLocator = properties.getProperty("aboutWebMath.Locator");
		WebElement link = driver.findElement(By.xpath(aboutWebMathLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(4)); //switches to new tab
 		String actualUrl4 = properties.getProperty("aboutWebMath.Url");
		String expectedUrl4 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl4, expectedUrl4);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public void checkWhyWebmathLink() {
		String whyWebMathLocator = properties.getProperty("whyWebMath.Locator");
		WebElement link = driver.findElement(By.xpath(whyWebMathLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(5)); //switches to new tab
 		String actualUrl5 = properties.getProperty("whyWebMath.Url");
		String expectedUrl5 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl5, expectedUrl5);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=6)
	public void checkWebsiteMapLink() {
		String websiteMapLocator = properties.getProperty("websiteMap.Locator");
		WebElement link = driver.findElement(By.xpath(websiteMapLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(6)); //switches to new tab
 		String actualUrl6 = properties.getProperty("websiteMap.Url");
		String expectedUrl6 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl6, expectedUrl6);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=7)
	public void checkPrivacyPolicyLink() {
		String privacyPolicyLocator = properties.getProperty("privacyPolicy.Locator");
		WebElement link = driver.findElement(By.xpath(privacyPolicyLocator));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(7)); //switches to new tab
 		String actualUrl7 = properties.getProperty("privacyPolicy.Url");
		String expectedUrl7 = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl7, expectedUrl7);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public static void exit() {
	//	driver.close();
	//	driver.quit();
	}
}
