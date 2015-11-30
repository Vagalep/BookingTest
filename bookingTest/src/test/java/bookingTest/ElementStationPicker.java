package bookingTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ElementStationPicker extends HtmlElement {

    @Name("Search Station input")
    @FindBy(xpath = ".//input")
    private TextInput requestInput;

    @Name("Suggestions list")
    @FindBy(xpath = ".//div[@title]")
    private List<WebElement> suggestinosList;

    public void enterSearchString(String request) {
	requestInput.sendKeys(request);
	suggestinosList.get(0).click();
    }

    public void enterStringWithSuggestions(String request) {

	requestInput.sendKeys(request.length() < 5 ? request : request.substring(0, 5));

	for (WebElement item : suggestinosList) {
	    if (item.getAttribute("title").equals(request)) {
		item.click();
		break;
	    }
	}

    }

}