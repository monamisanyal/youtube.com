package youtube.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import youtube.com.base.baseClass;
import youtube.com.pageobject.Homepage;
import youtube.com.pageobject.addpassword;
import youtube.com.pageobject.googleloginpage;
import youtube.com.pageobject.searchResultPage;
import youtube.com.utility.log;

public class testlogin extends baseClass {
	Homepage hp;
	googleloginpage glp;
	addpassword ap;
	
	
	@BeforeMethod
	public void setup() {
		launchApp();
		}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void testloggeduser() {
		log.startTestCase("testloggeduser");
		hp= new Homepage();
		log.logInfo("clicked signin button");
		glp=hp.signinyoutube();
		ap=glp.addemail();
		hp=ap.password();
		String act =hp.checkloggeduser();
		String exp = "monamisanyal2@gmail.com";
		Assert.assertEquals(act, exp);
		log.endTestCase("testloggeduser");
	}
}
