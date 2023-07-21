package prj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestFunctionality {
	String path= "C:\\Users\\H379379\\Desktop\\SeleniumJars";
	private Properties properties;
	private String baseUrl;
	//initialization of chrome driver
	public static WebDriver driver = new ChromeDriver();
	
	@BeforeClass
	public void initiLize() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream("C:\\Users\\H379379\\Desktop\\Java\\WebMathPrj\\Property\\Config2.properties");
			properties = new Properties();
			try {
				properties.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Defining chrome property & path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\H379379\\Desktop\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		//maximizing the window
		driver.manage().window().maximize(); 
		String Trig_Cal_locate = properties.getProperty("trig.locator");
		baseUrl = properties.getProperty("baseurl");
		driver.get(baseUrl);	// opening the url 
		//clicking the trig & calculus
 		driver.findElement(By.xpath(Trig_Cal_locate)).click(); 
 		String actualUrl = properties.getProperty("actual.Url");
		String expectedUrl = driver.getCurrentUrl();
		// validation of actual & current url
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

	@Test(priority=0)
	public void testTrigExp() {
		String trigExpLinkLocator = properties.getProperty("trigExpLink.Locator");
		String trigExpInputLocator = properties.getProperty("trigExpInput.Locator");
		String clickToSimplifyLocator = properties.getProperty("clickToSimplify.Locator");
		String exp = properties.getProperty("expression");
		driver.findElement(By.xpath(trigExpLinkLocator)).click();
		driver.findElement(By.xpath(trigExpInputLocator)).sendKeys(exp);
		driver.findElement(By.xpath(clickToSimplifyLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
	}

	
	@Test(priority=1)
	public void rightTriangle() {
		String rightTriangleLinkLocator = properties.getProperty("rightTriangleLink.Locator");
		String angleDLocator = properties.getProperty("angleD.Locator");
		String angleELocator = properties.getProperty("angleE.Locator");
		String legALocator = properties.getProperty("legA.Locator");
		String legBLocator = properties.getProperty("legB.Locator");
		String hypCLocator = properties.getProperty("hypC.Locator");
		String goButtonLocator = properties.getProperty("goButton.Locator");
		
		String angleD = properties.getProperty("angleD.value");
		String angleE = properties.getProperty("angleE.value");
		String legA = properties.getProperty("legA.value");
		String legB = properties.getProperty("legB.value");
		String hypC = properties.getProperty("hypC.value");
		
		driver.findElement(By.xpath(rightTriangleLinkLocator)).click();
		driver.findElement(By.xpath(angleDLocator)).sendKeys(angleD);
		driver.findElement(By.xpath(angleELocator)).sendKeys(angleE);
		driver.findElement(By.xpath(legALocator)).sendKeys(legA);
		driver.findElement(By.xpath(legBLocator)).sendKeys(legB);
		driver.findElement(By.xpath(hypCLocator)).sendKeys(hypC);
		driver.findElement(By.xpath(goButtonLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void testDerivative() {
		String derivativeLinkLocator = properties.getProperty("derivativeLink.Locator");
		String differentiateLocator = properties.getProperty("differentiate.Locator");
		
		driver.findElement(By.xpath(derivativeLinkLocator)).click();
		driver.findElement(By.xpath(differentiateLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test(priority=3)
	public void testQuotient() {
		String quotientLinkLocator = properties.getProperty("quotientLink.Locator");
		String differentiateQuatientLocator = properties.getProperty("differentiateQuatient.Locator");
		
		driver.findElement(By.xpath(quotientLinkLocator)).click();
		driver.findElement(By.xpath(differentiateQuatientLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test(priority=4)
	public void testIntegral() {
		String integralLinkLocator = properties.getProperty("integralLink.Locator");
		String integralInputLocator = properties.getProperty("integralInput.Locator");
		String integrateLocator = properties.getProperty("integrate.Locator");
		
		String integralInputValue = properties.getProperty("integralInput.Value");
		
		driver.findElement(By.xpath(integralLinkLocator)).click();
		driver.findElement(By.name(integralInputLocator)).sendKeys(integralInputValue);
		driver.findElement(By.xpath(integrateLocator)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test(priority=5)
	public void testDefiniteIntegral() {
		String definiteIntegralLinkLocator = properties.getProperty("quotientLink.Locator");
		String integrateButtonLocator = properties.getProperty("differentiateQuatient.Locator");
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[3]/div[1]/div[3]/table/tbody/tr/td[2]/font/font/a[5]")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[3]/div[1]/div[2]/table/tbody/tr/td[2]/form/center/input[5]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
	}
	

	@AfterClass
	public static void exit() {
		driver.quit();
	}
	
}
