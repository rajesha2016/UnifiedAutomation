package unified.automation.framework.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author r.moharana
 * This class initialize WebDriver and config.properties file
 * 
 */
public class TestInitialization extends Utilities{
	
	
	protected WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeTest
	
	public void intializeTest(String browser) {
		
		initConfig();
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(config.getProperty("APPLICATIONURL"));		
	}
		
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
	}

}
