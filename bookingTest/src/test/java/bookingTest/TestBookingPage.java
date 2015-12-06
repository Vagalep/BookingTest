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
	  String From = "Kyiv";
	  String Till = "Ivano-Frankivsk";
	  String FirstTrain = "115";
	  String SecondTrain = "043";
	  String ThirdTrain = "143";
	  
	  	@BeforeClass
	  	public void startUp() throws Exception {
	    driver = new FirefoxDriver();
	    bp = new BookingPage(driver);
	    
	    driver.manage().window().maximize();
	    driver.get("http://booking.uz.gov.ua/en/");
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	}
	  	
	  	@Test
	  	public void test(){
		bp.enterStationFrom(From);
		bp.enterStationTill(Till);
		bp.enterDate();
		bp.submitButtonSearch();
		bp.verifyTrainsTabelEnabled();
		bp.verifyTrainsCount();
		bp.verifyTrainPresent(FirstTrain);
		bp.verifyFreeSuitePlacesFor115();
		bp.verifyFreeCoupePlacesFor115();
		bp.verifyFreeBerthPlacesFor115();
		bp.verifyTrainPresent(SecondTrain);
		bp.verifyFreeSuitePlacesFor043();
		bp.verifyFreeSuitePlacesFor043();
		bp.verifyFreeSuitePlacesFor043();
		bp.verifyTrainPresent(ThirdTrain);
		bp.verifyFreeSuitePlacesFor143();
		bp.verifyFreeSuitePlacesFor143();
		bp.verifyFreeSuitePlacesFor143();
	  	}
	  	
		@AfterClass
		public void shutDown() {
		driver.quit();
		}
	  	
		
}
