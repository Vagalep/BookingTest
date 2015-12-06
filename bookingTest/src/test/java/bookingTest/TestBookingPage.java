package bookingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Stories;

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
	  	public void enterStationFrom(){
		bp.enterStationFrom(From);
	  	}
	  	@Test
	  	public void enterStationTill(){
	  	bp.enterStationTill(Till);
	  	}
	  	@Test
	  	public void enterDate(){
	  	bp.enterDate();
	  	}
	  	@Test
	  	public void submitButtonSearch(){
	  	bp.submitButtonSearch();
	  	}
	  	@Test
	  	public void verifyTrainsTabelEnabled(){
	  	bp.verifyTrainsTabelEnabled();
	  	}
	  	@Test (dependsOnMethods ="verifyTrainsTabelEnabled")
	  	@Stories("Verify count of trains which we can see")
	  	public void verifyTrainsCount(){
	  	bp.verifyTrainsCount();
	  	}
	  	
	  	@Test (dependsOnMethods ="verifyTrainsCount")
	  	@Stories("Presence verifying the train with number 115 O")
	  	public void verifyFirstTrainPresent(){
	  	bp.verifyTrainPresent(FirstTrain);
	  	}
	  	
	  	@Test (dependsOnMethods ="verifyFirstTrainPresent")
	  	@Stories("Verify suite seat availability on train number 115 O")
	  	public void verifyFreeSuitePlacesFor115(){
		bp.verifyFreeSuitePlacesFor115();
	  	}
	  	@Test (dependsOnMethods ="verifyFirstTrainPresent")
	  	@Stories("Verify coupe seat availability on train number 115 O")
	  	public void verifyFreeCoupePlacesFor115(){
		bp.verifyFreeCoupePlacesFor115();
	  	}
	  	@Test (dependsOnMethods ="verifyFirstTrainPresent")
	  	@Stories("Verify berth seat availability on train number 115 O")
	  	public void verifyFreeBerthPlacesFor115(){
		bp.verifyFreeBerthPlacesFor115();
	  	}
	  	
	  	@Test (dependsOnMethods ="verifyTrainsCount")
	  	@Stories("Presence verifying the train with number 043 K")
	  	public void verifySecondTrainPresent(){
	  	bp.verifyTrainPresent(SecondTrain);
	  	}
	  	
	  	@Test (dependsOnMethods ="verifySecondTrainPresent")
	  	@Stories("Verify suite seat availability on train number 043 K")
	  	public void verifyFreeSuitePlacesFor043(){
		bp.verifyFreeSuitePlacesFor043();
	  	}
	  	@Test (dependsOnMethods ="verifySecondTrainPresent")
	  	@Stories("Verify coupe seat availability on train number 043 K")
	  	public void verifyFreeCoupePlacesFor043(){
			bp.verifyFreeCoupePlacesFor043();
	  	}
	  	@Test (dependsOnMethods ="verifySecondTrainPresent")
	  	@Stories("Verify berth seat availability on train number 043 K")
	  	public void verifyFreeBerthPlacesFor043(){
			bp.verifyFreeBerthPlacesFor043();
	  	}
	  	
	  	@Test (dependsOnMethods ="verifyTrainsCount")
	  	@Stories("Presence verifying the train with number 143 K")
	  	public void verifyThirdTrainPresent(){
	  	bp.verifyTrainPresent(ThirdTrain);
	  	}
	  	
	  	@Test (dependsOnMethods ="verifyThirdTrainPresent")
	  	@Stories("Verify seat availability on train number 143 K")
	  	public void verifyFreeSuitePlacesFor143(){
		bp.verifyFreeSuitePlacesFor143();
	  	}
	  	@Test (dependsOnMethods ="verifyThirdTrainPresent")
	  	@Stories("Verify seat availability on train number 143 K")
	  	public void verifyFreeCoupePlacesFor143(){
	  	bp.verifyFreeCoupePlacesFor143();
	  	}
	  	@Test (dependsOnMethods ="verifyThirdTrainPresent")
	  	@Stories("Verify berth seat availability on train number 143 K")
	  	public void verifyFreeBerthPlacesFor143(){
	  	bp.verifyFreeBerthPlacesFor143();
	  	}
	  	
		@AfterClass
		public void shutDown() {
		driver.quit();
		}
}
