package bookingTest;



import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BookingPage {

	@FindBy (xpath="//input[@name='station_from']")
	private ElementStationPicker station_from;
	
	@FindBy (xpath="//input[@name='station_till']")
	private ElementStationPicker station_till;
	
	@FindBy (name="date")
	private ElementDatePicker date;
	
	@FindBy (name="search")
	private ElementSearchButton search;
	
	@FindBy (xpath="//*[@id='ts_res_tbl']")
	public  ElementTrainsTable trainsTable;
    
    public BookingPage(WebDriver driver) {
	HtmlElementLoader.populatePageObject(this, driver);
    }
    
    public void enterStationFrom(String value) throws InterruptedException {	
    	station_from.enterStringWithSuggestions(value);
    }

    public void enterStationTill(String value) throws InterruptedException{
		station_till.enterStringWithSuggestions(value);
	}
	
	public void enterDate(String value) throws InterruptedException{
		date.enterDateString(value);
	}
	
	public void submitbuttonSearch() {
	     search.clickSearchButton();
	}

	public void verifyTrainsTable() {
		// TODO Auto-generated method stub
		
	}

	public void verifyTrainPresent() {
		// TODO Auto-generated method stub
		
	}

	public void verifyTrainsPresent() {
		// TODO Auto-generated method stub
		
	}
	
}
	
