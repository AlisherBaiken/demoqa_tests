import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class practiceForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2060x1400";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fillPracticeForm(){
        String userName = "Alex";
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue("Baikenov");
        $("#userEmail").setValue("123@mail.ru");
//        $("#gender-radio-1").click(); wrong way ne ckicknet
//        $("#gender-radio-1").parent().click(); // good way
        $("[for=gender-radio-1]").click(); // good way
        $("#genterWrapper").$(byText("Male")).click(); // po yazykam ne proidet good way
        $("#userNumber").setValue("8777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue("6"); same as july

        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click(); // po yazykam ne proidet good way

        $("#uploadPicture").uploadFromClasspath("img/1.png");// esli fail v resurce
        //        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Alatau");





        ;



    }
}
