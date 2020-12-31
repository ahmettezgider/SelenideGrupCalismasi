package basqar1.pages;

import basqar1.model.Locators1;
import basqar1.utils.BaseClass;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CountryPage1 extends BaseClass implements Locators1 {



    public void addCountry(String name, String code){
        $(FORM_NAME).setValue(name);
        $(FORM_CODE).setValue(code);
        $(FORM_SAVE_BUTTON).click();
    }

}
