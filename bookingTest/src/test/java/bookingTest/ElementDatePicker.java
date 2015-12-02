package bookingTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementDatePicker extends HtmlElement {
    
    @FindBy(xpath = "//*[@class='rui-calendar rui-panel']")
    WebElement calendarTable;
   
	Locale local = new Locale("en","EN");
	SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy", local); 
	Date currentDate = new Date();
	
	String[] dayMonthYear = sdf.format(currentDate).split(" ");
	Integer dayAfterTomorrow = (Integer.valueOf(dayMonthYear[0]) + 2);
	String dayAfterTomorrowS = String.valueOf(dayAfterTomorrow);
	String monhtYear = (dayMonthYear[1] + " " + dayMonthYear[2]);
    
    public void chooseDateFromList() {

    	List<WebElement> allDate = calendarTable.findElements(By.xpath(String.format(".//caption[contains(text(), '%s')]//td[@class!='blank' and @class!='disabled']", monhtYear)));
    	
    	 for (WebElement item : allDate) {
    	     if (item.getText().equals(dayAfterTomorrowS));
    	     item.click();
    	     break;
    	 }

    }
}