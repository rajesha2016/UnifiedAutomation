package unified.automation.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import unified.automation.Pages.ComputerCreationPage;
import unified.automation.Pages.ComputerHomePage;
import unified.automation.framework.Utility.TestDataProviderClass;
import unified.automation.framework.Utility.TestInitialization;

/**
 * @author r.moharana
 *
 */
public class ComputerApplicationTest extends TestInitialization{
	
	String computerName=null;
	
	@Test(priority=1,dataProvider="AddComputer", dataProviderClass=TestDataProviderClass.class)
	public void addNewComputer(String newComputerName) {
		
		try {
			
			ComputerHomePage computerHomePage=PageFactory.initElements(driver, ComputerHomePage.class);
			ComputerCreationPage computerCreationPage=PageFactory.initElements(driver, ComputerCreationPage.class);
			
			computerHomePage.clickAddNewCoumputerButton();
			
			computerCreationPage.setComputerName(newComputerName+computerHomePage.generateRandomNumber());
			
			computerName=newComputerName+computerHomePage.generateRandomNumber();
			
			computerCreationPage.clickAddCoumputerButton();
			
			Assert.assertTrue(computerHomePage.getMessageText().contains(newComputerName));
			
			System.out.println("inside test 1");
						
			
			
		}catch(Exception e) {
			
			System.out.println("Exception "+e+" occured during execution");			
		}
		
	}
	
	@Test(priority=2,dataProvider="SearchComputer",dataProviderClass=TestDataProviderClass.class)
	public void editComputer() {
		
		try {
			
			System.out.println("inside test 2");
			ComputerHomePage computerHomePage=PageFactory.initElements(driver, ComputerHomePage.class);
			
			computerHomePage.setComputerNameToSearch(computerName);
			
			computerHomePage.clickSearchButton();
			
			List<WebElement> table_rows=driver.findElements(By.xpath(computerHomePage.getTableWebElement()));
			String str=computerHomePage.getTableWebElement();
			if(table_rows.size()==1) {
				
				str=str+"[1]/td/a";
			}
			
			driver.findElement(By.xpath(str)).click();
			
						
			
		}catch(Exception e) {
			
			System.out.println("Exception "+e+" occured during execution");	
		}
	}
	

}
