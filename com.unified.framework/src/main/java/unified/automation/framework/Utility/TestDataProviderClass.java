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
	@DataProvider(name="TestDataForComputerCreateAndUpdateOperation")
    public static Object[][] getTestDataforComputerCreateAndUpdate(){
		
        return new Object[][] {
        	
            { "r.moharanacomputer",
            	"1999-06-04",
            	"1999-06-04",
            	"Apple Inc.",
            	"Add a computer",
            	"Edit computer"}
            
        };  
	}
	
	
	/**
	 * @return
	 */
	@DataProvider(name="TestDataForComputerCreateAndDeletionOperation")
    public static Object[][] getTestDataforComputerCreateAndDelete(){
		
        return new Object[][] {
        	
            { "r.moharanacomputer",
            	"1999-06-04",
            	"1999-06-04",
            	"Apple Inc.",
            	"Add a computer",
            	"Computer has been deleted"
            	}
            
        };  
	}
    
}
