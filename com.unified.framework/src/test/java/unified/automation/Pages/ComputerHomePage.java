package unified.automation.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author r.moharana
 * Page Object Model- This is Computer Application Home page class for UI test
 * WebElements locators and Methods that support UI Test
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
	
	
	/**
	 * @param _computerToSearch computer name to search on Home page
	 */
	public void setComputerNameToSearch(String _computerToSearch) {
		searchFieldTextBox.sendKeys(_computerToSearch);
	}
	

	/**
	 * method to click search button
	 */
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
	/**
	 * verify the Add a new computer button is present on the home if present then click it
	 */
	public void clickAddNewCoumputerButton() {
		addNewComputerButton.isDisplayed();
		addNewComputerButton.click();
	}
	
	
	/**
	 * @return creation, deletion, and Edit success message text
	 */
	public String getMessageText() {
		return successMessageText.getText().trim();
	}
	
	/**
	 * @return Web table row xpath
	 */
	public String getTableWebElement() {
		return "//tbody/tr";
	}
	
	
}
