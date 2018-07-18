package unified.automation.framework.Utility;

import org.testng.annotations.DataProvider;

/**
 * @author r.moharana
 * This class provides parameterization to Automated tests
 */
public class TestDataProviderClass {
	
	
	/**
	 * this method to provide test data for Automated UI test
	 * @return two dimensional Object array.
	 * Rows- Number of times test has to repeated.
	 * Columns - Number of parameters in test data. 
	 */
	@DataProvider(name="AddComputer")
    public static Object[][] getTestDataforComputerCreation(){
		
        return new Object[][] {
        	
            { "r.moharanacomputer003"}
            
        };  
	}
	
	
	
	/**
	 * this method to provide test data for Automated API test
	 * @return two dimensional Object array.
	 * Rows- Number of times test has to repeated.
	 * Columns - Number of parameters in test data.
	 */
	@DataProvider(name="SearchComputer")
    public static Object[][] getTestDataforAPI(){
		
        return new Object[][] {
        	
            { "r.moharanacomputer003"}
            
        };  
	}
    
}
