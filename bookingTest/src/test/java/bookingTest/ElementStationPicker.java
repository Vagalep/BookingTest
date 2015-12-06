package bookingTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementStationPicker extends HtmlElement {

	@Name("Input field")
    @FindBy(xpath = ".//input")
    private WebElement inputField;

    @Name("List with proposed options")
    @FindBy(xpath=".//*[@title]")
    private List<WebElement> stationsPodskazki;

    @Step
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