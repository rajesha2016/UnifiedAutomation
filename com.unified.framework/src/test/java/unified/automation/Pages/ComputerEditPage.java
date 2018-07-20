package unified.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author r.moharana
 * Page Object Model- This is Computer Application Edit home page class for UI test
 * WebElements locators and Methods that support UI Test
 */
public class ComputerEditPage {
	
	@FindBy(xpath="//input[@id='name']")
	WebElement computerNameTextBox;
	
	@FindBy(xpath="//input[@id='introduced']")
	WebElement introducedDateField;
	
	@FindBy(xpath="//input[@id='discontinued']")
	WebElement discontinueddDateField;
	
	@FindBy(xpath="//select[@id='company']")
	WebElement companyNameDropDown;
	
	@FindBy(xpath="//input[contains(@value,'Save this computer')]")
	WebElement saveUpdatedComputerButton;
	
	@FindBy(xpath="//a[@class='btn']")
	WebElement editCancelButton;
	
	@FindBy(xpath="//input[contains(@value,'Delete this computer')]")
	WebElement deleteButton;
	
	@FindBy(xpath="//section/h1")
	WebElement editComputerHeaderText;
	
	
	/**
	 * @param _updatedComputerName
	 * updating computer name
	 */
	public void setUpdatedComputerName(String _updatedComputerName) {
		computerNameTextBox.clear();
		computerNameTextBox.sendKeys(_updatedComputerName+"_modified");
	}
	
	/**
	 * @param _updatedIntroducedDate
	 * updating introduced date
	 */
	public void setUpdatedIntroducedDate(String _updatedIntroducedDate) {
		
		introducedDateField.clear();
		introducedDateField.sendKeys(_updatedIntroducedDate);
	}

	/**
	 * @param _updatedDiscontinuedDate
	 * updating discontinued date
	 */
	public void setUpdatedDiscontinuedDate(String _updatedDiscontinuedDate) {
	
		discontinueddDateField.clear();
		discontinueddDateField.sendKeys(_updatedDiscontinuedDate);
	}
	
	/**
	 * @param _updatedCompanyName
	 * updating company name
	 */
	public void setUpdatedCompanyName(String _updatedCompanyName) {
		
		Select selectCompanyName=new Select(companyNameDropDown);
		selectCompanyName.selectByVisibleText(_updatedCompanyName);
	}
	
	/**
	 * @return computer edit page header text
	 */
	public String getEditComputerHeaderText() {
		
		return editComputerHeaderText.getText().trim();
	}
	
	
	/**
	 * submit button for saving modified value
	 */
	public void clickEditSaveButton() {
		saveUpdatedComputerButton.click();
	}

	
	/**
	 * @return true if delete button displayed on the page, else False
	 */
	public boolean isDeleteButtonDisplayed() {
		
		return deleteButton.isDisplayed();
	}
	
	/**
	 * click on Delete button to delete the computer
	 */
	public void clickDeleteButton() {
		deleteButton.click();
	}
}

