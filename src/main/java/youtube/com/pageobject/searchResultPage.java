package youtube.com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import youtube.com.actiondriver.Action;
import youtube.com.base.baseClass;

public class searchResultPage extends baseClass{
	
	@FindBy(xpath="//button[@aria-label='Search filters']//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response']")
	WebElement SearhFilter;
	
	@FindBy(xpath="//yt-formatted-string[normalize-space()='Today']")
	WebElement updateTypefilter;
	
	@FindBy(xpath="//a[@id='video-title']")
	WebElement videotitle;
	
	public searchResultPage() {
		PageFactory.initElements(driver, this);
			}
	
	
	public String addFilter() {
		Action.waitForElementClickable(driver, By.xpath("//button[@aria-label='Search filters']//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response']"));
		Action.click(SearhFilter);
		Action.waitForElementVisible(driver, By.xpath("//yt-formatted-string[normalize-space()='Today']"));
		Action.click(updateTypefilter);
		if (videotitle != null) {
		    String titleOfVideo = videotitle.getAttribute("title");
		    return titleOfVideo;
		} else {
		    return "Video title not found";
		}

		
	}

}
