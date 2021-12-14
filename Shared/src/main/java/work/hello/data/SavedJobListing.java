package work.hello.data;
import com.google.gson.Gson;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * The type Saved job listing.
 */
public class SavedJobListing {
    /**
     * The Email.
     */
    public String Email;
    /**
     * The Job id.
     */
    public int JobId;
    /**
     * The Id.
     */
    public int Id;
    private static final Gson gson = new Gson();


    /**
     * Instantiates a new Saved job listing.
     *
     * @param email the email
     * @param JobId the job id
     * @param Id    the id
     */
    public SavedJobListing(String email, int JobId,int Id)
    {
        this.Email = email;
        this.JobId = JobId;
        this.Id = Id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * Gets job id.
     *
     * @return the job id
     */
    public int getJobId() {
        return JobId;
    }

    /**
     * Sets job id.
     *
     * @param jobId the job id
     */
    public void setJobId(int jobId) {
        JobId = jobId;
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJson() {
        return gson.toJson(this);
    }

    public boolean validate()
    {
        return EmailValidator.getInstance().isValid(Email) && JobId != 0 && Id != 0;
    }

    public static SavedJobListing fromJson(String json) {
        SavedJobListing savedJobListing = gson.fromJson(json, SavedJobListing.class);
        return savedJobListing;
    }
}
