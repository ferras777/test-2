package users;

public class User {

    private static int countOfUsers = 0;

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobileNumber;
    private final String gender;
    private final String subjectName;
    private final String hobby;
    private final String address;
    private final String state;
    private final String city;
    private final String dayOFBirth;
    private final String monthOfBirth;
    private final String yearOfBirth;

    public User(String firstName, String lastName, String email, String mobileNumber, String gender,
                String subjectName, String hobby, String address, String state, String city, String day, String month,
                String year) {
        countOfUsers++;
        this.id = countOfUsers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.subjectName = subjectName;
        this.hobby = hobby;
        this.address = address;
        this.state = state;
        this.city = city;
        this.dayOFBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
    }

    public String getPhotoFileName() {
        return this.id + ".png";
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getDayOFBirth() {
        return dayOFBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getStudentName() {
        return this.firstName + " " + this.lastName;
    }

    public String getDateOfBirth() {
        return this.getDayOFBirth() + " " + this.getMonthOfBirth() + "," + this.getYearOfBirth();
    }

    public String getStateAndCity() {
        return this.getState() + " " + this.getCity();
    }
}
