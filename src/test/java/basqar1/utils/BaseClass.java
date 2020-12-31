package basqar1.utils;

import basqar1.model.Locators1;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.$;

public class BaseClass implements Locators1 {

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
        $(DIALOG_CONFIRM_YES).shouldBe(Condition.enabled).click();
    }

    public void notify(Notification notification){
        $(NOTIFICATION_CONTAINER).should(appears).shouldHave(Condition.text(notification.toString()));
    }
}
