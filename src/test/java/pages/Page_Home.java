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
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[1]/i") WebElement searchPatient;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[2]/i") WebElement activeVisits;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[3]/i") WebElement captureVitals;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[4]/i") WebElement registerPatient;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[5]/i") WebElement appointmentSchedule;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[6]/i") WebElement reports;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[7]/i") WebElement dataManagement;
	
	@FindBy(xpath = "//body/div/div[3]/div[3]/div/a[9]/i") WebElement systemAdmin;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logutLink;
	
	
	public void clickLogoutLink() {
		logutLink.click();
	}
	
	public void clickFindPatient() {
		searchPatient.click();
	}

}
