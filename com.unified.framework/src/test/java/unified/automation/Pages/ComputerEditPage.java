package unified.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerEditPage {
	
	@FindBy(xpath="//input[@id='name']")
	WebElement computerNameTextBox;
	
	@FindBy(xpath="//input[@id='introduced']")
	WebElement introducedDateTextBox;
	
	@FindBy(xpath="//input[@id='discontinued']")
	WebElement discontinueddDateTextBox;
	
	@FindBy(xpath="//select[@id='company']")
	WebElement companyNameDropDown;
	
	@FindBy(xpath="//input[contains(@value,'Save this computer')]")
	WebElement saveComputerButton;
	
	@FindBy(xpath="//a[@class='btn']")
	WebElement editCancelButton;
	
	@FindBy(xpath="//input[contains(@value,'Delete this computer')]")
	WebElement deleteButton;

}
