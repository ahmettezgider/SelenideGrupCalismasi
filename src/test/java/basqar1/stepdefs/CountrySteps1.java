package basqar1.stepdefs;

import basqar1.pages.CountryPage1;
import basqar1.model.Locators1;
import basqar1.pages.HomePage1;
import basqar1.utils.BaseClass;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static basqar1.utils.Notification.*;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CountrySteps1 extends BaseClass implements Locators1 {
    HomePage1 hp = new HomePage1();
    CountryPage1 cp;


    @Given("^user logged in to basqar$")
    public void userLoggedInToBasqar() {
        hp.getPage();
        hp.login();
    }

    @When("^user navigate to countries page$")
    public void userNavigateToCountriesPage() {
        cp = hp.gotoCountries();
    }

    @Then("^countries page should be visible$")
    public void countriesPageShouldBeVisible() {
        //$$(COUNTRIESHEADER).shouldBe(CollectionCondition.sizeGreaterThan(1));
        $$(getSelector("Countries")).shouldBe(CollectionCondition.sizeGreaterThan(1));
    }

    @And("^user click to AddButton on country page$")
    public void userClickToAddButtonOnCountryPage() {
        hp.clickToAddButton();
        Selenide.screenshot("addButtonSonrasi");
    }

    @When("^user create a country as follows$")
    public void userCreateACountryAsFollows(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        cp.addCountry(list.get(0), list.get(1));
    }

    @Then("^creation should be successful$")
    public void creationShouldBeSuccessful() {
        notify(created);
        //$(NOTIFICATION_CONTAINER).should(appears).shouldHave(Condition.text("created"));

    }

    @When("^user edit \"([^\"]*)\"$")
    public void userEdit(String name)  {
        edit(name);
    }

    @And("^close dialog$")
    public void closeDialog() {
        $(DIALOG_CLOSE_BUTTON).shouldBe(enabled).click();
        $(NOTIFICATION_CONTAINER).screenshot();
    }

    @When("^user delete \"([^\"]*)\"$")
    public void userDelete(String name) {
        delete(name);
    }

    @Then("^data should be deleted$")
    public void dataShouldBeDeleted() {
        notify(deleted);
        $(NOTIFICATION_CONTAINER).screenshot();
        //$(NOTIFICATION_CONTAINER).should(appears).shouldHave(Condition.text("deleted"));
    }
}
