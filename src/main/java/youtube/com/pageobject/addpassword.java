package youtube.com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import youtube.com.actiondriver.Action;
import youtube.com.base.baseClass;

public class addpassword extends baseClass{
	
	@FindBy(xpath="//input[@name='Passwd']")
	WebElement pword;
	
	@FindBy(xpath="//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']//div[@class='VfPpkd-RLmnJb']")
WebElement nextbuton;
	
	public addpassword() {
		PageFactory.initElements(driver, this);
			}
	
	public Homepage password() {
		Action.waitForElementVisible(driver, By.xpath("//input[@name='Passwd']"));
		Action.enterText(pword, "Mimiboby@4");
		Action.click(nextbuton);
		return new Homepage();
		
	}

}
