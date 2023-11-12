package tests;

import pages.Page_Home;
import testbase.BaseTest;
import org.testng.annotations.*;

public class TC_003_SearchPatients extends BaseTest{

	public Page_Home ph;
	
	
	@Test
	void testPatientSearchBasic() {
		ph = new Page_Home(driver);
		logs.info("****** Starting test : Patient Search *******");
		ph.clickFindPatient();
	}
}
