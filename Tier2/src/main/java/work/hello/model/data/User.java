package work.hello.model.data;

import com.google.gson.Gson;
import org.apache.commons.validator.routines.EmailValidator;

public class User {
    private String email;
    private String role;
    private String password;
    private String phoneNumber;
    static final Gson gson = new Gson();

    public User(String email, String role, String password, String phoneNumber) {
        this.email = email;
        this.role = role;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public boolean validate() {
        boolean result = EmailValidator.getInstance().isValid(email);
        return result;
    }

    public static User fromJson(String user) {
        return gson.fromJson(user, User.class);
    }

}
