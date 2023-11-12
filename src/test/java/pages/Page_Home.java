package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page_Home extends BasePage {
	
	WebDriver driver;
	
	public Page_Home(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logutLink;
	
	
	public void clickLogoutLink() {
		logutLink.click();
	}

}
