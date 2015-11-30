package bookingTest;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;

public class ElementSearchButton {

	@Name("Search Button")
    @FindBy(xpath = ".//*[@id='content']/form/p/button")
    private SearchButton searchButton;
    
    public void clickSearchButton(String request) {
    	searchButton.click();
        }
}
