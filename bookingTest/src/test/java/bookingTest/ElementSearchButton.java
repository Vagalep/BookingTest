package bookingTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ElementSearchButton extends HtmlElement {

    @FindBy(xpath = "//*[@id='content']/form/p/button")
    private WebElement searchButton;
    
    public void clickSearchButton() {
    	searchButton.click();
        }
}
