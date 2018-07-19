package unified.automation.framework.Utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;


/**
 * @author r.moharana
 * This class hold all generic methods like initialization of properties file to help tests
 */
public class Utilities {
	
public static Properties config=null;
	
	// method to initialize properties file
	public static void initConfig() {

		// Initialize the Properties class
		config = new Properties();

		// read properties file
		try {
			
			//for Mac machine please change ' System.getProperty("user.dir")+ "//config.properties" ' replace '\\' with '/'
			FileInputStream readConfig = new FileInputStream(System.getProperty("user.dir")+ "\\config.properties");

			// load properties file
			config.load(readConfig);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	protected boolean verifyMessageText(String actualText,String expectedText) {		
		if(actualText.contains(expectedText.trim()))
			return true;
		
		return false;
	}
	
	protected String getRandomNumber() {
		Random generator= new Random();
		int number=generator.nextInt(2000);
		return String.valueOf(number);
	}
	
	protected boolean isWebElementDisplayed(boolean condition) {
		
		if(condition)
			return true;
		
		return false;
	}

}
