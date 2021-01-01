package calisma;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Test02 {

    String url1 = "http://opencart.abstracta.us/";
    @Test
    public void test01(){
        // getOwnText, text
        open(url1);

        String input = "input[name='search']";
        By products = By.cssSelector("div.product-layout");

        $(input).shouldBe(Condition.visible).setValue("a").pressEnter();

        for (SelenideElement e : $$ (products)){
            e.scrollTo().hover();
            System.out.println("own text : " + e.getOwnText());
            System.out.println("full text : " + e.text());
        }

        sleep(3000);

    }

    @Test
    public void test02(){
        // $$().filter(condition)
        open(url1);

        String input = "input[name='search']";
        By products = By.cssSelector("div.product-layout");

        $(input).shouldBe(Condition.visible).setValue("a").pressEnter();

        for (SelenideElement e : $$ (products).filter(Condition.text("processor"))){
            e.scrollTo().hover().contextClick();
            System.out.println("own text : " + e.getOwnText());
            System.out.println("full text : " + e.text());

        }
        System.out.println("products : " + $$ (products).size());
        System.out.println("products filter by processor : " + $$ (products).filter(Condition.text("processor")).size());
        sleep(3000);

    }

    @Test
    public void test03(){
        // selectOption
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwListBox");

        String select = "select[id='gwt-debug-cwListBox-multiBox']";

        $(select)
                .shouldBe(Condition.appear)
                .scrollTo()
                .selectOption("sedan", "SUV");

        sleep(3000);

    }

    @Test
    public void test04(){
        // $(selector, n)
        open(url1);

        String input = "input[name='search']";
        By products = By.cssSelector("div.product-layout");

        $(input).shouldBe(Condition.visible).setValue("a").pressEnter();

        SelenideElement e = $(products,2);
        System.out.println(e.text());

        ElementsCollection ec = $$(products);
        System.out.println(ec.get(2).text());

        sleep(3000);

    }
}
