package youtube.com.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import youtube.com.actiondriver.Action;
import youtube.com.base.baseClass;

public class Homepage extends baseClass {
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@title='Search']//yt-icon//div")
	WebElement searchbutton;
	
	@FindBy(xpath="//ytd-button-renderer[@class='style-scope ytd-masthead']//a[@aria-label='Sign in']//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response']")
	WebElement signin;
	
	@FindBy(xpath="//button[@id='avatar-btn']")
	WebElement avtarbutton;
	
	@FindBy(xpath="//yt-formatted-string[@id='email']")
	WebElement useremail;
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
			}
	
	public searchResultPage Searchin() {
		Action.enterText(searchBox,"automation");
		Action.click(searchbutton);
		return new searchResultPage();
	}
	
	public googleloginpage signinyoutube() {
		Action.click(signin);
		return new googleloginpage();
	}
	
	public String checkloggeduser() {
		Action.click(avtarbutton);
		String actemail=Action.getText(useremail);
		return actemail;
	}

}
