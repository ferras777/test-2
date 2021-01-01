package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import users.User;

import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class CheckPracticeFormFillTest extends TestBase {

    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    User user = new User(faker.name().firstName(), faker.name().lastName(),
            fakeValuesService.bothify("????##@gmail.com"), fakeValuesService.regexify("[0-9]{10}"),
            "Male", "Arts", "Sports", faker.address().fullAddress(), "Haryana",
            "Karnal", "25", "June", "1992");

    PracticeFormPage practiceFormPage = new PracticeFormPage(user);

    @Test
    public void checkPracticeFormFillTest() {

        step("Open students registration form", () -> practiceFormPage.openPage());

        step("Fill submit form", () -> {
            practiceFormPage.fillFirstName();
            practiceFormPage.fillLastName();
            practiceFormPage.fillEmail();
            practiceFormPage.selectGender();
            practiceFormPage.fillMobileNumber();
            practiceFormPage.selectDateOfBirth();
            practiceFormPage.selectSubject();
            practiceFormPage.selectHobby();
            practiceFormPage.uploadPhoto();
            practiceFormPage.fillCurrentAddress();
            practiceFormPage.selectState();
            practiceFormPage.selectCity();
            practiceFormPage.clickSubmitButton();
        });

        step("Check results", () -> practiceFormPage.checkSubmitForm());
    }
}
