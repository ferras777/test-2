package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import users.User;

public class CheckPracticeFormFillTest {

    User user = new User("James", "Dow", "test@test.com", "1234567890",
            "Male", "Arts", "Sports", "NY Street", "Haryana", "Karnal"
            , "25", "June", "1992");

    PracticeFormPage practiceFormPage = new PracticeFormPage(user);

    @Test
    public void checkPracticeFormFillTest() {
        practiceFormPage.openPage();
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

        practiceFormPage.checkSubmitForm();
    }
}
