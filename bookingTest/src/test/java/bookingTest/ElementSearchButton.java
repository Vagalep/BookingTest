package bookingTest;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementSearchButton extends HtmlElement {
   
	@Step
    public void clickSearchButton() {
    	this.click();
        }
}
