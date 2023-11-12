package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_FindPatients extends BasePage {

	WebDriver driver;
	
	public Page_FindPatients(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver,this);
	}
		
	
}
