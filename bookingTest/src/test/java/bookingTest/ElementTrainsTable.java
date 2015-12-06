package bookingTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementTrainsTable extends HtmlElement{

	@FindBy (xpath=".//td[@class='num']/a")
	List<WebElement> poezdaTable;
	
	public int trainsCount(){
		return poezdaTable.size();
	}
    
	public boolean trainNumber(String value){
		for(WebElement item: poezdaTable){
		if(item.getText().contains(value)) return true;
		}	
	return false;	
	}
}
    
