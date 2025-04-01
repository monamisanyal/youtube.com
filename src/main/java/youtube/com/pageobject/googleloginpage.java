package youtube.com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import youtube.com.actiondriver.Action;
import youtube.com.base.baseClass;

public class googleloginpage extends baseClass {
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement Email_signin;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement nextbutton;
	
	public googleloginpage() {
		PageFactory.initElements(driver, this);
			}
	
	public addpassword addemail() {
		Action.enterText(Email_signin, "monamisanyal2@gmail.com");
		Action.waitForElementClickable(driver, By.xpath("//span[normalize-space()='Next']"));
		Action.click(nextbutton);
		return new addpassword();
		
	}
	
	

}
