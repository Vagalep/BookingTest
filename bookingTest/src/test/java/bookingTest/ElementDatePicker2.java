package bookingTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementDatePicker2 extends HtmlElement {
    
    @FindBy(xpath = ".//parent::table//td[@class!='blank' and @class!='disabled']")
    List<WebElement> calendarTable;

    public void chooseDateFromList() {

    	 for (WebElement item : calendarTable) {
    	     if (item.getAttribute("class").equals("selected")){
    	     item.click();
    	     break;
    	     }
    	 }	

    }
}