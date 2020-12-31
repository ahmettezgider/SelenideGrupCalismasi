package basqar1.stepdefs;

import basqar1.model.Locators1;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginSteps implements Locators1 {

    @Given("^user on homepage$")
    public void userOnHomepage() {
        Configuration.browserSize = "700x600";
        open(URL);
    }

    @When("^user login with user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLoginWithUserNameAsAndPasswordAs(String username, String password)  {

        $(USERNAME).shouldBe(Condition.appear).setValue(username);
        $(PASSWORD).setValue(password).pressEnter();
        if ($(GOTIT).isDisplayed())
            $(GOTIT).click();

    }

    @Then("^login should be successfull$")
    public void loginShouldBeSuccessfull() {
        $(USERBELL).shouldBe(Condition.appear);
    }

}
