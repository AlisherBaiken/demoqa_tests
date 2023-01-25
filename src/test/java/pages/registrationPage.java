package pages;

import com.codeborne.selenide.SelenideElement;
import pages.companents.CalendarCompanents;
import pages.companents.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class registrationPage {
    private CalendarCompanents calendarCompanents = new CalendarCompanents();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput =   $("#firstName"),
            lastNameInput =  $("#lastName"),
            emailInput =  $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber");

    public registrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); // delete reklama
        executeJavaScript("$('footer').remove()"); // delete footer
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public registrationPage setFirstName(String value){
        firstNameInput .setValue(value);
        return this;
    }
    public registrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public registrationPage clearLastName(){
        lastNameInput.clear();
        return this;
    }
    public registrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public registrationPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }
    public registrationPage setPhone(String value){
        phoneInput.setValue(value);
        return this;
    }
    public registrationPage setBirthday(String day, String month, String  year){
        $("#dateOfBirthInput").click();
        calendarCompanents.setDate(day, month, year);
        return this;
    }
    public registrationPage verifyResultModalAppear(){
        registrationResultModal.verifyModalAppear();
        return this;
    }
    public registrationPage verifyResult(String key, String value){
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
