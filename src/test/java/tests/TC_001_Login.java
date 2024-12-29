package tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import pages.*;
import testbase.BaseTest;

public class TC_001_Login extends BaseTest{
	Page_Login pl;
	
	@Test
	void testLoginWithValidCredentials() {
		logs.info("*** Starting Login Test Execution ***");
		pl = new Page_Login(driver);
		
		String windowTitleAfterLogin = "Home";
		
		try {
			logs.info("Entering credentials");
			pl.enterUserName(rb.getString("userName"));
			pl.enterPassword(rb.getString("password"));
			
			logs.info("Selecting session location");
			pl.selectSessionLocation();
			
			logs.info("Clicking login button");
			pl.clickLoginButton();
			
			logs.info("Validating window title after successful login");
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, windowTitleAfterLogin);	
		}catch(Exception ex) {
			Assert.fail();
		}
		logs.info("*** Login Test Execution Finished ***");
	}
	
	
	@Test()
	void  testLoginWithInvalidCredentials() {
		logs.info("*** Login Test Execution Finished ***");
		pl = new Page_Login(driver);
		String errorMsg = "Invalid username/password. Please try again.";
		try {
			pl.enterUserName("Admin");
			pl.enterPassword("Admin@123");
			pl.selectSessionLocation();
			pl.clickLoginButton();
			Assert.assertEquals(pl.errorMessage(), errorMsg);
		}catch(Exception ex) {
			Assert.fail();
		}
		logs.info("*** Login Test Execution Finished ***");
	}
	
	
	
}
