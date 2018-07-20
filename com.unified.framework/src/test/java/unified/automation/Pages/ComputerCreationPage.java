package unified.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * @author r.moharana
 * Page Object Model- This is Computer Application Creation page class for UI test
 * WebElements locators and Methods that support UI Test
 */
public class ComputerCreationPage {
	
	@FindBy(xpath="//input[@id='name']")
	WebElement computerNameTextBox;
	
	@FindBy(xpath="//input[@id='introduced']")
	WebElement introducedDateField;
	
	@FindBy(xpath="//input[@id='discontinued']")
	WebElement discontinueddDateField;
	
	@FindBy(xpath="//select[@id='company']")
	WebElement companyNameDropDown;
	
	@FindBy(xpath="//input[contains(@value,'Create this computer')]")
	WebElement createComputerButton;
	
	@FindBy(xpath="//a[@class='btn']")
	WebElement cancelButton;
	
	@FindBy(xpath="//section/h1")
	WebElement computerCreationPageHeaderText;
	
	
	/**
	 * @param _computerName to set computer name in computer creation page
	 */
	public void setComputerName(String _computerName) {
		computerNameTextBox.sendKeys(_computerName);
	}
	
	
	/**
	 * Submit button to create a new computer
	 */
	public void clickAddCoumputerButton() {
		createComputerButton.click();
	}
	
	 
	/**
	 * @return new computer creation page header text
	 */
	public String getComputerCreationHeadePageText() {
		return computerCreationPageHeaderText.getText().trim();
	}

	/**
	 * @param _introduceDate
	 */
	public void setIntroducedDate(String _introduceDate) {
		
		introducedDateField.sendKeys(_introduceDate);
	}
	
	/**
	 * @param _discontinuedDate
	 */
	public void setDiscontinuedDate(String _discontinuedDate) {
		
		discontinueddDateField.sendKeys(_discontinuedDate);
	}

	/**
	 * @param _companyName selection from drop down
	 */
	public void setCompanyName(String _companyName) {
		Select selectCompanyName=new Select(companyNameDropDown);
		selectCompanyName.selectByVisibleText(_companyName);
	}
}
