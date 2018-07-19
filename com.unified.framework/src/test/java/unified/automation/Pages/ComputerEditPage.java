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
	
	
	public void setUpdatedComputerName(String _updatedComputerName) {
		computerNameTextBox.clear();
		computerNameTextBox.sendKeys(_updatedComputerName+"_modified");
	}
	
	public void setUpdatedIntroducedDate(String _updatedIntroducedDate) {
		
		introducedDateField.clear();
		introducedDateField.sendKeys(_updatedIntroducedDate);
	}

	public void setUpdatedDiscontinuedDate(String _updatedDiscontinuedDate) {
	
		discontinueddDateField.clear();
		discontinueddDateField.sendKeys(_updatedDiscontinuedDate);
	}
	
	public void setUpdatedCompanyName(String _updatedCompanyName) {
		
		Select selectCompanyName=new Select(companyNameDropDown);
		selectCompanyName.selectByVisibleText(_updatedCompanyName);
	}
	
	public String getEditComputerHeaderText() {
		
		return editComputerHeaderText.getText().trim();
	}
	
	
	public void clickEditSaveButton() {
		saveUpdatedComputerButton.click();
	}

	
	public boolean isDeleteButtonDisplayed() {
		
		return deleteButton.isDisplayed();
	}
	
	public void clickDeleteButton() {
		deleteButton.click();
	}
}

