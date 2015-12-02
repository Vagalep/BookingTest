package bookingTest;

import static org.testng.Assert.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BookingPage {
	
	@FindBy (xpath="//*[@id='station_from']")
	private ElementStationPicker station_from;
	
	@FindBy (xpath="//*[@id='station_till']")
	private ElementStationPicker station_till;
	
	@FindBy (xpath="//*[@id='date_dep']")
	private WebElement dateField;
	
	@FindBy (xpath="//*[@class='rui-re-anchor']")
	private ElementDatePicker date;
	
	@FindBy (xpath="(//*[@class='rui-re-anchor']//td[@class!='blank' and @class!='disabled'])[3]")
	private ElementDatePicker fashionPicker;
	
	@FindBy (xpath="//*[@name='search']")
	private ElementSearchButton search;
	
	@FindBy (xpath="//*[@id='ts_res_tbl']")
	public  ElementTrainsTable trainsTable;
	
    public BookingPage(WebDriver driver) {
	HtmlElementLoader.populatePageObject(this, driver);
    }
    
    public void enterStationFrom(String value){	
    	station_from.enterStationFromList(value);
    }	

    public void enterStationTill(String value){
    	station_till.enterStationFromList(value);
    }
	
    public void enterDate(){
    	dateField.click();
    	dateField.sendKeys(Keys.ARROW_RIGHT);
    	dateField.sendKeys(Keys.ARROW_RIGHT);
    	dateField.sendKeys(Keys.ENTER);
//    	fashionPicker.click();
//    	date.chooseDateFromList();
	}
	
	public void submitButtonSearch() {
	     search.clickSearchButton();
	}
	
	public int tabTrainsCount() {
		return trainsTable.trainsCount();
	}
	
	public void verifyTrainsCount() {
		assertNotEquals(tabTrainsCount(), 0,"Could not find any train");
	}

	public void verifyTrainPresent(String value) {
		assertTrue(trainsTable.trainNumber(value),"Train with specified number is absent");
	}
}
	
	
