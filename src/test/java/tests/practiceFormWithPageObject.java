package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.registrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class practiceFormWithPageObject extends TestBase {


    @Test
    void fillPracticeForm() {
        String userName = "Alex";
        RegistrationPage.openPage();
        RegistrationPage.setFirstName(userName);
        RegistrationPage.setLastName("Baikenov");
        RegistrationPage.setEmail("123@mail.ru");
        RegistrationPage.setGender("Male");
        RegistrationPage.setPhone("8777777777");

       // dalee takje obrabotat
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
        $(".table-responsive").shouldHave(text(userName), text("Baikenov"),
                text("123@mail.ru"), text("8777777777")); // i togdalee
    }

    @Test
    void fillPractice2Form() {
        String userName = "Alex";
        RegistrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Baikenov")
                .setEmail("123@mail.ru")
                .setGender("Male")
                .setPhone("8777777777")
                .setBirthday("30","July","2008")
                .setSubject("Math")
                .setHobbies("Reading")
                .uploadPicturue("img/1.png")
                .setCurrentAddress("Alatau")
                .setState("NCR")
                .setCity("Noida")
                .clickSumbit();
        RegistrationPage.verifyResultModalAppear()
                .verifyResult("Student Name", userName + " Baikenov")
                .verifyResult("Student Email", "123@mail.ru") // mojem proverit vse
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8777777777")
                .verifyResult("Date of Birth", "30 July,2008");

    }
}
