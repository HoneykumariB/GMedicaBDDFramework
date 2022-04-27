package StepDefination;





import org.basePage.com.BasePage;
import org.gerimedica.report.Logger;
import org.gerimedicaDriver.com.BaseTest;
import org.pageObject.com.CollectieSearch;
import org.pageObject.com.VangoHome;
import org.pageObject.com.paintingPage;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef extends BaseTest {
    BaseTest base=new BaseTest();
    VangoHome vangoSearch=new VangoHome();
    CollectieSearch  collecSearch = new CollectieSearch();
    paintingPage paintPage=new paintingPage();

    
    @Before
    public void init() throws Exception {
        base.openBrowser();
    }
    
    
    
    @Given("Navigated to vangoghmuseum collectie page")
    public void navigated_to_vangoghmuseum_collectie_page() {
        vangoSearch.clicklogoString()
        .waitForCookieAccept();
    while(vangoSearch.swipetillLink()!=true) {
            vangoSearch.rightArrow();
     }
       vangoSearch.clickOntdekLink();
    }
    
    @When("User searched painting with {string} title")
    public void user_searched_painting_with_title(String TitleValue) {
        collecSearch.enterSearchField(TitleValue).clickOnSearchIcon();
        Logger.info("Searched with title "+TitleValue);
    }
    
    @Then("Search result are greater than {int}")
    public void search_Result_are_greater(int searchCount) {
        String ResultCount =collecSearch.getSearchResultText();
        int count= Integer.parseInt(ResultCount);
         Logger.info("Total Result count ="+count);
         Assert.assertTrue(count>700);
         Logger.info("Validated Count is Greater than 700");
    }
    
    
    @When("User selected first paiting")
    public void user_selected_first_paiting() {
        paintPage.sleep(3000);
        collecSearch.selectFirstImage();
        Logger.info("Selected First Image");
        
    }
    @Then("User verified the painting page")
    public void user_verified_the_painting_page() {
        paintPage.sleep(3000); 
        boolean urlContain=paintPage.pageCurrentURL().contains("collectie/s0032V1962");
        Assert.assertTrue(urlContain);
        Assert.assertTrue(paintPage.getPaintingPageSection());
        Logger.info("Painting section is displayed");
         paintPage.clickMoreInfoArrow();
        Assert.assertEquals(paintPage.getPaintingPageheading(), "Het Gele Huis (De straat)");
        Logger.info("Painting Heading  is matched");    
        while(paintPage.zoekDisplayStatus()!=true) {     
            paintPage.scrollObjectGegeven();
        }
        paintPage.sleep(3000);
        paintPage.clickObjectGegeven();
        Logger.info("ObjectGegeven is expanded");      
                
    }
    



    @Given("Navigated to vangoghmuseum HomePage")
    public void navigated_to_vangoghmuseum_home_page() {
        vangoSearch.clicklogoString()
        .waitForCookieAccept();
        Logger.info("Home Page launched");          
    }
    
    
    @When("User swipe right to {string}")
    public void user_swipe_right_to(String ontdekLink) {
        while(vangoSearch.swipetillLink()!=true) {
            vangoSearch.rightArrow();
            Logger.info("Swiped to "+ontdekLink);       
        }
    }
    
    @When("clicked Ontdek de collectie link")
    public void clicked_link() {
        vangoSearch.clickOntdekLink();
        Logger.info("Selected Collectie Link");   
    }
    
    @Then("User validated the page heading as {string}")
    public void user_validated_the_page_heading_as(String heading) {
        paintPage.sleep(3000);
        String collectieHeading=collecSearch.getPageheading();
        Assert.assertEquals(collectieHeading, heading);
        Logger.info("Heading is verified");  
    }
    
    @Then("User validated URL contains {string}")
    public void user_validated_url_contains(String collectieURlValue) {
        
        boolean urlContain=collecSearch.pageCurrentURL().contains(collectieURlValue);  
        Assert.assertTrue(urlContain);
        Logger.info("URL is verified");       
    }
    
    @Then("User validated the page title {string}")
    public void user_validated_the_page_title(String collectieTitle) {
        Assert.assertEquals(collecSearch.getPageTitle(), collectieTitle);
        Logger.info("Page Title is verified");  
    }
    
    
    @Then("validated F Number {string} value")
    public void validated_f_number_value(String FNum) {
        
          Assert.assertEquals(paintPage.getFNumber(), FNum);
          Logger.info("Verified correct F Number");
         
    }
    
    @Then("validated JH Number {string} value")
    public void validated_jh_number_value(String JHNumb) {
        paintPage.scrollWindow();
        Assert.assertEquals(paintPage.getJHNumber(), JHNumb);
        Logger.info("Verified correct JH Number");
    }
    @Then("validated Inventoris {string} value")
    public void validated_inventoris_value(String inventoryNum) {
        Assert.assertEquals(paintPage.getInventoryNumber(), inventoryNum);
        Logger.info("Verified correct Inventris Number");
        paintPage.scrollWindow();

    }
    
    @After
    public void teardown() throws Exception {
        base.quitBrowser();
    }
    

}
