package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest(){
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue("Alisher Baikenov");
        $("#userEmail").setValue("123@mail.ru");
        $("#currentAddress").setValue("Almaty");
        $("#permanentAddress").setValue("Alatau");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("Alisher Baikenov"));
        $("#output #email").shouldHave(text("123@mail.ru"));

    }
}
