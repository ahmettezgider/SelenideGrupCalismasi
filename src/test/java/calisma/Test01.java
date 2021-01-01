package calisma;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Test01 {

    @Test
    public void test1(){

        /*
            open(url);
            $("selector").doAction();
            $("selector").check(condition);
         */

        // driver.get("http://opencart.abstracta.us/")

        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
        //Configuration.browserSize = "600x300";

        open("http://opencart.abstracta.us/");
        sleep(5000);
        zoom(0.9);
        sleep(5000);

    }

    @Test
    public void test2(){
        Configuration.startMaximized = true;
        open("http://opencart.abstracta.us/");

        /*
            $ == driver.findElement()
            $ -> ilk element döner, 4 sn bekleme süresi
            $$(selector) == driver.findElements(selector) --> List

            Assertions
            $().should()            $().shouldNot()
            $().shouldBe()          $().shouldNotBe()
            $().shouldHave()        $().shouldNotHave()
         */
        By products = By.cssSelector("div.product-layout");
        $(By.cssSelector("input[name='search']")).setValue("mac");
        $(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        $$(products).shouldBe(CollectionCondition.sizeGreaterThan(30));

        sleep(5000);
    }


    @Test
    public void test3(){
        Configuration.startMaximized = true;
        open("http://opencart.abstracta.us/");

        // $(String selector) --> cssSelector

        String input = "input[name='search']";
        By products = By.cssSelector("div.product-layout");

        $(input).setValue("mac").pressEnter();
        System.out.println($$(products).size());


        //$$(products).get(0).hover().contextClick();

        $$(products).get(0).scrollIntoView(true).hover().contextClick();


        sleep(5000);
    }

    @Test
    public void test4(){
        Configuration.startMaximized = true;
        open("http://opencart.abstracta.us/");

        String input = "input[name='search']";
        By products = By.cssSelector("div.product-layout");

        //$(input).shouldBe(Condition.appear).setValue("mac").pressEnter();

        $(input).waitUntil(Condition.appear, 10000).setValue("mac").pressEnter();

        System.out.println($$(products).size());
        sleep(5000);
    }


    @Test
    public void test5(){

        String url = "https://test.basqar.techno.study/";
        String kullanici = "daulet2030@gmail.com";
        String sifre = "TechnoStudy123@";

        open(url);
        $("input[formcontrolname='username']")
                .shouldBe(Condition.appear)
                .setValue(kullanici);
        $("input[formcontrolname='password']")
                .setValue(sifre).pressEnter();


        if ($(By.partialLinkText("Got it")).isEnabled()){
            $(By.partialLinkText("Got it")).click();
        }

        $("user-message-bell").shouldBe(Condition.exist);

        zoom(0.7);
        sleep(5000);


    }


}
