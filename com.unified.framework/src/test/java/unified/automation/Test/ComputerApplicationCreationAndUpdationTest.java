package unified.automation.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import unified.automation.Pages.ComputerCreationPage;
import unified.automation.Pages.ComputerEditPage;
import unified.automation.Pages.ComputerHomePage;
import unified.automation.framework.Utility.TestDataProviderClass;
import unified.automation.framework.Utility.TestInitialization;

/**
 * @author r.moharana
 *
 */
public class ComputerApplicationCreationAndUpdationTest extends TestInitialization{
	
	private String computerName=null;
	
	/**
	 * @param newComputerName
	 * @param introducedDate
	 * @param discontinuedDate
	 * @param companyName
	 * @param expectedComputerCreationHeaderText
	 * @param expectedComputerEditHeaderText
	 */
	@Test(dataProvider="TestDataForComputerCreateAndUpdateOperation", dataProviderClass=TestDataProviderClass.class)
	public void addNewAndUpdateComputer(String newComputerName,String introducedDate,String discontinuedDate,
			String companyName,String expectedComputerCreationHeaderText,String expectedComputerEditHeaderText) {
		
		try {
			
			ComputerHomePage computerHomePage=PageFactory.initElements(driver, ComputerHomePage.class);
			ComputerCreationPage computerCreationPage=PageFactory.initElements(driver, ComputerCreationPage.class);
			ComputerEditPage computerEditPage=PageFactory.initElements(driver, ComputerEditPage.class);
			
			computerHomePage.clickAddNewCoumputerButton();
			
			verifyMessageText(computerCreationPage.getComputerCreationHeadePageText(), expectedComputerCreationHeaderText);
			
						
			computerName=newComputerName+getRandomNumber();
			
			
			computerCreationPage.setComputerName(computerName);
			
			computerCreationPage.setIntroducedDate(introducedDate);
			
			computerCreationPage.setDiscontinuedDate(discontinuedDate);
			
			computerCreationPage.setCompanyName(companyName);
			
			computerCreationPage.clickAddCoumputerButton();
			
			verifyMessageText(computerHomePage.getMessageText(),computerName);
			
			computerHomePage.setComputerNameToSearch(computerName);
			
			computerHomePage.clickSearchButton();
			
			clickTableRow(computerHomePage.getTableWebElement());
						
			verifyMessageText(computerEditPage.getEditComputerHeaderText(), expectedComputerEditHeaderText);
			
			computerEditPage.clearComputerNameTextField();
			computerEditPage.setUpdatedComputerName(computerName);
			computerEditPage.clearIntroducedDateField();
			computerEditPage.setUpdatedIntroducedDate(introducedDate);
			computerEditPage.clearDiscontinuedDateField();
			computerEditPage.setUpdatedDiscontinuedDate(discontinuedDate);
			computerEditPage.setUpdatedCompanyName(companyName);
			computerEditPage.clickSaveButton();
			
			verifyMessageText(computerHomePage.getMessageText(), computerName);
			
			System.out.println("*********** updation successful **************");
		
						
		}catch(Exception e) {
		
			System.out.println("Exception "+e+" occured during execution");			
		}
	
		
	}
	
	private void clickTableRow(String element) {
		List<WebElement> table_rows=driver.findElements(By.xpath(element));
		if(table_rows.size()>=1) {
			
			element=element+"[1]/td/a";
			driver.findElement(By.xpath(element)).click();
		}
	}
}
