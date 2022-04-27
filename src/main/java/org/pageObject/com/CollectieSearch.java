package org.pageObject.com;

import org.basePage.com.BasePage;
import org.gerimedica.enums.WaitStrategy;
import org.openqa.selenium.By;

public class CollectieSearch extends BasePage{

	private By results = By.xpath("//span[@class='results']");
	private By searchField = By.className("search-field-input");
	private By searchIcon = By.xpath("(//button[@aria-label='Zoeken'])[2]");
	   private By collectieHeading=By.xpath("//h1");
	   private By firstImage=By.xpath("(//img)[2]");
	
	public CollectieSearch waitForGoogleSearchResultPageLoad() {
		waitForPageLoad();
		return this;
	}
	
	public CollectieSearch enterSearchField(String value) {
	    type(searchField,value,WaitStrategy.VISIBLE);
        return this;
    }
	
	public CollectieSearch clickOnSearchIcon() {
        clickOn(searchIcon, WaitStrategy.CLICKABLE);      
        return this;
    }
	
	
	public String getSearchResultText() {
		return getElementText(results, WaitStrategy.PRESENCE);
	}
	
	
	public String getPageheading() {
        return getElementText(collectieHeading, WaitStrategy.NONE);
    }
	
	public CollectieSearch selectFirstImage() {
	    clickOn(firstImage, WaitStrategy.CLICKABLE);      
        return this;
    }
	
	
}
