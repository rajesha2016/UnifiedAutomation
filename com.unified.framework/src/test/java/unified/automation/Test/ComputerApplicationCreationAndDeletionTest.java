package unified.automation.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import unified.automation.Pages.ComputerCreationPage;
import unified.automation.Pages.ComputerEditPage;
import unified.automation.Pages.ComputerHomePage;
import unified.automation.framework.Utility.TestDataProviderClass;
import unified.automation.framework.Utility.TestInitialization;

/**
 * @author r.moharana
 * Page Object Model- UI test class to create and update computer
 * It takes test data from TestDataProviderClass.java class
 * Access all page classes methods
 */
public class ComputerApplicationCreationAndDeletionTest extends TestInitialization{
	
	String computerName=null;
	
	/**
	 *  This method is to create a new Computer and delete the same computer.
	 * @param newComputerName name of the computer to be created
	 * @param introducedDate
	 * @param discontinuedDate
	 * @param companyName
	 * @param expectedComputerCreationHeaderText
	 * @param expectedSuccessDeletionMessageText
	 */
	@Test(dataProvider="TestDataForComputerCreateAndDeletionOperation", dataProviderClass=TestDataProviderClass.class)
	public void addNewAndDeleteComputer(String newComputerName,String introducedDate,String discontinuedDate,
			String companyName,String expectedComputerCreationHeaderText,String expectedSuccessDeletionMessageText) {
		
		try {
			
			//this initElements methods will create all WebElements for the respective pages
			ComputerHomePage computerHomePage=PageFactory.initElements(driver, ComputerHomePage.class);
			ComputerCreationPage computerCreationPage=PageFactory.initElements(driver, ComputerCreationPage.class);
			ComputerEditPage computerEditPage=PageFactory.initElements(driver, ComputerEditPage.class);
			
			//click on Add button to add new computer to application
			computerHomePage.clickAddNewCoumputerButton();
			
			//verify the application is on New computer creation page
			verifyMessageText(computerCreationPage.getComputerCreationHeadePageText(), expectedComputerCreationHeaderText);
			
			//set computer name with random generated value
			computerName=newComputerName+getRandomNumber();
			
			//Enter new computer name
			computerCreationPage.setComputerName(computerName);
			
			//Enter introduced date
			computerCreationPage.setIntroducedDate(introducedDate);
			
			//Enter discontinued date
			computerCreationPage.setDiscontinuedDate(discontinuedDate);
			
			//select company name from drop down
			computerCreationPage.setCompanyName(companyName);
			
			//Click on Create button to create computer
			computerCreationPage.clickAddCoumputerButton();
			
			//Verify computer creation successful message 
			verifyMessageText(computerHomePage.getMessageText(),computerName);
			
			//Enter the above created computer name in the home page search box to delete
			computerHomePage.setComputerNameToSearch(computerName);
			
			//Get search result for the provided computer name
			computerHomePage.clickSearchButton();
			
			//this to find the created computer from Table
			clickTableRow(computerHomePage.getTableWebElement());
			
			//verify delete button on the web page
			isWebElementDisplayed(computerEditPage.isDeleteButtonDisplayed());
			
			//click delete button to delete the selected computer
			computerEditPage.clickDeleteButton();
			
			//verify deleted computer message
			verifyMessageText(computerHomePage.getMessageText(),expectedSuccessDeletionMessageText);
			
			System.out.println("*********** creation and Deletion successful **************");
		
						
		}catch(Exception e) {
		
			System.out.println("Exception "+e+" occured during execution");			
		}
	
		
	
	}
	
	/**
	 *  This method to identify element from web table
	 * @param element
	 */
	private void clickTableRow(String element) {
		List<WebElement> table_rows=driver.findElements(By.xpath(element));
		if(table_rows.size()>=1) {
			
			element=element+"[1]/td/a";
			driver.findElement(By.xpath(element)).click();
		}
	}
}
