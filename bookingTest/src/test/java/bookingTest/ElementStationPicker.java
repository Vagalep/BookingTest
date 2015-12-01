package bookingTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementStationPicker extends HtmlElement {

    @FindBy(xpath = ".//input")
    private WebElement inputField;

    @FindBy(xpath=".//*[@title]")
    private List<WebElement> stationsPodskazki;

    public void enterStationFromList(String value) {
    inputField.sendKeys(value);
	for (WebElement item : stationsPodskazki) {
	    if (item.getAttribute("title").equals(value)) {
		item.click();
		break;
	    }
	}
    }
}