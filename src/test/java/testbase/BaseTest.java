package testbase;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;

//import pages.Page_Home;
public class BaseTest {
	
	/*
	 * This class will hold all the reusable methods
	 */

	public WebDriver driver;
	
	public Logger logs;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		
		logs = LogManager.getLogger(this);
		rb = ResourceBundle.getBundle("config"); // Load the config file
		
		if(browser.equals("chrome")) {
			logs.info("*** Launching chrome browser ***");
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			
		}else if(browser.equals("firefox")) {
			logs.info("*** Launching firefox browser ***");
			driver = new FirefoxDriver();
			
		}else if(browser.equals("edge")) {
			logs.info("*** Launching edge browser ***");
			driver = new EdgeDriver();
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().deleteAllCookies();
		//driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.get(rb.getString("baseURL"));	// Call the key from config.properties file
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public String captureScreenShots(String testName) throws IOException {
		
		//Generate time stamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date());  
		// Type casting webdriver variable
		TakesScreenshot takess = (TakesScreenshot)driver; 	
		
		// Generate output file
		File source = takess.getScreenshotAs(OutputType.FILE);

		// Screenshot path
		String screenshotpath = System.getProperty("user.dir");
		
		// Set file path
		File destination = new File(screenshotpath + testName+ "-"+ timeStamp + ".png");
				// System.getProperty("user.dir")+"/screenshots/" + testName+ "-"+ timeStamp + ".png";
		
		try {
			FileUtils.copyFile(source,destination);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return destination.toString();
	}
	
//	@AfterTest
//	void logOut() {
//		Page_Home ph = new Page_Home(driver);
//		ph.clickLogoutLink();
//	}
}
