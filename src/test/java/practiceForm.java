import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class practiceForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fillPracticeForm(){
        String userName = "Alex";
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); // delete reklama
        executeJavaScript("$('footer').remove()"); // delete footer
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue("Baikenov");
        $("#userEmail").setValue("123@mail.ru");
        $("[for=gender-radio-1]").click(); // good way
        $("#genterWrapper").$(byText("Male")).click(); // po yazykam ne proidet good way
        $("#userNumber").setValue("8777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click(); // po yazykam ne proidet good way
        $("#uploadPicture").uploadFromClasspath("img/1.png");// esli fail v resurce
        $("#currentAddress").setValue("Alatau");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName),text("Baikenov"),
                text("123@mail.ru"),text("8777777777")); // i togdalee






        ;



    }
}
