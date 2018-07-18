package unified.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author r.moharana
 *
 */
public class ComputerCreationPage {
	
	@FindBy(xpath="//input[@id='name']")
	WebElement computerNameTextBox;
	
	@FindBy(xpath="//input[@id='introduced']")
	WebElement introducedDateTextBox;
	
	@FindBy(xpath="//input[@id='discontinued']")
	WebElement discontinueddDateTextBox;
	
	@FindBy(xpath="//select[@id='company']")
	WebElement companyNameDropDown;
	
	@FindBy(xpath="//input[contains(@value,'Create this computer')]")
	WebElement createComputerButton;
	
	@FindBy(xpath="//a[@class='btn']")
	WebElement cancelButton;
	
	
	public void setComputerName(String _computerName) {
		computerNameTextBox.sendKeys(_computerName);
	}
	
	public void clickAddCoumputerButton() {
		createComputerButton.click();
	}
	
	

}
