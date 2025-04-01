package youtube.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import youtube.com.base.baseClass;
import youtube.com.pageobject.Homepage;
import youtube.com.pageobject.searchResultPage;
import youtube.com.utility.log;

public class searchresultofautomation extends baseClass {
	Homepage hp;
	searchResultPage sp;
	
	
	
	@BeforeMethod
	public void setup() {
		launchApp();
		}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void firstresultvideotitle() {
		log.startTestCase("searchresultautonmation");
		hp= new Homepage();
		log.logInfo("User is searching");
		sp= hp.Searchin();
		String actresult=sp.addFilter();
		Assert.assertNotEquals(actresult,"Video title not found");
		log.endTestCase("searchresultautonmation");
		
	}
	

}
