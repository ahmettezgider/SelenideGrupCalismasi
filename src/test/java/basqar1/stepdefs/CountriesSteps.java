package basqar1.stepdefs;

import basqar1.model.Locators1;
import basqar1.utils.BaseClass;
import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.$;

public class CountriesSteps extends BaseClass implements Locators1 {

    @Given("^on countries page$")
    public void onCountriesPage() {
        if (!$(ToggleSideBarFolded).isDisplayed())
            $(NavbarToggleButton).shouldBe(Condition.appear).click();
        $(SETUP1).shouldBe(Condition.visible).click();
        $(PARAMETERS1).shouldBe(Condition.visible).click();
        $(COUNTRIES).shouldBe(Condition.visible).click();
    }

    @When("^user click to AddButton$")
    public void userClickToAddButton() {
        $(ADDBUTTON).shouldBe(Condition.enabled).click();
    }

    @Then("^dialog form should be visible$")
    public void dialogFormShouldBeVisible() {

        $(DIALOGCONTAINER).shouldBe(Condition.visible);
        //edit("Country-001");
        //$("").shouldHave(Condition.attribute("color", "#12121323"));

    }
}
