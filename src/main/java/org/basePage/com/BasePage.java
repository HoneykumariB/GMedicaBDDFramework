package org.basePage.com;

import org.gerimedica.enums.KeyboardEvents;
import org.gerimedica.enums.WaitStrategy;
import org.gerimedica.factories.ExplicitWaitFactory;
import org.gerimedica.report.Logger;
import org.gerimedicaDriver.com.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {   //common methods

	protected void type(By locator, String value, WaitStrategy waitstrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, locator);
		element.sendKeys(value);
		Logger.info("'" + value + "' is type in '" + value + "'");
	}
	
	protected void clickOn(By locator, WaitStrategy waitstrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, locator);
		element.click();
		Logger.info("Click on '" + locator + "'");
		
	}
	
	protected void containsTextInAttribute(By locator, String attribute, String value) {
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.attributeContains(locator, attribute, value));
	}
	
	 
	protected void waitForPageLoad() {
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(d -> ((JavascriptExecutor)DriverManager.getDriver()).executeScript("return document.readyState").equals("complete"));
	}
	
	public void scrollWindow() {
	    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
	    js.executeScript("window.scrollBy(0,200)");
    }
	
	public void scrollTOElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }
	   
	
	public String pageCurrentURL() {
		return DriverManager.getDriver().getCurrentUrl();
	}
	
	protected WebElement  element(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }
	
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void useKeyboardKeys(By locator, String elementName, KeyboardEvents keyboardEvents) {
		WebElement element = DriverManager.getDriver().findElement(locator);
		
		if(keyboardEvents == KeyboardEvents.ENTER) {
			element.sendKeys(Keys.ENTER);
			Logger.info("Press ENTER on '" + elementName + "'");
		}
		else if(keyboardEvents == KeyboardEvents.TAB) {
			element.sendKeys(Keys.TAB);
			Logger.info("Press TAB on '" + elementName + "'");
		}
		else if(keyboardEvents == KeyboardEvents.ESC) {
			element.sendKeys(Keys.ESCAPE);
			Logger.info("Press ESCAPE on '" + elementName + "'");
		}
	}
	
	protected boolean displayStatus(By locator)
	{   try {
	    boolean status= element(locator).isDisplayed();
        Logger.info("Element displayed Status: '" + status + "'");
        return true;
	}
	catch(NoSuchElementException noEx) {
	    return false; 
	}
       
	}
	
	protected String getElementText(By locator, WaitStrategy waitstrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, locator);
		Logger.info("Element text is => " + element.getText());
		return element.getText();
	}
	
	public void sleep(int time) {
	    try {
            Thread.sleep(time);
            Logger.info("Sleep time  "+time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

    }
	

