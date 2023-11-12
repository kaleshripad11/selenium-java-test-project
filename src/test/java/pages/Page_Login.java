package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Page_Login extends BasePage{
	
	public Page_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	// Locate elements on Login page
	
	@FindBy(css = "input#username[name='username']") WebElement txtUserName;
	
	@FindBy(css = "input#password[name='password']") WebElement txtPassword;
	
	@FindBy(xpath = "//ul[@id='sessionLocation']/li[1]") WebElement sessionLocation;
	
	@FindBy(xpath = "//input[@type='submit']") WebElement btnLogin;
	
	@FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]") WebElement errMessage;
	
	public void enterUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void selectSessionLocation() {
		sessionLocation.click();
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public String errorMessage() {
		return errMessage.getText();
	}
}
