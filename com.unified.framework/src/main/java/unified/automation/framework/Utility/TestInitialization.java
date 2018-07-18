package unified.automation.framework.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author r.moharana
 * This class initalize UI test and config.properties file
 * Browser driver session starts from here
 */
public class TestInitialization extends Utilities{
	
	static WebDriverSingleton driverSession=WebDriverSingleton.getInstanceofWebdriver();
	protected WebDriver driver;
	
	public TestInitialization() {
		this.driver=driverSession.getDriver();		
	}
	
	@BeforeTest
	public void intializeTest() {
		
		initConfig();
		driver.get(config.getProperty("APPLICATIONURL"));		
	}
		
	
	@AfterTest
	public void tearDown(){
		
		//driver.quit();
	}

}
