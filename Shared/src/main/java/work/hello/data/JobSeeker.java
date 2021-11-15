package work.hello.data;

public class JobSeeker extends User {
    private String firstName;
    private String lastName;

    public JobSeeker(String email,  String password, String phoneNumber, String firstName, String lastName) {
        super(email, "JobSeeker", password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toJson(){
        return gson.toJson(this);

    }
}
