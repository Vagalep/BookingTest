package bookingTest;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BookingPage {

	@FindBy(xpath = "//*[@id='station_from']")
	private ElementStationPicker station_from;

	@FindBy(xpath = "//*[@id='station_till']")
	private ElementStationPicker station_till;

	@FindBy(xpath = "//*[@id='date_dep']")
	private WebElement dateField;

	@FindBy(xpath = "//*[@class='rui-re-anchor']")
	private ElementDatePicker date;

	@FindBy(xpath = "(//*[@class='rui-re-anchor']//td[@class!='blank' and @class!='disabled'])[3]")
	private ElementDatePicker fashionPicker;

	@FindBy(xpath = "//*[@name='search']")
	private ElementSearchButton search;

	@FindBy(xpath = "//*[@id='ts_res_tbl']")
	public ElementTrainsTable trainsTable;

	@FindBy(xpath = "//a[contains(text(), '115')]//parent::td/following-sibling::td/div[@title='Suite / first-class sleeper']")
	WebElement suitePlaces115;

	@FindBy(xpath = "//a[contains(text(), '115')]//parent::td/following-sibling::td/div[@title='Coupe / coach with compartments']")
	WebElement coupePlaces115;
	
	@FindBy(xpath = "//a[contains(text(), '115')]//parent::td/following-sibling::td/div[@title='Berth / third-class sleeper']")
	WebElement berthPlaces115;
	
	@FindBy(xpath = "//a[contains(text(), '043')]//parent::td/following-sibling::td/div[@title='Suite / first-class sleeper']")
	WebElement suitePlaces043;

	@FindBy(xpath = "//a[contains(text(), '043')]//parent::td/following-sibling::td/div[@title='Coupe / coach with compartments']")
	WebElement coupePlaces043;
	
	@FindBy(xpath = "//a[contains(text(), '043')]//parent::td/following-sibling::td/div[@title='Berth / third-class sleeper']")
	WebElement berthPlaces043;
	
	@FindBy(xpath = "//a[contains(text(), '143')]//parent::td/following-sibling::td/div[@title='Suite / first-class sleeper']")
	WebElement suitePlaces143;

	@FindBy(xpath = "//a[contains(text(), '143')]//parent::td/following-sibling::td/div[@title='Coupe / coach with compartments']")
	WebElement coupePlaces143;
	
	@FindBy(xpath = "//a[contains(text(), '143')]//parent::td/following-sibling::td/div[@title='Berth / third-class sleeper']")
	WebElement berthPlaces143;
	
	public BookingPage(WebDriver driver) {
		HtmlElementLoader.populatePageObject(this, driver);
	}
	
	@Step
	public void enterStationFrom(String value) {
		station_from.enterStationFromList(value);
	}
	
	@Step
	public void enterStationTill(String value) {
		station_till.enterStationFromList(value);
	}
	
	@Step
	public void enterDate() {
		dateField.click();
		fashionPicker.click();
	}
	
	@Step
	public void submitButtonSearch() {
		search.clickSearchButton();
	}
	
	@Step
	public int tabTrainsCount() {
		return trainsTable.trainsCount();
	}
	
	@Step
	public void verifyTrainsCount() {
		assertNotEquals(tabTrainsCount(), 0, "Could not find any train");
	}
	
	@Step
	public void verifyTrainPresent(String value) {
		assertTrue(trainsTable.trainNumber(value), "Train with specified number is absent");
	}
	
	@Step
	public void verifyTrainsTabelEnabled() {
		assertEquals(true, trainsTable.isEnabled(), "Could not find Trains table");
	}
	
	@Step
	public void verifyFreeSuitePlacesFor115() {
		assertEquals(true, suitePlaces115.isEnabled(), "Could not any suite place for train with number 115");
	}
	
	@Step
	public void verifyFreeCoupePlacesFor115() {
		assertEquals(true, coupePlaces115.isEnabled(), "Could not any coupe place for train with number 115");
	}
	
	@Step
	public void verifyFreeBerthPlacesFor115() {
		assertEquals(true, berthPlaces115.isEnabled(), "Could not any berth place for train with number 115");
	}
	
	@Step
	public void verifyFreeSuitePlacesFor043() {
		assertEquals(true, suitePlaces043.isEnabled(), "Could not any suite place for train with number 043");
	}
	
	@Step
	public void verifyFreeCoupePlacesFor043() {
		assertEquals(true, coupePlaces043.isEnabled(), "Could not any coupe place for train with number 043");
	}
	
	@Step
	public void verifyFreeBerthPlacesFor043() {
		assertEquals(true, berthPlaces043.isEnabled(), "Could not any berth place for train with number 043");
	}
	
	@Step
	public void verifyFreeSuitePlacesFor143() {
		assertEquals(true, suitePlaces143.isEnabled(), "Could not any suite place for train with number 143");
	}
	
	@Step
	public void verifyFreeCoupePlacesFor143() {
		assertEquals(true, coupePlaces143.isEnabled(), "Could not any coupe place for train with number 143");
	}
	
	@Step
	public void verifyFreeBerthPlacesFor143() {
		assertEquals(true, berthPlaces143.isEnabled(), "Could not any berth place for train with number 143");
	}
}
