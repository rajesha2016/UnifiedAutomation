package unified.automation.framework.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author r.moharana
 * Singleton Design Pattern of Java
 * This class allows to creates only single WebDriver session and return the driver session to calling class
 */
public class WebDriverSingleton {
	
		// instance of singleton class
		private static WebDriverSingleton instanceofWebdriver=null;
		
		// instance of WebDriver
		private WebDriver driver;
		
		// private Constructor
		private WebDriverSingleton() {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
		/**
		 * @return WebDriverSingleton instance
		 */
		public static WebDriverSingleton getInstanceofWebdriver() {
			if(instanceofWebdriver == null) {
				instanceofWebdriver = new WebDriverSingleton();
			}
			
			return instanceofWebdriver;
		}


		/**
		 * @return WebDriver instance
		 */
		public WebDriver getDriver() {
			
			return driver;
		}

}
