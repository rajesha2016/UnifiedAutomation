package unified.automation.Pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author r.moharana
 *
 */
public class ComputerHomePage {
	
	
	@FindBy(xpath="//input[@id='searchbox']")
	WebElement searchFieldTextBox;
	
	@FindBy(xpath="//input[@id='searchsubmit']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@id='add']")
	WebElement addNewComputerButton;
	
	@FindBy(xpath="//table[@class='computers zebra-striped']")
	WebElement computerTable;
	
	@FindBy(xpath="//tbody/tr")
	WebElement tableRows;
	
	@FindBy(xpath="//div[@class='alert-message warning']")
	WebElement successMessageText;
	
	
	public void setComputerNameToSearch(String _computerToSearch) {
		searchFieldTextBox.sendKeys(_computerToSearch);
	}
	
	
	public void clickSearchButton() {
		searchButton.click();
	}
	public void clickAddNewCoumputerButton() {
		addNewComputerButton.click();
	}
	
	public String getMessageText() {
		return successMessageText.getText().trim();
	}
	
		
	public String getTableWebElement() {
		return "//tbody/tr";
	}

	public String generateRandomNumber() {
		Random generator= new Random();
		int number=generator.nextInt(1000);
		return String.valueOf(number);
	}
	
	public boolean isSuccessMessageDisplayed() {
		return successMessageText.isDisplayed();
	}
}
