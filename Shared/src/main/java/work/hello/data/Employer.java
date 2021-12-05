package work.hello.data;


/**
 * The type Employer.
 */
public class Employer extends User {
    private String companyName;
    private String address;

    /**
     * Instantiates a new Employer.
     *
     * @param email       the email
     * @param password    the password
     * @param phoneNumber the phone number
     * @param companyName the company name
     * @param address     the address
     */
    public Employer(String email, String password, String phoneNumber, String companyName, String address) {
        super(email, "Employer", password, phoneNumber);
        this.companyName = companyName;
        this.address = address;
    }

    /**
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * From json employer.
     *
     * @param json the json
     * @return the employer
     */
    public static Employer fromJson(String json) {
        return gson.fromJson(json, Employer.class);
    }

    @Override
    public String toJson() {
        return gson.toJson(this);

    }
}
