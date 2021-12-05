package work.hello.data;

/**
 * The type Job seeker.
 */
public class JobSeeker extends User {
    private String firstName;
    private String lastName;

    /**
     * Instantiates a new Job seeker.
     *
     * @param email       the email
     * @param password    the password
     * @param phoneNumber the phone number
     * @param firstName   the first name
     * @param lastName    the last name
     */
    public JobSeeker(String email, String password, String phoneNumber, String firstName, String lastName) {
        super(email, "JobSeeker", password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * From json job seeker.
     *
     * @param json the json
     * @return the job seeker
     */
    public static JobSeeker fromJson(String json) {
        return gson.fromJson(json, JobSeeker.class);
    }

    @Override
    public String toJson() {
        return gson.toJson(this);

    }
}
