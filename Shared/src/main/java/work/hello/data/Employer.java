package work.hello.data;


public class Employer extends User {
    private String companyName;
    private String address;

    public Employer(String email,  String password, String phoneNumber, String companyName, String address) {
        super(email, "Employer", password, phoneNumber);
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toJson() {
        return gson.toJson(this);

    }
}
