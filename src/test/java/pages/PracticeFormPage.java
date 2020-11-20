package pages;

import com.codeborne.selenide.SelenideElement;
import users.User;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    User user;

    public PracticeFormPage(User user) {
        this.user = user;
    }

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstName() {
        $(("#firstName")).val(user.getFirstName());
    }

    public void fillLastName() {
        $(("#lastName")).val(user.getLastName());
    }

    public void fillEmail() {
        $(("#userEmail")).val(user.getEmail());
    }

    public void fillMobileNumber() {
        $(("#userNumber")).val(user.getMobileNumber());
    }

    public void selectGender() {
        $(byText(user.getGender())).click();
    }

    public void selectDateOfBirth() {
        $(("#dateOfBirthInput")).click();
        $(".react-datepicker__year-select").selectOption(user.getYearOfBirth());
        $(".react-datepicker__month-select").selectOption(user.getMonthOfBirth());
        if (Integer.parseInt(user.getDayOFBirth()) < 10) {
            $(".react-datepicker__day--00" + user.getDayOFBirth()).click();
        } else {
            $(".react-datepicker__day--0" + user.getDayOFBirth()).click();
        }
    }

    public void selectSubject() {
        $(("#subjectsInput")).val(user.getSubjectName().substring(0, 1));
        $(byText(user.getSubjectName())).click();
    }

    public void selectHobby() {
        $(byText(user.getHobby())).click();
    }

    public void uploadPhoto() {
        $(("#uploadPicture")).uploadFile(new File("src/test/resources/" + user.getPhotoFileName()));
    }

    public void fillCurrentAddress() {
        $(("#currentAddress")).val(user.getAddress());
    }

    public void selectState() {
        $(byText("Select State")).scrollTo().click();
        $(byText(user.getState())).click();
    }

    public void selectCity() {
        $(byText("Select City")).scrollTo().click();
        $(byText(user.getCity())).click();
    }

    public void clickSubmitButton() {
        $(("#submit")).click();
    }

    public void checkSubmitForm() {
        for (Map.Entry<String, String> entry: getTableRows().entrySet()) {
            checkSubmitTableRow(entry.getKey()).shouldHave(textCaseSensitive(entry.getValue()));
        }
    }

    private SelenideElement checkSubmitTableRow(String rowName) {
        return $x("//td[text()='" + rowName + "']").sibling(0);
    }

    private Map<String, String> getTableRows() {
        Map<String, String> rows = new LinkedHashMap<>();
        rows.put("Student Name", user.getStudentName());
        rows.put("Student Email", user.getEmail());
        rows.put("Gender", user.getGender());
        rows.put("Mobile", user.getMobileNumber());
        rows.put("Date of Birth", user.getDateOfBirth());
        rows.put("Subjects", user.getSubjectName());
        rows.put("Picture", user.getPhotoFileName());
        rows.put("Address", user.getAddress());
        rows.put("State and City", user.getStateAndCity());
        return rows;
    }
}
