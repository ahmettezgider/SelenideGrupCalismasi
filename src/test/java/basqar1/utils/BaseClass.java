package basqar1.utils;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseClass {

    public By getSelector(String name){
        return By.xpath("//mat-toolbar//*[contains(text(),'" + name + "')]");
    }

    public void edit(String name){
        $(By.xpath("//*[text()='" + name + "']//parent::tr//ms-edit-button"))
                .shouldBe(Condition.enabled).click();
    }

    public void delete(String name){
        $(By.xpath("//*[text()='" + name + "']//parent::tr//ms-delete-button"))
                .shouldBe(Condition.enabled).click();
        // confirm, reject
    }
}
