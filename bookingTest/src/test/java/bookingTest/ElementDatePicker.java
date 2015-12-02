package bookingTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementDatePicker extends HtmlElement {
    
    @FindBy(xpath = "./caption[contains(text(), 'December 2015')]/parent::table//td[@class!='blank' and @class!='disabled']")
    private List<WebElement> allDate;
    
   // @FindBy(xpath = "//table[@class='month']/caption")
   // private List<WebElement> allMonth;
   
	Locale local = new Locale("en","EN");
	SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy", local); 
	Date currentDate = new Date();
	String[] dayMonthYear = sdf.format(currentDate).split(" ");

	//this.click();
	
	//table[@class='month']/caption[contains(text(), 'December 2015')]//td[@class!='blank' and @class!='disabled']
	
	//MyField = driver.findElement(By.xpath("//select/option[contains(text(), '" + ClientHost + "')]"))
	
	Integer dayAfterTomorrow = (Integer.valueOf(dayMonthYear[0]) + 2);

	String dayAfterTomorrowS = String.valueOf(dayAfterTomorrow);
	
	String monhtYear = (dayMonthYear[1] + " " + dayMonthYear[2]);
    
    public void chooseDateFromList() {

    	
    		for (WebElement item : allDate) {
        		if (item.getText().equals(dayAfterTomorrowS));
        		item.click();
        		break;
    		}
    	}
   
    	
    	 /*	
    	for (WebElement itemMY : allMonth) {
    		if (itemMY.getText().equals(monhtYear));
    		for (WebElement item : allDate) {
        		if (item.getText().equals(dayAfterTomorrow));
        		item.click();
        		break;
    		}
    	}
    		
   	for (WebElement item : allDate) {
    		if (item.getText().equals(dayMonthYear[0]));
    		if (item.getAttribute("class").equals("selected"))
    		item.click();
    		break;
    		}
    	}
    	*/
    }