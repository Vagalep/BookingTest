package bookingTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BookingPage {

	@FindBy (xpath="//input[@name='station_from']")
	private WebElement station_from;
	
	@FindBy (xpath="//input[@name='station_till']")
	private WebElement station_till;
	
	@FindBy (name="date_dep")
	private WebElement date_dep;
	
	@FindBy (name="search")
	private WebElement search;
	
	@FindBy (xpath="//*[@id='ts_res_tbl']")
	public  WebElement trainsTable;
    
    public BookingPage(WebDriver driver) {
	HtmlElementLoader.populatePageObject(this, driver);
    }
    
    public void enterStationFrom(String value) throws InterruptedException {	
		station_from.sendKeys(value);
		station_from.findElement(By.xpath(".//*[@id='stations_from']/div[1]")).click();
	}
    
    public void enterStationTill(String value) throws InterruptedException{
    	station_till.sendKeys(value);
    	station_till.findElement(By.xpath(".//*[@id='stations_till']/div[1]")).click();
	}
    
	public void enterDate(String value) {
		date_dep.clear();
		date_dep.sendKeys(value);
	}
	
	public void submitbuttonSearch() {
	     search.click();
	}
	
	public void trainsTable() {
		
		
	}
	
	public boolean isTableEnabled() {
		return trainsTable.findElement(By.xpath("//*[@id='ts_res_tbl']")).isEnabled();
	}


}
	
