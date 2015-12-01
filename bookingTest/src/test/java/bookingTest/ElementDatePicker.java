package bookingTest;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementDatePicker extends HtmlElement {
    
    @FindBy(xpath = ".//table[@class='month']//td[@class!='blank' and @class!='disabled']")
    private List<WebElement> allDate;
   
    public void chooseDateFromList() {
    	this.click();
    	for (WebElement item : allDate) {
    		if ( item.getAttribute("class").equals("selected"))
    		item.click();
    		break;
    		}
    	}
}