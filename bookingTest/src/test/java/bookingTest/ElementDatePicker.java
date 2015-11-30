package bookingTest;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ElementDatePicker {

    @Name("Date input")
    @FindBy(xpath = ".//*[@id='date_dep']")
    private DateInput dateInput;
    
    public void enterDateString(String request) {
    	dateInput.sendKeys(request).click();
        }
}
