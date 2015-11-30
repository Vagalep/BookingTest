package bookingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBookingPage{

	  WebDriver driver;
	  BookingPage bp;
	  
	  	@BeforeClass
	  	public void startUp() throws Exception {
	    driver = new FirefoxDriver();
	    bp = new BookingPage(driver);
	    
	    driver.manage().window().maximize();
	    driver.get("http://booking.uz.gov.ua/ru/");
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	}
	  	
	  	@Test
	  	public void test() throws Exception {
		bp.enterStationFrom("����");
		bp.enterStationTill("�����-���������");
		bp.enterDate("01.12.2015");
		bp.submitbuttonSearch();
		//bp.verifyTrainsTable();
		//bp.verifyTrainPresent();
		//bp.verifyTrainsPresent();
	  	}
	  	
		@AfterClass
		public void shutDown() {
		driver.quit();
		}
	  	
		
}
