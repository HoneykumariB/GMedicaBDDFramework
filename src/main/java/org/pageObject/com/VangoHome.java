package org.pageObject.com;

import org.basePage.com.BasePage;
import org.gerimedica.enums.KeyboardEvents;
import org.gerimedica.enums.WaitStrategy;
import org.openqa.selenium.By;

public class VangoHome extends BasePage{
	
	private By vangoghMuseaumImage = By.xpath("//img[@alt='Van Gogh Museum Logo']");
    private By vangoCookie=By.xpath("//button[@class='cookie-banner-button btn']");
    private By ontdekLink=By.xpath("//a[contains(text(),' Ontdek de collectie')]");
    private By rightArrow=By.xpath("//div[@class='scroll-indicator scroll-indicator-right']/button[2]");
 
    
    
	public VangoHome clicklogoString() {
	    clickOn(vangoghMuseaumImage, WaitStrategy.CLICKABLE);	   
		return this;
	}
	
	public VangoHome clickOntdekLink() {
        clickOn(ontdekLink, WaitStrategy.CLICKABLE);      
        return this;
    }
	
	public VangoHome waitForCookieAccept() {
        clickOn(vangoCookie, WaitStrategy.CLICKABLE);
        return this;
    }
	
	public boolean swipetillLink() {
        return  displayStatus(ontdekLink);
	}
	public VangoHome rightArrow() {
	    clickOn(rightArrow, WaitStrategy.NONE);
        return this;
	}
	
	
	
	
//	public CollectieSearch pressEnter() {
//		useKeyboardKeys(googleTextBox, "Google Search Text Box", KeyboardEvents.ENTER);
//		return new CollectieSearch();
//	}
//	
	
	
	
}
