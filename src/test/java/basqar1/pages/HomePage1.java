package basqar1.pages;

import basqar.pages.CityPage;
import basqar.pages.CountryPage;
import basqar1.model.Locators1;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class HomePage1 implements Locators1 {

    public void getPage(){
        open(URL);
    }

    public void login(){

        $(USERNAME).shouldBe(Condition.appear).setValue(KULLANICI);

        $(PASSWORD).setValue(SIFRE).pressEnter();

        if ($(GOTIT).isEnabled()){
            $(GOTIT).click();
        }

        $(USERBELL).shouldBe(Condition.exist);
    }

    public void clickToAddButton(){
        $(ADDBUTTON).shouldBe(Condition.enabled).click();
    }

    public CountryPage1 gotoCountries(){
        if (!$(ToggleSideBarFolded).isDisplayed())
            $(NavbarToggleButton).shouldBe(Condition.appear).click();
        $(SETUP1).shouldBe(Condition.visible).click();
        $(PARAMETERS1).shouldBe(Condition.visible).click();
        $(COUNTRIES).shouldBe(Condition.visible).click();
        return new CountryPage1();
    }

    public CityPage gotoCities(){
        System.out.println("city page gittim");
        return new CityPage();
    }



}
