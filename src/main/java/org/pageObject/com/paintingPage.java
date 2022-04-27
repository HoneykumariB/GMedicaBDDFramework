package org.pageObject.com;

import org.basePage.com.BasePage;
import org.gerimedica.enums.WaitStrategy;
import org.gerimedicaDriver.com.DriverManager;
import org.openqa.selenium.By;

public class paintingPage extends BasePage {
    private By paintingPage = By.xpath("//section[@class='art-object-page']");
    private By moreInformationArrow=By.xpath("//span[text()='Meer informatie']");
    private By paintingHeading=By.xpath("//h1");
    //De aardappeleters
    private By objectGegevenButton=By.xpath("//button[text()='Objectgegevens']");
    private By ZoekStatusButton=By.xpath("//h3[text()='Zoek in de collectie']");
    private By fNumberText=By.xpath("//dt[text()='F-nummer']//parent::div/dd");
    private By jhNumberText=By.xpath("//dt[text()='JH-nummer']//parent::div/dd");
    private By inventoryNumberText=By.xpath("//dt[text()='Inventarisnummer']//parent::div/dd");
     
    public paintingPage waitForGoogleSearchResultPageLoad() {
        waitForPageLoad();
        return this;
    }
    
    public boolean getPaintingPageSection() {
        return displayStatus(paintingPage);
    }
    
    public String getPaintingPageheading() {
        return getElementText(paintingHeading, WaitStrategy.NONE);
    }
    
    public paintingPage clickMoreInfoArrow() {
        clickOn(moreInformationArrow, WaitStrategy.CLICKABLE);      
        return this;
    }
    
    public paintingPage clickObjectGegeven() {
        clickOn(objectGegevenButton, WaitStrategy.CLICKABLE);      
        return this;
    }
    
    public paintingPage scrollObjectGegeven() {
        scrollTOElement(DriverManager.getDriver().findElement(ZoekStatusButton));      
        return this;
    }
    
    public boolean zoekDisplayStatus() {
        return  displayStatus(ZoekStatusButton);
    }
    
    public String getFNumber() {
        return getElementText(fNumberText, WaitStrategy.NONE);
    }
    
    public String getJHNumber() {
        return getElementText(jhNumberText, WaitStrategy.NONE);
    }
    public String getInventoryNumber() {
        return getElementText(inventoryNumberText, WaitStrategy.NONE);
    }
    
    
}
