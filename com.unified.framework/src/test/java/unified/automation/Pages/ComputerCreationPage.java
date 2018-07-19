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
	
	
	public void setComputerName(String _computerName) {
		computerNameTextBox.sendKeys(_computerName);
	}
	
	public void clickAddCoumputerButton() {
		createComputerButton.click();
	}
	
	public String getComputerCreationHeadePageText() {
		return computerCreationPageHeaderText.getText().trim();
	}

	public void setIntroducedDate(String _introduceDate) {
		
		introducedDateField.sendKeys(_introduceDate);
	}
	
	public void setDiscontinuedDate(String _discontinuedDate) {
		
		discontinueddDateField.sendKeys(_discontinuedDate);
	}

	public void setCompanyName(String _companyName) {
		Select selectCompanyName=new Select(companyNameDropDown);
		selectCompanyName.selectByVisibleText(_companyName);
	}
}
