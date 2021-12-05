package work.hello.data;

import com.google.gson.Gson;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * The type User.
 */
public class User {
    private String email;
    private String role;
    private String password;
    private String phoneNumber;
    /**
     * The Gson.
     */
    static final Gson gson = new Gson();

    /**
     * Instantiates a new User.
     *
     * @param email       the email
     * @param role        the role
     * @param password    the password
     * @param phoneNumber the phone number
     */
    public User(String email, String role, String password, String phoneNumber) {
        this.email = email;
        this.role = role;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new User.
     *
     * @param email    the email
     * @param password the password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJson() {
        return gson.toJson(this);
    }

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    public boolean validate() {
        boolean result = EmailValidator.getInstance().isValid(email);
        return result;
    }

    /**
     * From json user.
     *
     * @param user the user
     * @return the user
     */
    public static User fromJson(String user) {
        return gson.fromJson(user, User.class);
    }

}
